package gameLogicManager.gameControllerManager;

import gameLogicManager.gameModel.gameBoard.*;

/**
 * This class initializes the game according to UIController input,
 * and notifies UIController when terminating the game.
 */
public class GameEngine {

    //properties
    private static GameEngine uniqueInstance; //Singleton
    private static Game game;
    private static FlowManager flowManager;

    public static GameEngine getInstance(){
        if( uniqueInstance == null ){
            uniqueInstance = new GameEngine();
        }
        return uniqueInstance;
    }

    private GameEngine(){}

    public void initializeGame(boolean isRandom) {
        game = Game.getInstance(isRandom); // + Players and their factions //TODOc
        flowManager = FlowManager.getInstance(); //TODO
    }

    public Terrain getTerrain( int terrainID ) {
        return game.getTerrain( terrainID );
    }

}
