package gameLogicManager.gameModel.gameBoard;

import gameLogicManager.gameModel.player.Player;

/**
 * Terrain entity.
 * @author Rafi Coktalas
 * @version 11.05.2020
 */
public class Terrain {
    private TerrainType type;
    private int id; //id of a terrain is used to place it on the Map
    private Structure structure;
    private Player owner;

    public Terrain(){}
    public Terrain(int id, TerrainType terrainType, StructureType structureType){
        this.id = id;
        this.type = terrainType;
        setStructure(structureType);
    }

    public boolean isAvailable() {
        if(structure == null){
            return true;
        }
        return false;
    }
    public TerrainType getType(){
        return type;
    }

    public void setType(TerrainType terrainType) {
        type = terrainType;
    }
    public void setType(int terrainTypeID) {
        type.setTerrainTypeID(terrainTypeID);
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public void setStructure(StructureType structureType) {
        switch(structureType){
            case Dwelling:
                this.structure = new Dwelling();
                break;
            case TradingHouse:
                this.structure = new TradingHouse();
                break;
            case Temple:
                this.structure = new Temple();
                break;
            case Sanctuary:
                this.structure = new Sanctuary();
                break;
            case StrongHold:
                this.structure = new StrongHold();
                break;
            default:
                this.structure = null;
                break;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static TerrainType terrainIdToTypeConverter(int terrainTypeID){
        switch (terrainTypeID){
            case 0:
                return TerrainType.Plains;
            case 1:
                return TerrainType.Swamp;
            case 2:
                return TerrainType.Lakes;
            case 3:
                return TerrainType.Forest;
            case 4:
                return TerrainType.Mountains;
            case 5:
                return TerrainType.Wasteland;
            case 6:
                return TerrainType.Desert;
            case 7:
                return TerrainType.River;
            default:
                return TerrainType.River;
        }
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public String toString(){
        return String.valueOf(type);
    }
}
