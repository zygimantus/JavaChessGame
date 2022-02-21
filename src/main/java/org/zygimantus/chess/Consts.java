package org.zygimantus.chess;

import org.zygimantus.chess.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Consts {

    public static final int NO_OF_PLAYERS = 2;
    public static final int NO_OF_FILES = 8;
    public static final int NO_OF_RANKS = 8;

    public static final String INVALID_MOVE_X_TO_MOVE_NOW = "Invalid move, %s to move now";
    public static final String CANNOT_MOVE_OVER_THE_EDGE_OF_BOARD = "Cannot move over the edge of the board";
    public static final String CANNOT_MOVE_TO_THE_SAME_SQUARE = "Cannot move to the same square";
    public static final String CANNOT_MOVE_NON_EXISTING_PIECE = "Cannot move non-existing piece";
    public static final String CANNOT_MOVE_ON_OWN_PIECE = "Cannot move on own piece";
    public static final String PIECE_X_WAS_CAPTURED = "Piece %s was captured";
    public static final String VALID_MOVE = "Valid move";
    public static final String INVALID_MOVE = "Invalid move";

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
