package org.zygimantus.chess;

import lombok.Data;

@Data
public class Response {

    private final boolean validMove;
    private String description;

    public Response(boolean validMove) {
        this.validMove = validMove;

        if (validMove) {
            this.description = "Valid move";
        } else {
            this.description = "Invalid move";
        }
    }
}
