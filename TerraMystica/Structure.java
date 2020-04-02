package TerraMystica;

public abstract class Structure {
    private int structureID;
    private Terrain terrainOfStructure;

    public abstract void getRequiredResource();
    public abstract void giveIncomeOfStructue();
}
