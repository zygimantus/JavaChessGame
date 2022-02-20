package org.zygimantus.chess.service;

import org.springframework.stereotype.Service;
import org.zygimantus.chess.Consts;
import org.zygimantus.chess.board.TwoPlayerBoard;
import org.zygimantus.chess.enums.Color;
import org.zygimantus.chess.enums.Piece;
import org.zygimantus.chess.pieces.ChessPiece;

@Service
public class PieceMover {

    private final BoardInitializer boardInitializer;

    public PieceMover(BoardInitializer boardInitializer) {
        this.boardInitializer = boardInitializer;
    }

    public boolean move(ChessPiece chessPiece, int rank, int file) {
        boolean isValidMove = false;

        if (rank >= Consts.NO_OF_RANKS || rank < 0) {
            return false;
        }
        if (file >= Consts.NO_OF_RANKS || file < 0) {
            return false;
        }

        TwoPlayerBoard board = boardInitializer.getBoard();
        ChessPiece existingPiece = board.getSquares()[rank][file];

        ChessPiece pickedPiece = boardInitializer.getPiece(chessPiece);
        if (pickedPiece == null) {
            return false;
        }

        // move to same rank and file is invalid
        int currentRank = chessPiece.getRank();
        int currentFile = chessPiece.getFile();
        if (currentRank == rank && currentFile == file) {
            return false;
        }

        // cannot move a piece on existing same color piece
        if (existingPiece != null && chessPiece.getColor().equals(existingPiece.getColor())) {
            return false;
        }

        if (chessPiece.getPiece() == Piece.KING) {
            isValidMove = validateKingMove(chessPiece, rank, file);
        }
        if (chessPiece.getPiece() == Piece.PAWN) {
            isValidMove = validatePawnMove(chessPiece, rank, file);
        }
        if (chessPiece.getPiece() == Piece.ROOK) {
            isValidMove = validateRookMove(chessPiece, rank, file);
        }
        if (chessPiece.getPiece() == Piece.BISHOP) {
            isValidMove = validateBishopMove(chessPiece, rank, file);
        }
        if (chessPiece.getPiece() == Piece.QUEEN) {
            isValidMove = validateRookMove(chessPiece, rank, file) || validateBishopMove(chessPiece, rank, file);
        }

        if (isValidMove) {
            pickedPiece.setRank(rank);
            pickedPiece.setFile(file);
            board.getSquares()[rank][file] = pickedPiece;
            board.getSquares()[currentRank][currentFile] = null;
        }

        return isValidMove;
    }

    private boolean validateRookMove(ChessPiece chessPiece, int rank, int file) {
        int currentRank = chessPiece.getRank();
        int currentFile = chessPiece.getFile();

        return currentFile == file || currentRank == rank;
    }

    private boolean validateBishopMove(ChessPiece chessPiece, int rank, int file) {
        int currentRank = chessPiece.getRank();
        int currentFile = chessPiece.getFile();

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

        boolean validMove = false;
        if (chessPiece.getColor() == Color.BLACK) {
            if (currentFile == file && currentRank + 1 == rank && rank < Consts.NO_OF_RANKS) {
                validMove = true;
            }
        } else {
            if (currentFile == file && currentRank - 1 == rank && rank >= 0) {
                validMove = true;
            }
        }
        return validMove;
    }
}
