package gameLogicManager.gameControllerManager;

import gameLogicManager.gameModel.gameBoard.*;
import gameLogicManager.gameModel.player.*;

/**
 * This class is to control if an action is affected by adjacency.
 * It is a Singleton.
 * @author Rafi Coktalas
 * @version 10.05.2020
 */
public class AdjacencyController implements NotificationHandler{

    private static AdjacencyController uniqueInstance; //Singleton

    public static AdjacencyController getInstance(){
        if( uniqueInstance == null ){
            uniqueInstance = new AdjacencyController();
        }
        return uniqueInstance;
    }

    private AdjacencyController(){}

    public boolean updateAdjacencyList(Player player, Terrain terrain){

        // TODO

        return false;
    }
}
