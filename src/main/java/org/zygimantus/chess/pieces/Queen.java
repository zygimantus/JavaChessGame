package org.zygimantus.chess.pieces;

import org.zygimantus.chess.enums.Color;
import org.zygimantus.chess.enums.Piece;

public class Queen extends ChessPiece {

    public Queen(Color color, int number) {
        super(color, Piece.QUEEN, number);
    }
}
