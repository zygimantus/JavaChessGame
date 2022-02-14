package org.zygimantus.chess.pieces;

import org.zygimantus.chess.enums.Color;
import org.zygimantus.chess.enums.Piece;

public abstract class ChessPiece {

    protected final Color color;
    protected final Piece piece;

    protected int number;

    protected ChessPiece(Color color, Piece piece) {
        this.color = color;
        this.piece = piece;
    }

    protected ChessPiece(Color color, Piece piece, int number) {
        this.color = color;
        this.piece = piece;
        this.number = number;
    }

    public Color getColor() {
        return color;
    }

    public int getRank() {
        return getColor().getRank();
    }

    public int getFile() {
        return piece.getFile();
    }

    public char getSymbol() {
        return piece.getSymbol();
    }
}
