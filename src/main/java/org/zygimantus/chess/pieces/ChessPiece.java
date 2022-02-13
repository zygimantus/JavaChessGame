package org.zygimantus.chess.pieces;

import org.zygimantus.chess.enums.Color;
import org.zygimantus.chess.enums.Piece;

public abstract class ChessPiece {

    protected final Color color;
    protected final Piece piece;

    protected ChessPiece(Color color, Piece piece) {
        this.color = color;
        this.piece = piece;
    }

    public int getRank() {
        return color.getRank();
    }

    public int getFile() {
        return piece.getFile();
    }

    public char getSymbol() {
        return piece.getSymbol();
    }
}
