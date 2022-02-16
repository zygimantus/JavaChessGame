package org.zygimantus.chess.pieces;

import org.zygimantus.chess.enums.Color;
import org.zygimantus.chess.enums.Piece;

public class Pawn extends ChessPiece {

    public Pawn(Color color, int number) {
        super(color, Piece.PAWN, number);
    }
}
