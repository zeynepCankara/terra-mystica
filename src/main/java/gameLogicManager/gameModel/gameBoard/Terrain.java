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
    private boolean isAvailable;
    private Structure structure;
    private Player owner;

    public boolean isAvailable() {
        return isAvailable;
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
                System.out.println(structure.structureType);
                break;
            case TradingHouse:
                this.structure = new TradingHouse();
                System.out.println(structure.structureType);
                break;
            case Temple:
                this.structure = new Temple();
                System.out.println(structure.structureType);
                break;
            case Sanctuary:
                this.structure = new Sanctuary();
                System.out.println(structure.structureType);
                break;
            case StrongHold:
                this.structure = new StrongHold();
                System.out.println(structure.structureType);
                break;
            case None:
                this.structure = new StrongHold();
                System.out.println(structure.structureType);
                break;
            default:
                System.out.println("Rafi"+structure.structureType);
        }
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
