package gameLogicManager.gameModel.gameBoard;

import gameLogicManager.gameModel.gameResources.*;
import gameLogicManager.gameModel.player.Faction;
import gameLogicManager.gameModel.player.FactionType;
import gameLogicManager.gameModel.player.Player;
import javafx.util.Pair;

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
    private Player[] players;
    private ScoringTile[] scoringTileList;
    private FavorTileList favorTiles;
    private TownTileList townTiles;
    private BonusCardList bonusCards;

    private int currentPlayerIndex;

    private Game(boolean isMapRandom){
        gameBoard = GameBoard.getInstance(isMapRandom);
        cultBoard = new CultBoard();
        players = initilizePlayers(4);
        bonusCards = new BonusCardList(); //TODO
        townTiles = new TownTileList(); //TODO
        scoringTileList = ScoringTileList.scoringTileInitializer(); //TODO
        currentPlayerIndex = -1;
        //TODO cultBoard = new CultBoard(players); //buna player listesi lazım
    }

    /**
     * Initialize Player objects with the given number of players.
     * @param playerCount total number of players
     * @return Player[] player list
     */
    private Player[] initilizePlayers(int playerCount) {
        Player[] players = new Player[playerCount];
        players[0] = new Player(FactionType.WITCHES);
        players[1] = new Player(FactionType.NOMADS);
        players[2] = new Player(FactionType.HALFLINGS);
        players[3] = new Player(FactionType.MERMAIDS);
        return players;
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

    public Player getNextPlayer() {
        return players[(++currentPlayerIndex) % 4];
    }

    public Terrain getTerrain( int terrainID ){
        return gameBoard.getTerrain(terrainID);
    }

    public Terrain[] getTerrainList(){
        return gameBoard.getTerrainList();
    }

    public ScoringTile[] getScoringTileList() {
        return scoringTileList;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Player[] getPlayers() {
        return players;
    }
}
