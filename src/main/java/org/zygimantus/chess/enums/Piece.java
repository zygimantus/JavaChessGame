package org.zygimantus.chess.enums;

import lombok.Getter;

@Getter
public enum Piece {
    KING('K'),
    QUEEN('Q'),
    ROOK('R'),
    BISHOP('B'),
    KNIGHT('N'),
    PAWN('P');

    private final char symbol;

    Piece(char symbol) {
        this.symbol = symbol;
    }
}
