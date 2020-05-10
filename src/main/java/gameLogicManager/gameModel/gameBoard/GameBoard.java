package gameLogicManager.gameModel.gameBoard;


public class GameBoard {
    private Terrain[] terrainList;


    public void randomize() {
        for( Terrain t : terrainList ){
            if(t.getType() != TerrainType.RIVER) {
                int newTerrainTypeID = ( t.getType().getTerrainTypeID() + 1 ) % 7;
                t.setType( newTerrainTypeID );
            }
        }
    }
}