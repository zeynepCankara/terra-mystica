package gameLogicManager.gameControllerManager;

import gameLogicManager.gameModel.gameBoard.*;

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

        //TODO

        return false;
    }

}
