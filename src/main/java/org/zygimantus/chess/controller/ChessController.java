package org.zygimantus.chess.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.zygimantus.chess.ChessGame;
import org.zygimantus.chess.board.TwoPlayerBoard;
import org.zygimantus.chess.pieces.ChessPiece;
import org.zygimantus.chess.service.BoardInitializer;
import org.zygimantus.chess.service.GameTracker;

import static org.zygimantus.chess.Consts.NO_OF_PLAYERS;

@Controller
public class ChessController {

    private final BoardInitializer boardInitializer;
    private final GameTracker gameTracker;

    public ChessController(BoardInitializer boardInitializer, GameTracker gameTracker) {
        this.boardInitializer = boardInitializer;
        this.gameTracker = gameTracker;
    }

    @GetMapping("/board")
    public String board(Model model) {

        ChessGame chessGame = gameTracker.startNewGame(NO_OF_PLAYERS);

        TwoPlayerBoard twoPlayerBoard = boardInitializer.prepareInitialBoardSetup();
        ChessPiece[][] squares = twoPlayerBoard.getSquares();

        model.addAttribute("squares", squares);

        return "board";
    }

    @GetMapping("/reset")
    public String reset(ModelMap map) {

        ChessGame chessGame = gameTracker.startNewGame(NO_OF_PLAYERS);

        TwoPlayerBoard twoPlayerBoard = boardInitializer.prepareInitialBoardSetup();
        ChessPiece[][] squares = twoPlayerBoard.getSquares();

        map.addAttribute("squares", squares);

        return "board :: #board";
    }

}