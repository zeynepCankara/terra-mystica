package gameLogicManager.gameControllerManager;

import gameLogicManager.gameModel.gameBoard.*;
import gameLogicManager.gameModel.player.Player;

/**
 * This class is to control the outcome of an action.
 * It is a Singleton.
 * @author Rafi Coktalas
 * @version 10.05.2020
 */
public class ActionController implements NotificationHandler{

    private static ActionController uniqueInstance; //Singleton

    public static ActionController getInstance(){
        if( uniqueInstance == null ){
            uniqueInstance = new ActionController();
        }
        return uniqueInstance;
    }

    private ActionController(){}

    public boolean transformTerrain(Terrain terrain, TerrainType newTerrainType){
        terrain.setType(newTerrainType);
        return true;
    }

    public boolean build(Player currentPlayer, Terrain terrain) {
        //TODO

        return false;
    }

    public boolean improveShipping(Player currentPlayer) {
        //Assuming there are no exceptional cases since all were checked in the flowManager
        currentPlayer.setShipping(currentPlayer.getShipping() + 1);
        return true;
    }

    public boolean improveTerraforming(Player currentPlayer) {
        //TODO

        return false;
    }
}
