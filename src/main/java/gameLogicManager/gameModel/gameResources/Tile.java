package gameLogicManager.gameModel.gameResources;

public abstract class Tile {
    protected int tileID;

    public Tile(int tileID) {
        this.tileID = tileID;
    }

    public int getId() {
        return tileID;
    }
}
