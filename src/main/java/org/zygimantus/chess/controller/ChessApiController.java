package org.zygimantus.chess.controller;

import org.springframework.web.bind.annotation.*;
import org.zygimantus.chess.ChessGame;
import org.zygimantus.chess.ChessMove;
import org.zygimantus.chess.pieces.ChessPiece;
import org.zygimantus.chess.service.GameTracker;
import org.zygimantus.chess.service.PieceMover;

@RestController
@RequestMapping("/api")
public class ChessApiController {

    private final GameTracker gameTracker;
    private final PieceMover pieceMover;

    public ChessApiController(GameTracker gameTracker, PieceMover pieceMover) {
        this.gameTracker = gameTracker;
        this.pieceMover = pieceMover;
    }

    @PostMapping("/move")
    public ChessMove move(@RequestParam(value = "rank") int rank, @RequestParam(value = "file") int file,
                          @RequestBody ChessPiece chessPiece) {

        return pieceMover.move(chessPiece, rank, file);
    }

    @GetMapping("/game")
    public ChessGame getGameInformation() {
        return gameTracker.getCurrentChessGame();
    }
}