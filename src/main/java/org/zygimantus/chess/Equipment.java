package org.zygimantus.chess;

import org.zygimantus.chess.enums.Color;
import org.zygimantus.chess.pieces.*;

import java.util.HashSet;
import java.util.Set;

public class Equipment {

    private final Set<ChessPiece> chessPieces = new HashSet<>();
    private final Board board;

    public Equipment() {
        initPieces();

        this.board = new Board(chessPieces);
    }

    private void initPieces() {

        for (Color color : Consts.COLORS) {
            int rooksCounter = 0;
            int bishopsCounter = 0;
            int knightsCounter = 0;
            int pawnsCounter = 0;
            for (Class<? extends ChessPiece> chessPieceClass : Consts.INITIAL_CHESS_PIECES) {
                ChessPiece chessPiece = null;
                if (King.class.equals(chessPieceClass)) {
                    chessPiece = new King(color);
                } else if (Queen.class.equals(chessPieceClass)) {
                    chessPiece = new Queen(color);
                } else if (Rook.class.equals(chessPieceClass)) {
                    chessPiece = new Rook(color, rooksCounter++);
                } else if (Bishop.class.equals(chessPieceClass)) {
                    chessPiece = new Bishop(color, bishopsCounter++);
                } else if (Knight.class.equals(chessPieceClass)) {
                    chessPiece = new Knight(color, knightsCounter++);
                } else if (Pawn.class.equals(chessPieceClass)) {
                    chessPiece = new Pawn(color, pawnsCounter++);
                }
                chessPieces.add(chessPiece);
            }
        }
    }

    public Board getBoard() {
        return board;
    }
}
