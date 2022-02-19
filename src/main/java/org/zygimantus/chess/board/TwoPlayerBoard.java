package org.zygimantus.chess.board;

import org.zygimantus.chess.enums.Color;
import org.zygimantus.chess.pieces.*;

import static org.zygimantus.chess.Consts.*;

/**
 * Each square on the board is identified by a unique coordinate pairing, from a1 to h8 (file and rank).
 */
public class TwoPlayerBoard extends Board {

    private final ChessPiece[][] squares = new ChessPiece[NO_OF_RANKS][NO_OF_FILES];

    int queensCounter = 0;
    int rooksCounter = 0;
    int bishopsCounter = 0;
    int knightsCounter = 0;
    int pawnsCounter = 0;

    public TwoPlayerBoard() {
        putPiecesOnBoard(Color.BLACK);
        putPiecesOnBoard(Color.WHITE);
    }

    protected void putPiecesOnBoard(Color color) {
        int rank = (color == Color.BLACK) ? 0 : NO_OF_RANKS - 1;
        int file = 0;
        for (Class<? extends ChessPiece> chessPieceClass : ORDERED_CHESS_SET) {
            ChessPiece chessPiece = createPiece(chessPieceClass, color);
            squares[rank][file] = chessPiece;
            file++;
            if (file == NO_OF_FILES ) {
                file = 0;
                if (color == Color.BLACK) {
                    rank++;
                } else {
                    rank--;
                }
            }
        }
    }

    private ChessPiece createPiece(Class<? extends ChessPiece> chessPieceClass, Color color) {
        ChessPiece chessPiece = null;
        if (King.class.equals(chessPieceClass)) {
            chessPiece = new King(color);
        } else if (Queen.class.equals(chessPieceClass)) {
            chessPiece = new Queen(color, ++queensCounter);
        } else if (Rook.class.equals(chessPieceClass)) {
            chessPiece = new Rook(color, ++rooksCounter);
        } else if (Bishop.class.equals(chessPieceClass)) {
            chessPiece = new Bishop(color, ++bishopsCounter);
        } else if (Knight.class.equals(chessPieceClass)) {
            chessPiece = new Knight(color, ++knightsCounter);
        } else if (Pawn.class.equals(chessPieceClass)) {
            chessPiece = new Pawn(color, ++pawnsCounter);
        }
        return chessPiece;
    }

    public ChessPiece[][] getSquares() {
        return squares;
    }
}
