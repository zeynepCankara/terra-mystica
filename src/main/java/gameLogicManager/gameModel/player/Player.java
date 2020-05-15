package gameLogicManager.gameModel.player;
import java.util.HashSet;
import gameLogicManager.gameModel.gameBoard.Structure;

import java.util.HashSet;

public class Player {
    private String name;
    private Faction faction;
    private int shipping;
    private int spadeRate;
    private int numOfWorkers;
    private int coins;
    private int remainedDwelling;
    private int remainedTradingHouse;
    private int remainedSanctuary;
    private int remainedTemple;
    private int remainedStronghold;
    private HashSet<Structure> structuresBuilt;
    private int numOfPriests;
    private int score;

    public Faction getFaction() {
        return faction;
    }

    public int getNumOfWorkers() {
        return numOfWorkers;
    }

    public void setNumOfWorkers(int numOfWorkers) {
        this.numOfWorkers = numOfWorkers;
    }

    public int getSpadeRate() {
        return spadeRate;
    }

    public int getShipping() {
        return shipping;
    }
    public int getCoins() {
        return coins;
    }
    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void setShipping(int shipping){
        this.shipping = shipping;
    }
    public int getNumOfPriests(){
        return numOfPriests;
    }
    public void setNumOfPriests(int numOfPriests)
    {
        this.numOfPriests = numOfPriests;
    }

    public int getRemainedDwelling() {
        return remainedDwelling;
    }

    public void setRemainedDwelling(int remainedDwelling) {
        this.remainedDwelling = remainedDwelling;
    }

    public void addStructure(Structure structure){
        structuresBuilt.add(structure);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setSpadeRate(int spadeRate) {
        this.spadeRate = spadeRate;
    }

    public boolean hasStronghold() {
        //TODO
        return true;
    }

    public int getRemainedTradingHouse() {
        return remainedTradingHouse;
    }

    public void setRemainedTradingHouse(int remainedTradingHouse) {
        this.remainedTradingHouse = remainedTradingHouse;
    }

    public int getRemainedSanctuary() {
        return remainedSanctuary;
    }

    public void setRemainedSanctuary(int remainedSanctuary) {
        this.remainedSanctuary = remainedSanctuary;
    }

    public int getRemainedTemple() {
        return remainedTemple;
    }

    public void setRemainedTemple(int remainedTemple) {
        this.remainedTemple = remainedTemple;
    }

    public int getRemainedStronghold() {
        return remainedStronghold;
    }

    public void setRemainedStronghold(int remainedStronghold) {
        this.remainedStronghold = remainedStronghold;
    }
}
