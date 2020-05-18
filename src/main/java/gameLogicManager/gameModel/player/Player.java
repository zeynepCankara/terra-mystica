package gameLogicManager.gameModel.player;
import java.util.HashSet;
import gameLogicManager.gameModel.gameBoard.Structure;
import gameLogicManager.gameModel.gameBoard.TerrainType;

import java.util.HashSet;

public class Player {
    private String name;
    private int playerIndex;
    private Faction faction;
    private int shipping;
    private int spadeRate;
    private int numOfWorkers;
    private int coins;
    private HashSet<Structure> structuresBuilt;
    private int[] powerBowl;
    private int numOfPriests;
    private int score;
    private boolean isPass;

    public Player(FactionType factionType, int playerIndex) {
        this.faction = new Faction(factionType);
        this.playerIndex = playerIndex;
        shipping = 0;
        spadeRate = 3;
        numOfWorkers = Faction.getWorkerAtSetup(factionType);
        coins = Faction.getCoinAtSetup(factionType);
        structuresBuilt = new HashSet<Structure>();
        numOfPriests = 2;//EDIT
        score = 20;
        powerBowl = new int[3];
        powerBowl[0] = 5;
        powerBowl[1] = 7;
        powerBowl[2] = 0;
        isPass = false;
    }

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

    public void addStructure(Structure structure){
        structuresBuilt.add(structure);
    }
    public void removeStructure(Structure structure){structuresBuilt.remove(structure);}

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setSpadeRate(int spadeRate) {
        this.spadeRate = spadeRate;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public boolean hasStronghold() {
        //TODO
        return true;
    }

    public void gainPower(int powerCount){//will move power tokens from one bowl to the next one
        if(powerBowl[0] != 0){
            if(powerBowl[0] >= powerCount){
                powerBowl[0] -= powerCount;
                powerBowl[1] += powerCount;
            }
            else{
                powerBowl[1] += powerBowl[0];
                powerCount -= powerBowl[0];
                powerBowl[0] = 0;
                powerBowl[2] += powerCount;
                powerBowl[1] -= powerCount;
            }
        }
        else{
            if(powerBowl[1] >= powerCount){
                powerBowl[1] -= powerCount;
                powerBowl[2] += powerCount;
            }
            else{
                powerBowl[2] += powerBowl[1];
                powerBowl[1] = 0;
            }
        }
    }

    public int[] getPowerBowl(){
        return powerBowl;
    }

    public boolean isPass() {
        return isPass;
    }

    public void setPass(boolean pass) {
        isPass = pass;
    }

    public void setFaction(String factionName){
        FactionType factionType = FactionType.valueOf(factionName);
        this.faction = new Faction(factionType);
        numOfWorkers = Faction.getWorkerAtSetup(factionType);
        coins = Faction.getCoinAtSetup(factionType);
    }

}
