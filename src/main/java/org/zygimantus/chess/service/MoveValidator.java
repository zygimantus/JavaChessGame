package org.zygimantus.chess.service;

import org.springframework.stereotype.Service;
import org.zygimantus.chess.Consts;
import org.zygimantus.chess.board.TwoPlayerBoard;
import org.zygimantus.chess.enums.Color;
import org.zygimantus.chess.enums.Piece;
import org.zygimantus.chess.pieces.ChessPiece;

@Service
public class MoveValidator {

    private final BoardInitializer boardInitializer;

    public MoveValidator(BoardInitializer boardInitializer) {
        this.boardInitializer = boardInitializer;
    }

    public boolean validate(ChessPiece chessPiece, int rank, int file) {
        boolean validMove = false;

        TwoPlayerBoard board = boardInitializer.getBoard();
        ChessPiece existingPiece = board.getSquares()[rank][file];


        if (existingPiece != null) {
            if (chessPiece.getColor().equals(existingPiece.getColor())) {
                return  false;
            }
        }

        if (chessPiece.getPiece() == Piece.PAWN) {
            validMove = validatePawnMove(chessPiece, rank, file);
        }
        if (chessPiece.getPiece() == Piece.ROOK) {
            validMove = validateRookMove(chessPiece, rank, file);
        }

        return validMove;
    }

    private boolean validateRookMove(ChessPiece chessPiece, int rank, int file) {
        int currentFile = chessPiece.getFile();

        boolean validMove = false;
        if (chessPiece.getColor() == Color.BLACK) {
            if (currentFile == file && rank >= 0 && rank < Consts.NO_OF_RANKS) {
                validMove = true;
            }
        } else {
            if (currentFile == file && rank >= 0 && rank < Consts.NO_OF_RANKS) {
                validMove = true;
            }
        }
        return validMove;
    }

    private boolean validatePawnMove(ChessPiece chessPiece, int rank, int file) {
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
