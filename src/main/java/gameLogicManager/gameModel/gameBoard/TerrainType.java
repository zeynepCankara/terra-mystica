package gameLogicManager.gameModel.gameBoard;

/**
 * This enumeration is to associate terrains with unique integers.
 * @author Rafi Coktalas
 * @version 10.05.2020
 */
public enum TerrainType {
    PLAINS(0),
    SWAMP(1),
    LAKES(2),
    FOREST(3),
    MOUNTAINS(4),
    WASTELAND(5),
    DESERT(6),
    RIVER(7);

    private int terrainTypeID;

    TerrainType(int terrainTypeID){
        this.terrainTypeID = terrainTypeID;
    }

    public int getTerrainTypeID() {
        return terrainTypeID;
    }

    public void setTerrainTypeID(int id) {
        terrainTypeID = id;
    }
}
