package gameLogicManager.gameModel.gameBoard;

import gameLogicManager.gameModel.player.Player;

public class Terrain {
    private TerrainType type;
    private boolean isAvailable;
    private Structure structure;
    private Player owner;

    public boolean isAvailable() {
        return isAvailable;
    }
    public TerrainType getType(){
        return type;
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

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }


}
