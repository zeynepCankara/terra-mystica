package gameLogicManager.gameModel.gameBoard;

import gameLogicManager.gameModel.gameResources.BonusCardList;
import gameLogicManager.gameModel.gameResources.FavorTileList;
import gameLogicManager.gameModel.gameResources.ScoringTileList;
import gameLogicManager.gameModel.gameResources.TownTileList;
import gameLogicManager.gameModel.player.Player;

import java.util.List;

/**
 * Holds all entities.
 * Serves as a Facade class between controllers and entities.
 * Game is a Singleton
 * @author Rafi Coktalas
 * @version 10.05.2020
 */
public class Game {

    private static Game uniqueInstance; //Singleton

    private GameBoard gameBoard;
    private CultBoard cultBoard;
    private List<Player> players;
    private String[] transformationCycle; //Bu class olabilir aslında
    private ScoringTileList scoringTiles;
    private FavorTileList favorTiles;
    private TownTileList townTiles;
    private BonusCardList bonusCards;
    private String statusBar;

    private Game(boolean isMapRandom){
        gameBoard = new GameBoard(isMapRandom);
    }

    /**
     * This method is to initialize the Game Singleton
     * @param isMapRandom
     * @return Singleton instance
     */
    public static Game getInstance(boolean isMapRandom){

        if( uniqueInstance == null ){
            uniqueInstance = new Game(isMapRandom);
        }
        return uniqueInstance;
    }

    /**
     * This method is to get instance of the Game Singleton
     * It cannot be used for initialization.
     * @return Singleton instance
     */
    public static Game getInstance() throws NullPointerException{
            return uniqueInstance;
    }

}
