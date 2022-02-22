package org.zygimantus.chess.service;

import org.springframework.stereotype.Service;
import org.zygimantus.chess.ChessGame;
import org.zygimantus.chess.ChessMove;
import org.zygimantus.chess.enums.Color;

@Service
public class GameTracker {

    private ChessGame chessGame;

    public ChessGame startNewGame(int noOfPlayers) {
        chessGame = new ChessGame(noOfPlayers);

        return chessGame;
    }

    public ChessGame getCurrentChessGame() {
        return chessGame;
    }

    public Color getColorToMove() {
        return chessGame.getColorToMove();
    }

    /**
     * Ends a move for a given color.
     */
    public void endMove(Color color) {
        // color that moves next is after given one
        Color colorToMove = Color.values()[(color.ordinal() + 1) % Color.values().length];
        chessGame.setColorToMove(colorToMove);
    }

    public void updateLastMove(ChessMove chessMove) {
        chessGame.setLastMove(chessMove);
    }
}
