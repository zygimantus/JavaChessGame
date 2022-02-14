package org.zygimantus.chess.enums;

public enum Color {
    BLACK(1),
    WHITE(8);

    private final int rank;

    Color(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
}
