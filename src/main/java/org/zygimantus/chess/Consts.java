package org.zygimantus.chess;

import org.zygimantus.chess.enums.Color;
import org.zygimantus.chess.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Consts {

    public static final int NO_OF_FILES = 8;
    public static final int NO_OF_RANKS = 8;

    public static final Color[] COLORS = Color.values();
    
    public static final List<Class<? extends ChessPiece>> INITIAL_CHESS_PIECES = new ArrayList<>();
    
    static {
        INITIAL_CHESS_PIECES.add(King.class);
        INITIAL_CHESS_PIECES.add(Queen.class);
        INITIAL_CHESS_PIECES.add(Rook.class);
        INITIAL_CHESS_PIECES.add(Rook.class);
        INITIAL_CHESS_PIECES.add(Bishop.class);
        INITIAL_CHESS_PIECES.add(Bishop.class);
        INITIAL_CHESS_PIECES.add(Knight.class);
        INITIAL_CHESS_PIECES.add(Knight.class);
        INITIAL_CHESS_PIECES.add(Pawn.class);
        INITIAL_CHESS_PIECES.add(Pawn.class);
        INITIAL_CHESS_PIECES.add(Pawn.class);
        INITIAL_CHESS_PIECES.add(Pawn.class);
        INITIAL_CHESS_PIECES.add(Pawn.class);
        INITIAL_CHESS_PIECES.add(Pawn.class);
        INITIAL_CHESS_PIECES.add(Pawn.class);
        INITIAL_CHESS_PIECES.add(Pawn.class);
    }
}
