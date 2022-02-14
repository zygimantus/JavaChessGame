package org.zygimantus.chess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.zygimantus.chess.pieces.ChessPiece;

@SpringBootApplication
public class Game {

    public static void main(String[] args) {

        SpringApplication.run(Game.class, args);

        System.out.println("Preparing a chess game!");

        Equipment equipment = new Equipment();
        Board board = equipment.getBoard();
        draw(board);

        System.out.println("Exiting!");
    }

    public static void draw(Board board) {

        ChessPiece[][] squares = board.getSquares();

        StringBuilder stringBuilder = new StringBuilder();
        for (ChessPiece[] rank : squares) {
            for (ChessPiece chessPiece : rank) {
                if (chessPiece == null) {
                    stringBuilder.append(" ");
                } else {
                    stringBuilder.append(chessPiece.getSymbol());
                }
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
}
