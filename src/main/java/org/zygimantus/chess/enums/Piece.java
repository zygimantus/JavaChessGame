package org.zygimantus.chess.enums;

public enum Piece {
    KING(5, 'K');

    private final int file;
    private final char symbol;

    Piece(int file, char symbol) {
        this.file = file;
        this.symbol = symbol;
    }

    public int getFile() {
        return file;
    }

    public char getSymbol() {
        return symbol;
    }
}
