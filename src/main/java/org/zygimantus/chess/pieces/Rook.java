package org.zygimantus.chess.pieces;

import org.zygimantus.chess.enums.Color;
import org.zygimantus.chess.enums.Piece;

public class Rook extends ChessPiece {

    public Rook(Color color, int number) {
        super(color, Piece.ROOK, number);
    }

    @Override
    public int getFile() {
        return (number == 1) ? super.getFile() : super.getFile() + 7;
    }
}
