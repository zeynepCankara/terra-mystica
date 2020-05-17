package gameLogicManager.gameControllerManager;

import gameLogicManager.gameModel.gameBoard.*;
import org.json.JSONException;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This class initializes the game according to UIController input,
 * and notifies UIController when terminating the game.
 */
public class GameEngine {

    //properties
    private static GameEngine uniqueInstance; //Singleton
    private static FlowManager flowManager;
    private static String gameStatus;
    private static Game game;
    private static Timer timer;

    public static GameEngine getInstance(boolean isMapRandom){
        if( uniqueInstance == null ){
            uniqueInstance = new GameEngine(isMapRandom);
        }
        return uniqueInstance;
    }

    private GameEngine(boolean isMapRandom){
        game = Game.getInstance(isMapRandom);
        flowManager = FlowManager.getInstance();
        gameStatus = "Game has started.";
    }

    public boolean transformTerrain( int terrainID, int terrainType ){

        int result = flowManager.transformTerrain(terrainID, Terrain.terrainIdToTypeConverter(terrainType));

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
        System.out.println(gameStatus);
        if(result == 0){
            return true;
        }
        return false;
    }

    public int sendPriestToCult( int trackID ){
        int result = flowManager.sendPriestToCult(trackID);
        updateGameStatus(result);
        return result;
    }

    public void pass(){
        flowManager.pass();
    }


    /**
     * This method updates gameStatus according to the results from the actions.
     * Each case is self explanatory in the code.
     * @param result the results of actions
     */
    public static void updateGameStatus(int result){
        switch (result){
            case 0:
                gameStatus = "Action is done successfully";
                break;
            case 1:
                gameStatus = "Failed: Not enough coins";
                break;
            case 2:
                gameStatus = "Failed: Not enough workers";
                break;
            case 3:
                gameStatus = "Failed: Not enough priests";
                break;
            case 4:
                gameStatus = "Failed: Terrain is not available";
                break;
            case 5:
                gameStatus = "Failed: Terrain is not adjacent";
                break;
            case 6:
                gameStatus = "Failed: Improvement limit has been reached";
                break;
        }
    }

    public static void update() {

        timer.schedule(
                new TimerTask() {

                    @Override
                    public void run() {
                        System.out.println("Rafi");
                    }
                }, 0, 5000);
    }

}
