package org.zygimantus.chess;

import org.zygimantus.chess.board.Board;
import org.zygimantus.chess.board.TwoPlayerBoard;

public class Equipment {

    private final int numberOfPlayers;
    private final Board board;

    public Equipment(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;

        if (numberOfPlayers == 2) {
            this.board = new TwoPlayerBoard();
        } else {
            this.board = null;
        }
    }

    public Board getBoard() {
        return board;
    }
}
