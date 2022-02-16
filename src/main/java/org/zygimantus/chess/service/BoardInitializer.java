package org.zygimantus.chess.service;

import org.springframework.stereotype.Service;
import org.zygimantus.chess.board.TwoPlayerBoard;
import org.zygimantus.chess.Equipment;

import static org.zygimantus.chess.Consts.NO_OF_PLAYERS;

@Service
public class BoardInitializer {

    public TwoPlayerBoard prepareInitialBoardSetup() {
        Equipment equipment = new Equipment(NO_OF_PLAYERS);
        return (TwoPlayerBoard) equipment.getBoard();
    }
}
