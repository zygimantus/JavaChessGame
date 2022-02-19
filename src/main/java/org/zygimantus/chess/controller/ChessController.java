package org.zygimantus.chess.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.zygimantus.chess.board.TwoPlayerBoard;
import org.zygimantus.chess.pieces.ChessPiece;
import org.zygimantus.chess.service.BoardInitializer;

@Controller
public class ChessController {

    private final BoardInitializer boardInitializer;

    public ChessController(BoardInitializer boardInitializer) {
        this.boardInitializer = boardInitializer;
    }

    @GetMapping("/board")
    public String board(Model model) {
        TwoPlayerBoard twoPlayerBoard = boardInitializer.prepareInitialBoardSetup();
        ChessPiece[][] squares = twoPlayerBoard.getSquares();

        model.addAttribute("squares", squares);

        return "board";
    }

    @GetMapping("/reset")
    public String reset(ModelMap map) {
        TwoPlayerBoard twoPlayerBoard = boardInitializer.prepareInitialBoardSetup();
        ChessPiece[][] squares = twoPlayerBoard.getSquares();

        map.addAttribute("squares", squares);

        return "board :: #board";
    }

}