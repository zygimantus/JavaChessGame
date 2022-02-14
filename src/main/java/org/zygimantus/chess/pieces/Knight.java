package org.zygimantus.chess.pieces;

import org.zygimantus.chess.enums.Color;
import org.zygimantus.chess.enums.Piece;

public class Knight extends ChessPiece {

    public Knight(Color color, int number) {
        super(color, Piece.KNIGHT, number);
    }

    @Override
    public int getFile() {
        return (number == 1) ? super.getFile() : super.getFile() + 5;
    }
}
