package gameLogicManager.gameModel.gameBoard;

public abstract class Structure {
    protected int requiredWorkers;
    protected int requiredCoins;
    protected int powerValue;

    public  int getRequiredWorkers() {
        return requiredWorkers;
    }

    public  int getRequiredCoins() {
        return requiredCoins;
    }

    public  int getPowerValue() {
        return powerValue;
    }

}
