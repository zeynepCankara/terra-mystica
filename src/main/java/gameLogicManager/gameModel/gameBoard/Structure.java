package gameLogicManager.gameModel.gameBoard;

public abstract class Structure {
    protected int requiredWorkers;
    protected int requiredCoins;
    protected int powerValue;

    protected StructureType structureType;
    Structure(){
        structureType = StructureType.None;
    }

    public  int getRequiredWorkers() {
        return requiredWorkers;
    }

    public  int getRequiredCoins() {
        return requiredCoins;
    }

    public  int getPowerValue() {
        return powerValue;
    }

    public StructureType getStructureType() {
        return structureType;
    }

}
