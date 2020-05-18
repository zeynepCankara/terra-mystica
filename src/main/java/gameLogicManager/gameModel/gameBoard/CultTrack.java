package gameLogicManager.gameModel.gameBoard;

import gameLogicManager.gameModel.player.Player;

import java.util.HashMap;

/**
 * Entity object for Cult track
 * @author Rafi Coktalas
 * @version 10.05.2020
 */
public class CultTrack {
    private String name;
    private int advancements[];
    private int[] orders; //true if it is empty 0 for 3, 1 for 2

    public CultTrack(String name, int numberOfPlayers){
        this.name = name;
        advancements = new int[numberOfPlayers];
        for(int i = 0; i < numberOfPlayers; i++){
            advancements[i] = 0;
        }
        orders = new int[2];
        orders[0] = 1;
        orders[1] = 3;
    }

    public String getName() {
        return name;
    }

    public boolean advanceWithPriest(Player player) {
        int playerIndex = player.getPlayerIndex();
        if(orders[0] == 0 && orders[1] == 0){
            return  false;
        }
        if(orders[0] == 1){
            orders[0] = 0;
            advancements[playerIndex] = advancements[playerIndex] + 3;
            return true;
        }
        else{
            orders[1] = orders[1] - 1;
            advancements[playerIndex] = advancements[playerIndex] + 2;
            return true;
        }
    }


    public int[] getAdvancements() {
        return advancements;
    }

    public int[] getOrders() {
        return orders;
    }

}
