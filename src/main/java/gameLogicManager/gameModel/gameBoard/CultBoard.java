package gameLogicManager.gameModel.gameBoard;

import gameLogicManager.gameControllerManager.GameEngine;
import gameLogicManager.gameModel.player.Player;

import java.util.ArrayList;

public class CultBoard {

    private static CultBoard uniqueInstance;
    private CultTrack[] cults;

    public static CultBoard getInstance(){
        if( uniqueInstance == null ){
            uniqueInstance = new CultBoard();
        }
        return uniqueInstance;
    }
    public CultBoard( ){
        cults = new CultTrack[4];
        cults[0] = new CultTrack("Fire", 4);
        cults[1] = new CultTrack("Water", 4);
        cults[2] = new CultTrack("Earth", 4);
        cults[3] = new CultTrack("Air", 4);
    }

}
