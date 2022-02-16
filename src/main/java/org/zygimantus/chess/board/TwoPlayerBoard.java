package org.zygimantus.chess.board;

import org.zygimantus.chess.pieces.ChessPiece;

import java.util.List;

import static org.zygimantus.chess.Consts.*;

/**
 * Each square on the board is identified by a unique coordinate pairing, from a1 to h8 (file and rank).
 */
public class TwoPlayerBoard extends Board {

    private final int NO_OF_RANKS_FOR_ONE_PLAYER = ORDERED_CHESS_SET.size() / NO_OF_FILES;
    private final ChessPiece[][] squares = new ChessPiece[NO_OF_RANKS][NO_OF_FILES];

    public TwoPlayerBoard(List<ChessPiece> pieces) {
        putPiecesOnBoard(pieces);
    }

    /**
     * Puts given pieces on the board according to piece's rank and file attributes.
     */
    protected void putPiecesOnBoard(List<ChessPiece> chessPieces) {
            // setup 1st player
            putFirstPlayerChessPiecesOnBoard(chessPieces);
            // setup 2nd player
            putSecondPlayerChessPiecesOnBoard(chessPieces);
    }

    private void putFirstPlayerChessPiecesOnBoard(List<ChessPiece> chessPieces) {
        for (int rank = 0; rank < NO_OF_RANKS_FOR_ONE_PLAYER; rank++) {
            for (int file = 0; file < NO_OF_FILES; file++) {
                ChessPiece chessPiece = chessPieces.get(NO_OF_RANKS * rank + file);
                chessPiece.setRank(rank + 1);
                chessPiece.setFile(file + 1);
                squares[rank][file] = chessPiece;
            }
        }
    }

    private void putSecondPlayerChessPiecesOnBoard(List<ChessPiece> chessPieces) {
        for (int rank = NO_OF_RANKS - NO_OF_RANKS_FOR_ONE_PLAYER; rank < NO_OF_RANKS; rank++) {
            for (int file = 0; file < NO_OF_FILES; file++) {
                // FIXME crappy formula
                ChessPiece chessPiece = chessPieces.get(NO_OF_PLAYERS * NO_OF_RANKS_FOR_ONE_PLAYER * rank + file - (rank - NO_OF_RANKS + NO_OF_RANKS_FOR_ONE_PLAYER) * (NO_OF_RANKS - NO_OF_RANKS_FOR_ONE_PLAYER + rank - 1));
                chessPiece.setRank(rank + 1);
                chessPiece.setFile(file + 1);
                squares[rank][file] = chessPiece;
            }
        }
    }

    public ChessPiece[][] getSquares() {
        return squares;
    }
}
