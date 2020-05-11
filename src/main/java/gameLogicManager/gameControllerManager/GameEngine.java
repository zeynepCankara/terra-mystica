package gameLogicManager.gameControllerManager;

import gameLogicManager.gameModel.gameBoard.Game;

/**
 * This class initializes the game according to UIController input,
 * and notifies UIController when terminating the game.
 */
public class GameEngine {

    //properties
    private static GameEngine uniqueInstance; //Singleton
    private static Game game;

    public static GameEngine getInstance(){
        if( uniqueInstance == null ){
            uniqueInstance = new GameEngine();
        }
        return uniqueInstance;
    }

    private GameEngine(){}

    public void initializeGame(boolean isRandom) {
        game.getInstance(isRandom);
    }

}
