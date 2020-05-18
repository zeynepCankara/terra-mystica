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

    public Faction(FactionType factionType){
        type = factionType;
        workerAtSetup = getWorkerAtSetup(factionType);
        coinAtSetup = getCoinAtSetup(factionType);
        homeTerrain = getHomeTerrain(factionType);
    }

    private TerrainType getHomeTerrain(FactionType factionType) {
        //TODO switch case
        return TerrainType.Forest;
    }

    public static int getWorkerAtSetup(FactionType factionType) {
        switch (factionType){
            case CHAOS_MAGICIANS:
                return 4;
            case NOMADS:
                return 2;
            case DARKLINGS:
                return 1;
            case SWARMLINGS:
                return 8;
            case ENGINEERS:
                return 2;
            default:
                return 3;
        }
    }

    public static int getCoinAtSetup(FactionType factionType) {
        switch (factionType){
            case SWARMLINGS:
                return 20;
            case ENGINEERS:
                return 10;
            default:
                return 15;
        }
    }

    public TerrainType getTerrainType() {
        return homeTerrain;
    }

    public FactionType getType() {
        return type;
    }

}
