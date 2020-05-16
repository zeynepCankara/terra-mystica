package gameLogicManager.gameModel.player;

import gameLogicManager.gameModel.gameBoard.Terrain;
import gameLogicManager.gameModel.gameBoard.TerrainType;

/**
 * Entity Object for Factions
 * @author Rafi Coktalas
 * @version 10.05.2020
 */
public class Faction {
    private FactionType type;
    private int workerAtSetup;
    private int coinAtSetup;
    private TerrainType homeTerrain;

    public static int getWorkerAtSetup(FactionType factionType) {
        //TODO
        switch (factionType){
            case WITCHES:
            //All factions should be handled.
        }
        return 0;
    }

    public static int getCoinAtSetup(FactionType factionType) {
        //TODO
        switch (factionType){
            case SWARMLINGS:
                return 20;
            case ENGINEERS:
                return 10;
            default:
                return 15;
                //All factions should be handled.
        }
    }

    public TerrainType getTerrainType() {
        return homeTerrain;
    }

    public FactionType getType() {
        return type;
    }
}
