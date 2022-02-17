package org.zygimantus.chess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zygimantus.chess.Response;
import org.zygimantus.chess.pieces.ChessPiece;
import org.zygimantus.chess.service.MoveValidator;

@RestController
@RequestMapping("/api")
public class ChessApiController {

    private final MoveValidator moveValidator;

    @Autowired
    public ChessApiController(MoveValidator moveValidator) {
        this.moveValidator = moveValidator;
    }

    @PostMapping("/move")
    public Response greeting(@RequestParam(value = "rank") int rank, @RequestParam(value = "file") int file,
                             @RequestBody ChessPiece chessPiece) {
        boolean isValidMove = moveValidator.validate(chessPiece, rank, file);

        return new Response(isValidMove);
    }
}