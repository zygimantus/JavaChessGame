package org.zygimantus.chess.service;

import org.springframework.stereotype.Service;
import org.zygimantus.chess.Board;
import org.zygimantus.chess.Equipment;

@Service
public class BoardInitializer {

    public Board prepareInitialBoardSetup() {
        Equipment equipment = new Equipment();
        return equipment.getBoard();
    }
}
