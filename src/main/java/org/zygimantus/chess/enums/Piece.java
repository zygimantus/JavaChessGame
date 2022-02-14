package org.zygimantus.chess.enums;

public enum Piece {
    KING(5, 'K'),
    QUEEN(4, 'Q'),
    ROOK(1, 'R'),
    BISHOP(3, 'B'),
    KNIGHT(2, 'N'),
    PAWN(1, 'P');

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
