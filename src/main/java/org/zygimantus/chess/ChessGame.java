package org.zygimantus.chess;

import lombok.Getter;
import lombok.Setter;
import org.zygimantus.chess.enums.Color;

import java.util.EnumMap;

import static org.zygimantus.chess.Consts.ORDERED_CHESS_SET;

@Getter
@Setter
public class ChessGame {

    /**
     * Holds color which needs to make a move.
     */
    private Color colorToMove = Color.values()[0];
    private final EnumMap<Color, Integer> pieceCount = new EnumMap<>(Color.class);

    public ChessGame(int noOfPlayers) {
        for (int i = 0; i < noOfPlayers; i++) {
            Color color = Color.values()[i];
            pieceCount.put(color, ORDERED_CHESS_SET.size());
        }
    }

    public void reducePieceCount(Color color) {
        pieceCount.put(color, pieceCount.get(color) - 1);
    }
}
