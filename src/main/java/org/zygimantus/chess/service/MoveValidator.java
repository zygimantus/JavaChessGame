package org.zygimantus.chess.service;

import org.springframework.stereotype.Service;
import org.zygimantus.chess.Consts;
import org.zygimantus.chess.enums.Color;
import org.zygimantus.chess.enums.Piece;
import org.zygimantus.chess.pieces.ChessPiece;

@Service
public class MoveValidator {

    public boolean validate(ChessPiece chessPiece, int rank, int file) {
        boolean validMove = false;
        if (chessPiece.getPiece() == Piece.PAWN) {
            validMove = validatePawnMove(chessPiece, rank, file);
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
