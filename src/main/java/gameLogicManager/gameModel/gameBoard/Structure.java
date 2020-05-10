package gameLogicManager.gameModel.gameBoard;

public abstract class Structure {
    private int requiredWorkers;
    private int requiredCoins;
    private int powerValue;

    public int getRequiredWorkers() {
        return requiredWorkers;
    }

    public int getRequiredCoins() {
        return requiredCoins;
    }

    public int getPowerValue() {
        return powerValue;
    }
}
