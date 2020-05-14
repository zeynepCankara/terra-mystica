package gameLogicManager.gameModel.player;

public enum RemainedStructure {
    DWELLING(8),
    TRADINGHOUSE(4),
    TEMPLE(3),
    SANCTUARY(1),
    STRONGHOLD(1);

    private int remained;

    RemainedStructure(int setUpCount) {
        remained = setUpCount;
    }

    public int getRemained() {
        return remained;
    }

    public void setRemained(int remained) {
        this.remained = remained;
    }
}


