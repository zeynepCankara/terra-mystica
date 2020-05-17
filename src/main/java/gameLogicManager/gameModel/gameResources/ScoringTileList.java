package gameLogicManager.gameModel.gameResources;

import java.util.List;

public class ScoringTileList {
    private static ScoringTile[] scoringTiles;

    public static ScoringTile[] scoringTileInitializer(){
        scoringTiles = new ScoringTile[6];
        scoringTiles[0] = new ScoringTile(0);// Dwelling+2 / 4 Fire = 4 Power
        scoringTiles[1] = new ScoringTile(1);// Dwelling+2 / 4 Water = Priest
        scoringTiles[2] = new ScoringTile(2);// Stronghold/Sanctuary+5 / 2 Fire = Worker
        scoringTiles[3] = new ScoringTile(3);// Stronghold/Sanctuary+5 / 2 Air = Worker
        scoringTiles[4] = new ScoringTile(4);// Spade+2 / 1 Earth = 1 Coin
        scoringTiles[5] = new ScoringTile(5);// CHECK THIS LATER
        return scoringTiles;
    }
}
