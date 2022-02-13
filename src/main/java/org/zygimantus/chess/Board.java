package org.zygimantus.chess;

import org.zygimantus.chess.pieces.ChessPiece;

import java.util.Set;

import static org.zygimantus.chess.Consts.NO_OF_FILES;
import static org.zygimantus.chess.Consts.NO_OF_RANKS;

/**
 * Each square on the board is identified by a unique coordinate pairing, from a1 to h8 (file and rank).
 */
public class Board {

    private final ChessPiece[][] squares = new ChessPiece[NO_OF_FILES][NO_OF_RANKS];

    public Board(Set<ChessPiece> pieces) {
        init(pieces);
    }

    /**
     * Puts given pieces on the board according to piece's rank and file attributes.
     */
    private void init(Set<ChessPiece> pieces) {
        for (ChessPiece chessPiece : pieces) {
            squares[chessPiece.getRank() - 1][chessPiece.getFile() - 1] = chessPiece;
        }
    }

    public ChessPiece[][] getSquares() {
        return squares;
    }
}
