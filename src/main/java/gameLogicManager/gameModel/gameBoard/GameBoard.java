package gameLogicManager.gameModel.gameBoard;


public class GameBoard {

    public final int NO_OF_TERRAINS = 113;
    public final int[] DEFAULT_MAP = {
            0, 4, 3, 2, 6, 5, 0, 1, 5, 3, 2, 5, 1,
            6, 7, 7, 0, 1, 7, 7, 6, 1, 7, 7, 6,
            7, 7, 1, 7, 4, 7, 3, 7, 3, 7, 4, 7, 7,
            3, 2, 6, 7, 7, 5, 2, 7, 5, 7, 5, 0,
            1, 0, 5, 2, 1, 0, 4, 6, 7, 7, 3, 1, 2,
            4, 3, 7, 7, 6, 3, 7, 7, 7, 0, 4, 0,
            7, 7, 7, 4, 7, 5, 7, 3, 7, 6, 2, 2, 6,
            6, 2, 0, 7, 7, 7, 2, 1, 7, 4, 0, 4,
            5, 1, 4, 2, 5, 3, 6, 0, 4, 7, 2, 3, 5
    };
    private Terrain[] terrainList;

    public GameBoard( boolean isRandom ) {
        terrainList = new Terrain[113];

        for (int i = 0; i < NO_OF_TERRAINS; i++) {
            terrainList[i].setId(i);
            terrainList[i].setType(DEFAULT_MAP[i]);
        }

        if( isRandom ){
            randomize((int) (Math.random() * 6 + 1));
        }

    }


    public void randomize( int n ) {
        for( Terrain t : terrainList ){
            if(t.getType() != TerrainType.RIVER) {
                int newTerrainTypeID = ( t.getType().getTerrainTypeID() + n ) % 7;
                t.setType(newTerrainTypeID);
            }
        }
    }

    public Terrain getTerrain( int terrainID ){
        return terrainList[terrainID];
    }

    public Terrain[] getTerrainList(){
        return terrainList;
    }
}
