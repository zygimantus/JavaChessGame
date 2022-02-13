package org.zygimantus.chess.enums;

public enum Color {
    BLACK(8),
    WHITE(1);

    private final int rank;

    Color(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
}
