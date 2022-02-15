package org.zygimantus.chess.pieces;

import org.zygimantus.chess.enums.Color;
import org.zygimantus.chess.enums.Piece;

public class Pawn extends ChessPiece {

    public Pawn(Color color, int number) {
        super(color, Piece.PAWN, number);
    }

    @Override
    public int getRank() {
        // TODO use formula better
        return (color == Color.WHITE) ? 7 : 2;
    }

    @Override
    public int getFile() {
        return number;
    }
}
