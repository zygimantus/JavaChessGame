package org.zygimantus.chess;

import org.junit.jupiter.api.Test;
import org.zygimantus.chess.enums.Color;
import org.zygimantus.chess.pieces.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class EquipmentTest {

    @Test
    void testChessPiecesPositionsOnBoard() {
        // Given
        ChessPiece[][] expected = new ChessPiece[Consts.NO_OF_FILES][Consts.NO_OF_RANKS];
        // white pieces
        expected[0][0] = new Rook(Color.BLACK, 1);
        expected[0][1] = new Knight(Color.BLACK, 1);
        expected[0][2] = new Bishop(Color.BLACK, 1);
        expected[0][3] = new Queen(Color.BLACK);
        expected[0][4] = new King(Color.BLACK);
        expected[0][5] = new Bishop(Color.BLACK, 2);
        expected[0][6] = new Knight(Color.BLACK, 2);
        expected[0][7] = new Rook(Color.BLACK, 2);

        expected[1][0] = new Pawn(Color.BLACK, 1);
        expected[1][1] = new Pawn(Color.BLACK, 2);
        expected[1][2] = new Pawn(Color.BLACK, 3);
        expected[1][3] = new Pawn(Color.BLACK, 4);
        expected[1][4] = new Pawn(Color.BLACK, 5);
        expected[1][5] = new Pawn(Color.BLACK, 6);
        expected[1][6] = new Pawn(Color.BLACK, 7);
        expected[1][7] = new Pawn(Color.BLACK, 8);

        // black pieces
        expected[7][0] = new Rook(Color.WHITE, 1);
        expected[7][1] = new Knight(Color.WHITE, 1);
        expected[7][2] = new Bishop(Color.WHITE, 1);
        expected[7][3] = new Queen(Color.WHITE);
        expected[7][4] = new King(Color.WHITE);
        expected[7][5] = new Bishop(Color.WHITE, 2);
        expected[7][6] = new Knight(Color.WHITE, 2);
        expected[7][7] = new Rook(Color.WHITE, 2);

        expected[6][0] = new Pawn(Color.WHITE, 1);
        expected[6][1] = new Pawn(Color.WHITE, 2);
        expected[6][2] = new Pawn(Color.WHITE, 3);
        expected[6][3] = new Pawn(Color.WHITE, 4);
        expected[6][4] = new Pawn(Color.WHITE, 5);
        expected[6][5] = new Pawn(Color.WHITE, 6);
        expected[6][6] = new Pawn(Color.WHITE, 7);
        expected[6][7] = new Pawn(Color.WHITE, 8);

        // When
        Equipment equipment = new Equipment();

        // Then
        Board board = equipment.getBoard();
        ChessPiece[][] squares = board.getSquares();

        assertTrue(Arrays.deepEquals(expected[0], squares[0]));
    }
}