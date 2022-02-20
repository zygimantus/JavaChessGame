package org.zygimantus.chess;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChessMove {

    private boolean validMove;
    private boolean capturingMove;
    private String description;
}
