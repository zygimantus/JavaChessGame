package org.zygimantus.chess;

import org.zygimantus.chess.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Consts {

    public static final int NO_OF_PLAYERS = 2;
    public static final int NO_OF_FILES = 8;
    public static final int NO_OF_RANKS = 8;

    public static final List<Class<? extends ChessPiece>> ORDERED_CHESS_SET = new ArrayList<>();

    static {
        ORDERED_CHESS_SET.add(Rook.class);
        ORDERED_CHESS_SET.add(Knight.class);
        ORDERED_CHESS_SET.add(Bishop.class);
        ORDERED_CHESS_SET.add(Queen.class);
        ORDERED_CHESS_SET.add(King.class);
        ORDERED_CHESS_SET.add(Bishop.class);
        ORDERED_CHESS_SET.add(Knight.class);
        ORDERED_CHESS_SET.add(Rook.class);
        ORDERED_CHESS_SET.add(Pawn.class);
        ORDERED_CHESS_SET.add(Pawn.class);
        ORDERED_CHESS_SET.add(Pawn.class);
        ORDERED_CHESS_SET.add(Pawn.class);
        ORDERED_CHESS_SET.add(Pawn.class);
        ORDERED_CHESS_SET.add(Pawn.class);
        ORDERED_CHESS_SET.add(Pawn.class);
        ORDERED_CHESS_SET.add(Pawn.class);
    }
}
