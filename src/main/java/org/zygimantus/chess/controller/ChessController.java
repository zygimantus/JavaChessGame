package org.zygimantus.chess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zygimantus.chess.Board;
import org.zygimantus.chess.pieces.ChessPiece;
import org.zygimantus.chess.service.BoardInitializer;

@Controller
public class ChessController {

    private final BoardInitializer boardInitializer;

    @Autowired
    public ChessController(BoardInitializer boardInitializer) {
        this.boardInitializer = boardInitializer;
    }

    @GetMapping("/board")
    public String board(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);

        Board board = boardInitializer.prepareInitialBoardSetup();
        ChessPiece[][] squares = board.getSquares();

        model.addAttribute("squares", squares);

        return "board";
    }

}