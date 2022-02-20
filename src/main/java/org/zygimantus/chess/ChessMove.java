package org.zygimantus.chess;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChessMove {

    private boolean validMove;
    private boolean capturingMove;
    private String description;

    public static class ChessMoveBuilder {
        public ChessMoveBuilder updateDescription() {
            String description;
            if (this.validMove) {
                description = "Valid move";
            } else {
                description = "Invalid move";
            }
            this.description = description;
            return this;
        }
    }
}
