package gameLogicManager.gameModel.gameBoard;

/**
 * This enumeration is to associate terrains with unique integers.
 * @author Rafi Coktalas
 * @version 10.05.2020
 */
public enum TerrainType {
    Plains(0),
    Swamp(1),
    Lakes(2),
    Forest(3),
    Mountains(4),
    Wasteland(5),
    Desert(6),
    River(7);

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
