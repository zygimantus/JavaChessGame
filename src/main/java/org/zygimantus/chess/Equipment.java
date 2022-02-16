package org.zygimantus.chess;

import org.zygimantus.chess.board.Board;
import org.zygimantus.chess.board.TwoPlayerBoard;
import org.zygimantus.chess.enums.Color;
import org.zygimantus.chess.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Equipment {

    private final int numberOfPlayers;
    private final List<ChessPiece> chessPieces = new ArrayList<>();
    private final Board board;

    public Equipment(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        initPieces();

        if (numberOfPlayers == 2) {
            this.board = new TwoPlayerBoard(chessPieces);
        } else {
            this.board = null;
        }
    }

    private void initPieces() {

        Color[] colors = Color.values();
        for (int i = 0; i < numberOfPlayers; i++) {
            Color color = colors[i];
            int rooksCounter = 0;
            int bishopsCounter = 0;
            int knightsCounter = 0;
            int pawnsCounter = 0;
            for (Class<? extends ChessPiece> chessPieceClass : Consts.ORDERED_CHESS_SET) {
                ChessPiece chessPiece = null;
                if (King.class.equals(chessPieceClass)) {
                    chessPiece = new King(color);
                } else if (Queen.class.equals(chessPieceClass)) {
                    chessPiece = new Queen(color);
                } else if (Rook.class.equals(chessPieceClass)) {
                    chessPiece = new Rook(color, ++rooksCounter);
                } else if (Bishop.class.equals(chessPieceClass)) {
                    chessPiece = new Bishop(color, ++bishopsCounter);
                } else if (Knight.class.equals(chessPieceClass)) {
                    chessPiece = new Knight(color, ++knightsCounter);
                } else if (Pawn.class.equals(chessPieceClass)) {
                    chessPiece = new Pawn(color, ++pawnsCounter);
                }
                chessPieces.add(chessPiece);
            }
        }
    }

    public Board getBoard() {
        return board;
    }
}
