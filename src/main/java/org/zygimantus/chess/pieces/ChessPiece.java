package org.zygimantus.chess.pieces;

import org.zygimantus.chess.enums.Color;
import org.zygimantus.chess.enums.Piece;

import java.util.Objects;

public abstract class ChessPiece {

    protected final int number;
    protected final Color color;
    protected final Piece piece;

    protected int rank;
    protected int file;

    /**
     * Constructor for a unique chess piece
     */
    protected ChessPiece(Color color, Piece piece) {
        this.number = 1;
        this.color = color;
        this.piece = piece;
    }

    protected ChessPiece(Color color, Piece piece, int number) {
        this.color = color;
        this.piece = piece;
        this.number = number;
    }

    public final void move() {
        rank++;
    }

    public Color getColor() {
        return color;
    }

    public final int getRank() {
        return this.rank;
    }

    public final int getFile() {
        return this.file;
    }

    public char getSymbol() {
        return piece.getSymbol();
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setFile(int file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessPiece that = (ChessPiece) o;
        return number == that.number && color == that.color && piece == that.piece;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, color, piece);
    }

    @Override
    public String toString() {
        return color + "-" + piece;
    }
}
