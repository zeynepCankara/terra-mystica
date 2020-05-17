package gameLogicManager.gameModel.gameBoard;


import gameLogicManager.gameControllerManager.ServerController;

import java.util.ArrayList;
import java.util.Arrays;

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
    private Terrain[] terrainList ;

    public GameBoard( boolean isRandom ) {
        terrainList = new Terrain[NO_OF_TERRAINS];
        ArrayList<Terrain> serverTerrainList = ServerController.GetBoard();

        if(!isRandom) {

            for( int i = 0; i < NO_OF_TERRAINS; i++ ){
                terrainList[i] = new Terrain(i, Terrain.terrainIdToTypeConverter(DEFAULT_MAP[i]), StructureType.None );
                if( serverTerrainList.get(i).getType() != terrainList[i].getType() )
                    ServerController.TransformTerrain(Terrain.terrainIdToTypeConverter(DEFAULT_MAP[i]),i);
                if( serverTerrainList.get(i).getStructure() != null && serverTerrainList.get(i).getStructure().getStructureType() != StructureType.None )
                    ServerController.ConstructBuilding(StructureType.None,i);
            }

        }
        else {

            for (int i = 0; i < NO_OF_TERRAINS; i++) {
                terrainList[i] = new Terrain(i, Terrain.terrainIdToTypeConverter(randomize(DEFAULT_MAP[i])), StructureType.None );
            }



        }

    }
    public int randomize( int n ){
        return (((int) (Math.random() * 6 + 1)) + n) % 7;
    }




    public Terrain getTerrain( int terrainID ){
        return terrainList[terrainID];
    }

    public Terrain[] getTerrainList(){
        return terrainList;
    }

    //TODO this function needs a check
    public void updateTerrainList(ArrayList<Terrain> terrainList){
        this.terrainList = terrainList.toArray(new Terrain[113]);
    }
}
