package org.zygimantus.chess;

import org.zygimantus.chess.enums.Color;
import org.zygimantus.chess.pieces.ChessPiece;
import org.zygimantus.chess.pieces.King;

import java.util.HashSet;
import java.util.Set;

public class Equipment {

    private final Set<ChessPiece> pieces = new HashSet<>();
    private final Board board;

    public Equipment() {
        initPieces();

        this.board = new Board(pieces);
    }

    private void initPieces() {

        for (Color color : Consts.COLORS) {
            King king = new King(color);
            pieces.add(king);
        }
    }

    public Board getBoard() {
        return board;
    }
}
