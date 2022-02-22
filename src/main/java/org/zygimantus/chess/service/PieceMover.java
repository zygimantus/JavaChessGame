package org.zygimantus.chess.service;

import org.springframework.stereotype.Service;
import org.zygimantus.chess.ChessMove;
import org.zygimantus.chess.board.TwoPlayerBoard;
import org.zygimantus.chess.enums.Color;
import org.zygimantus.chess.enums.Piece;
import org.zygimantus.chess.pieces.ChessPiece;

import static org.zygimantus.chess.Consts.*;

@Service
public class PieceMover {

    private final BoardInitializer boardInitializer;
    private final GameTracker gameTracker;

    public PieceMover(BoardInitializer boardInitializer, GameTracker gameTracker) {
        this.boardInitializer = boardInitializer;
        this.gameTracker = gameTracker;
    }

    public ChessMove move(ChessPiece chessPiece, int rank, int file) {

        ChessMove.ChessMoveBuilder chessMoveBuilder = ChessMove.builder();

        boolean isValidMove = false;

        // first check if it is valid color move
        if (!gameTracker.getColorToMove().equals(chessPiece.getColor())) {
            chessMoveBuilder.description(String.format(INVALID_MOVE_X_TO_MOVE_NOW, gameTracker.getColorToMove()));
            return chessMoveBuilder.build();
        }

        // check if rank or file does not escape board boundaries
        if (rank >= NO_OF_RANKS || rank < 0 || file >= NO_OF_RANKS || file < 0) {
            chessMoveBuilder.description(CANNOT_MOVE_OVER_THE_EDGE_OF_BOARD);
            return chessMoveBuilder.build();
        }

        TwoPlayerBoard board = boardInitializer.getBoard();
        ChessPiece[][] squares = board.getSquares();

        // checking if such piece exists
        ChessPiece pickedPiece = boardInitializer.getPiece(chessPiece);
        if (pickedPiece == null) {
            chessMoveBuilder.description(CANNOT_MOVE_NON_EXISTING_PIECE);
            return chessMoveBuilder.build();
        }
        chessPiece.setFirstMove(pickedPiece.isFirstMove());

        // move to same rank and file is invalid
        int currentRank = chessPiece.getRank();
        int currentFile = chessPiece.getFile();
        if (currentRank == rank && currentFile == file) {
            chessMoveBuilder.description(CANNOT_MOVE_TO_THE_SAME_SQUARE);
            return chessMoveBuilder.build();
        }

        // checking if square is occupied
        ChessPiece existingPiece = squares[rank][file];
        boolean capturingMove = existingPiece != null;
        chessMoveBuilder.capturingMove(capturingMove);
        // cannot move a piece on its own piece
        if (capturingMove && chessPiece.getColor().equals(existingPiece.getColor())) {
            chessMoveBuilder.description(CANNOT_MOVE_ON_OWN_PIECE);
            return chessMoveBuilder.build();
        }

        if (chessPiece.getPiece() == Piece.KING) {
            isValidMove = validateKingMove(chessPiece, rank, file);
        }
        if (chessPiece.getPiece() == Piece.PAWN) {
            isValidMove = validatePawnMove(chessPiece, rank, file, capturingMove);
        }
        if (chessPiece.getPiece() == Piece.KNIGHT) {
            isValidMove = validateKnightMove(chessPiece, rank, file);
        }
        if (chessPiece.getPiece() == Piece.ROOK) {
            isValidMove = validateRookMove(chessPiece, rank, file);
        }
        if (chessPiece.getPiece() == Piece.BISHOP) {
            isValidMove = validateBishopMove(chessPiece, rank, file);
        }
        if (chessPiece.getPiece() == Piece.QUEEN) {
            // moving queen is either rook or bishop move
            isValidMove = validateRookMove(chessPiece, rank, file) || validateBishopMove(chessPiece, rank, file);
        }

        if (isValidMove) {
            if (capturingMove) {
                chessMoveBuilder.description(String.format(PIECE_X_WAS_CAPTURED, existingPiece));
                gameTracker.getCurrentChessGame().reducePieceCount(existingPiece.getColor());
            } else {
                chessMoveBuilder.description(VALID_MOVE);
            }

            pickedPiece.setRank(rank);
            pickedPiece.setFile(file);
            pickedPiece.setFirstMove(false);
            squares[rank][file] = pickedPiece;
            squares[currentRank][currentFile] = null;

            gameTracker.endMove(chessPiece.getColor());
        } else {
            chessMoveBuilder.description(INVALID_MOVE);
        }

        chessMoveBuilder.validMove(isValidMove);

        return chessMoveBuilder.build();
    }

    private boolean validateKnightMove(ChessPiece chessPiece, int rank, int file) {
        int currentRank = chessPiece.getRank();
        int currentFile = chessPiece.getFile();

        // moving knight means changing file or rank by +-2 and opposite to +-1
        return Math.abs(currentRank - rank) == 2 && Math.abs(currentFile - file) == 1 ||
                Math.abs(currentFile - file) == 2 && Math.abs(currentRank - rank) == 1;
    }

    private boolean validateRookMove(ChessPiece chessPiece, int rank, int file) {
        int currentRank = chessPiece.getRank();
        int currentFile = chessPiece.getFile();

        // moving rook means keeping either file or rank same
        return currentFile == file || currentRank == rank;
    }

    private boolean validateBishopMove(ChessPiece chessPiece, int rank, int file) {
        int currentRank = chessPiece.getRank();
        int currentFile = chessPiece.getFile();

        // moving bishop is diagonal which is always having same difference of rank and file
        return Math.abs(currentRank - rank) == Math.abs(currentFile - file);
    }

    private boolean validatePawnMove(ChessPiece chessPiece, int rank, int file, boolean capturingMove) {
        int currentRank = chessPiece.getRank();
        int currentFile = chessPiece.getFile();

        boolean validMove = false;
        // pawns move always on same file forwards or backwards (according to color)
        if (chessPiece.getColor() == Color.BLACK) {
            if (currentFile == file && (currentRank + 1 == rank || chessPiece.isFirstMove() && currentRank + 2 == rank)) {
                validMove = true;
            } else if (Math.abs(currentFile - file) == 1 && currentRank + 1 == rank && capturingMove) {
                validMove = true;
            }
        } else {
            if (currentFile == file && (currentRank - 1 == rank || chessPiece.isFirstMove() && currentRank - 2 == rank)) {
                validMove = true;
            } else if (Math.abs(currentFile - file) == 1 && currentRank - 1 == rank && capturingMove) {
                validMove = true;
            }
        }
        return validMove;
    }

    private boolean validateKingMove(ChessPiece chessPiece, int rank, int file) {
        int currentRank = chessPiece.getRank();
        int currentFile = chessPiece.getFile();

        // king moves by one square which is having rank or file changed by 1
        return Math.abs(currentRank - rank) == 1 || Math.abs(currentFile - file) == 1;
    }
}
