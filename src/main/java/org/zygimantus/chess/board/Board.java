package org.zygimantus.chess.board;

import org.zygimantus.chess.pieces.ChessPiece;

import java.util.List;

public abstract class Board {

    protected abstract void putPiecesOnBoard(List<ChessPiece> pieces);
}
