package gameLogicManager.gameControllerManager;

import gameLogicManager.gameModel.gameBoard.*;

/**
 * This class initializes the game according to UIController input,
 * and notifies UIController when terminating the game.
 */
public class GameEngine {

    //properties
    private static GameEngine uniqueInstance; //Singleton
    private static FlowManager flowManager;

    public static GameEngine getInstance(){
        if( uniqueInstance == null ){
            uniqueInstance = new GameEngine();
        }
        return uniqueInstance;
    }

    private GameEngine(){}

    public void transformTerrain( int terrainID, int terrainTypeID ){
        flowManager.transformTerrain(terrainID, terrainTypeID);
    }

    public void buildDwelling( int terrainID ) {
        flowManager.buildDwelling(terrainID);
    }
}
