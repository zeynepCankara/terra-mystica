package gameLogicManager.gameModel.gameBoard;

import gameLogicManager.gameControllerManager.GameEngine;
import gameLogicManager.gameModel.player.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class CultBoard {

    private static CultBoard uniqueInstance;
    private static CultTrack[] cults;

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

    public static CultTrack getTrack(String trackName) {
        for(CultTrack cultTrack : cults){
            if(cultTrack.getName().equals(trackName)){
                return cultTrack;
            }
        }
        return null;
    }

    public void printTrack(String trackName) {
        for(CultTrack c : cults){
            if(c.getName().equals(trackName)) {
                System.out.println("Order 3: " + c.getOrders()[0] + " Order 2: " + c.getOrders()[1] + " advancements: " + Arrays.toString(c.getAdvancements()));
            }
        }
    }
}
