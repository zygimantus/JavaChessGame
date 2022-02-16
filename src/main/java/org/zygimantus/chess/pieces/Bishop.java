package org.zygimantus.chess.pieces;

import org.zygimantus.chess.enums.Color;
import org.zygimantus.chess.enums.Piece;

public class Bishop extends ChessPiece {

    public Bishop(Color color, int number) {
        super(color, Piece.BISHOP, number);
    }
}
