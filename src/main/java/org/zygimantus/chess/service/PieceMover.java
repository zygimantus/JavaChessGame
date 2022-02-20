package org.zygimantus.chess.service;

import org.springframework.stereotype.Service;
import org.zygimantus.chess.ChessMove;
import org.zygimantus.chess.Consts;
import org.zygimantus.chess.board.TwoPlayerBoard;
import org.zygimantus.chess.enums.Color;
import org.zygimantus.chess.enums.Piece;
import org.zygimantus.chess.pieces.ChessPiece;

@Service
public class PieceMover {

    private final BoardInitializer boardInitializer;
    private final PieceCaptor pieceCaptor;

    public PieceMover(BoardInitializer boardInitializer, PieceCaptor pieceCaptor) {
        this.boardInitializer = boardInitializer;
        this.pieceCaptor = pieceCaptor;
    }

    public ChessMove move(ChessPiece chessPiece, int rank, int file) {

        ChessMove.ChessMoveBuilder chessMoveBuilder = ChessMove.builder();

        boolean isValidMove = false;

        // first check if rank or file does not escape board boundaries
        if (rank >= Consts.NO_OF_RANKS || rank < 0) {
            return chessMoveBuilder.build();
        }
        if (file >= Consts.NO_OF_RANKS || file < 0) {
            return chessMoveBuilder.build();
        }

        TwoPlayerBoard board = boardInitializer.getBoard();
        ChessPiece[][] squares = board.getSquares();
        ChessPiece existingPiece = squares[rank][file];

        // checking if such piece exists
        ChessPiece pickedPiece = boardInitializer.getPiece(chessPiece);
        if (pickedPiece == null) {
            return chessMoveBuilder.build();
        }

        // move to same rank and file is invalid
        int currentRank = chessPiece.getRank();
        int currentFile = chessPiece.getFile();
        if (currentRank == rank && currentFile == file) {
            return chessMoveBuilder.build();
        }

        // checking if square is occupied
        boolean capturingMove = existingPiece != null;
        chessMoveBuilder.capturingMove(capturingMove);
        // cannot move a piece on its own piece
        if (capturingMove && chessPiece.getColor().equals(existingPiece.getColor())) {
            return chessMoveBuilder.build();
        }

        if (chessPiece.getPiece() == Piece.KING) {
            isValidMove = validateKingMove(chessPiece, rank, file);
        }
        if (chessPiece.getPiece() == Piece.PAWN) {
            isValidMove = validatePawnMove(chessPiece, rank, file);
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
            pickedPiece.setRank(rank);
            pickedPiece.setFile(file);
            squares[rank][file] = pickedPiece;
            squares[currentRank][currentFile] = null;
        }

        chessMoveBuilder.validMove(isValidMove);

        chessMoveBuilder.updateDescription();

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

    private boolean validatePawnMove(ChessPiece chessPiece, int rank, int file) {
        int currentRank = chessPiece.getRank();
        int currentFile = chessPiece.getFile();

        boolean validMove = false;
        // pawns move always on same file forwards or backwards (according to color)
        if (chessPiece.getColor() == Color.BLACK) {
            if (currentFile == file && currentRank + 1 == rank) {
                validMove = true;
            }
        } else {
            if (currentFile == file && currentRank - 1 == rank) {
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
