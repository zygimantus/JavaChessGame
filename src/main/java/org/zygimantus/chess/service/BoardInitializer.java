package org.zygimantus.chess.service;

import org.springframework.stereotype.Service;
import org.zygimantus.chess.board.TwoPlayerBoard;
import org.zygimantus.chess.Equipment;

import static org.zygimantus.chess.Consts.NO_OF_PLAYERS;

@Service
public class BoardInitializer {

    private Equipment equipment;

    public TwoPlayerBoard prepareInitialBoardSetup() {
        equipment = new Equipment(NO_OF_PLAYERS);
        return (TwoPlayerBoard) equipment.getBoard();
    }

    public TwoPlayerBoard getBoard() {
        return (TwoPlayerBoard) this.equipment.getBoard();
    }
}
