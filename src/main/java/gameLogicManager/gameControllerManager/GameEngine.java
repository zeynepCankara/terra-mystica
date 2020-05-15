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
    private static String gameStatus;

    public static GameEngine getInstance(){
        if( uniqueInstance == null ){
            uniqueInstance = new GameEngine();
        }
        return uniqueInstance;
    }

    private GameEngine(){
        flowManager = FlowManager.getInstance();
        gameStatus = "Game has started.";
    }

    public boolean transformTerrain( int terrainID, TerrainType terrainType ){
        int result = flowManager.transformTerrain(terrainID, terrainType);
        updateGameStatus(result);
        if(result == 0){
            return true;
        }
        return false;
    }

    public boolean buildDwelling( int terrainID ) {
        int result = flowManager.buildDwelling(terrainID);
        updateGameStatus(result);
        if(result == 0){
            return true;
        }
        return false;
    }

    public boolean improveShipping(){
        int result = flowManager.improveShipping();
        updateGameStatus(result);
        if(result == 0){
            return true;
        }
        return false;
    }

    public boolean improveTerraforming(){
        int result = flowManager.improveTerraforming();
        updateGameStatus(result);
        if(result == 0){
            return true;
        }
        return false;
    }

    public boolean upgradeStructure(int terrainID, StructureType newStructureType){
        int result = flowManager.upgradeStructure(terrainID, newStructureType);
        updateGameStatus(result);
        if(result == 0){
            return true;
        }
        return false;
    }

    /**
     * This method updates gameStatus according to the results from the actions.
     * Each case is self explanatory in the code.
     * @param result the results of actions
     */
    public void updateGameStatus(int result){
        switch (result){
            case 0:
                gameStatus = "Action is done successfully";
            case 1:
                gameStatus = "Failed: Not enough coins";
            case 2:
                gameStatus = "Failed: Not enough workers";
            case 3:
                gameStatus = "Failed: Not enough priests";
            case 4:
                gameStatus = "Failed: Terrain is not available";
            case 5:
                gameStatus = "Failed: Terrain is not adjacent";
            case 6:
                gameStatus = "Failed: Improvement limit has been reached";
        }
    }

}
