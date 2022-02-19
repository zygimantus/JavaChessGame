package org.zygimantus.chess.controller;

import org.springframework.web.bind.annotation.*;
import org.zygimantus.chess.Response;
import org.zygimantus.chess.pieces.ChessPiece;
import org.zygimantus.chess.service.PieceMover;

@RestController
@RequestMapping("/api")
public class ChessApiController {

    private final PieceMover pieceMover;

    public ChessApiController(PieceMover pieceMover) {
        this.pieceMover = pieceMover;
    }

    @PostMapping("/move")
    public Response move(@RequestParam(value = "rank") int rank, @RequestParam(value = "file") int file,
                             @RequestBody ChessPiece chessPiece) {
        boolean isValidMove = pieceMover.move(chessPiece, rank, file);

        return new Response(isValidMove);
    }
}