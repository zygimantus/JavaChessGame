package org.zygimantus.chess;

import junit.framework.TestCase;
import org.zygimantus.chess.enums.Color;
import org.zygimantus.chess.pieces.ChessPiece;

public class EquipmentTest extends TestCase {

    public void testKingPositionsOnBoard() {
        // When
        Equipment equipment = new Equipment();

        // Then
        Board board = equipment.getBoard();
        ChessPiece[][] squares = board.getSquares();

        // white king should be on e1
        ChessPiece whiteKing = squares[0][4];
        assertSame(whiteKing.getColor(), Color.WHITE);
        assertEquals('K', whiteKing.getSymbol());

        // black king should be on e8
        ChessPiece blackKing = squares[7][4];
        assertSame(blackKing.getColor(), Color.BLACK);
        assertEquals('K', blackKing.getSymbol());
    }
}