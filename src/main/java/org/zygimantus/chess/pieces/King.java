package org.zygimantus.chess.pieces;

import org.zygimantus.chess.enums.Color;
import org.zygimantus.chess.enums.Piece;

public class King extends ChessPiece {

    public King(Color color) {
        super(color, Piece.KING, 1);
    }

    // required constructor for ChessApiController
    public King(Color color, int number) {
        super(color, Piece.KING, number);
    }
}
