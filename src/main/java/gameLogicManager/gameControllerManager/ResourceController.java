package gameLogicManager.gameControllerManager;

import gameLogicManager.gameModel.gameBoard.*;
import gameLogicManager.gameModel.player.Player;

/**
 * This class is to control all the resources in the game.
 * It is a Singleton.
 * @author Rafi Coktalas
 * @version 10.05.2020
 */
public class ResourceController{

    private static ResourceController uniqueInstance; //Singleton

    public static ResourceController getInstance(){
        if( uniqueInstance == null ){
            uniqueInstance = new ResourceController();
        }
        return uniqueInstance;
    }

    private ResourceController(){}

    /**
     @param currentPlayer action owner player
     @param type the type of the current terrain
     @param newType new type of the terrain
     @return boolean whether there are enough resources or not
     */
    public boolean obtainSpade(Player currentPlayer,int type, int newType) {
        int spadesNeedToConvert = Math.abs(type - newType);
        if(spadesNeedToConvert > 3)
            spadesNeedToConvert = 7 - spadesNeedToConvert;

        if(spadesNeedToConvert*currentPlayer.getSpadeRate() <= currentPlayer.getNumOfWorkers())
        {
            currentPlayer.setNumOfWorkers(currentPlayer.getNumOfWorkers() - spadesNeedToConvert * currentPlayer.getSpadeRate());
            return true;
        }
        return false;
    }

    /**
     * Checking if the player has enough resource for improving shipping
     * @param currentPlayer to determine which player is doing the action
     * @return int 0 if it is successful, otherwise a positive integer according to the reason of failure
     */
    public int obtainResourceForShipping(Player currentPlayer) {
        //In order to get the resources first the player has to have the greater or equal than the desired amount
        //of both priests and coins.
        int requiredCoins = 4;
        int requiredPriests = 1;
        //This function only helps to get the resources from the player it does not increment the shipping value
        //It is done in action Controller.
        if(currentPlayer.getCoins() >= requiredCoins && currentPlayer.getNumOfPriests() > requiredPriests)
        {
            currentPlayer.setCoins(currentPlayer.getCoins() - requiredCoins);
            currentPlayer.setNumOfPriests(currentPlayer.getNumOfPriests() - requiredPriests);
            return 0;
        }
        //Not enough coins
        if(currentPlayer.getCoins() < requiredCoins)
            return 1;
        //Not enough priests
        else
            return 3;
    }

    public boolean obtainIncomeForShipping(Player currentPlayer) {
        if(currentPlayer.getShipping() == 1){ currentPlayer.setScore(currentPlayer.getScore() + 2); }
        else if(currentPlayer.getShipping() == 2){ currentPlayer.setScore(currentPlayer.getScore() + 3); }
        else if(currentPlayer.getShipping() == 3){ currentPlayer.setScore(currentPlayer.getScore() + 4); }

        return true;
    }
    /**
     * Checking if the player has enough resource.
     * @param currentPlayer to determine which player is doing the action
     * @return int 0 if it is successful, otherwise a positive integer according to the reason of failure
     */
    public int obtainResourceForImprovement(Player currentPlayer) {
        /* required resources for the operation */
        int requiredWorkers = 2;
        int requiredCoins = 5;
        int requiredPriests = 1;
        /* check resources and decrease if the player has resources */
        if(currentPlayer.getNumOfWorkers() >= requiredWorkers && currentPlayer.getCoins() >= requiredCoins
                && currentPlayer.getNumOfPriests() >= requiredPriests){
            currentPlayer.setNumOfWorkers(currentPlayer.getNumOfWorkers() - requiredWorkers);
            currentPlayer.setCoins(currentPlayer.getCoins() - requiredCoins);
            currentPlayer.setNumOfPriests(currentPlayer.getNumOfPriests() - requiredPriests);
            return 0;
        }
        /* inadequate resource */
        if(currentPlayer.getNumOfWorkers() < requiredWorkers)
            return 2;
        if(currentPlayer.getNumOfPriests() < requiredPriests)
            return 3;
        else
            return 1;
    }

    public boolean obtainIncomeForImprovement(Player currentPlayer) {
        currentPlayer.setScore(currentPlayer.getScore() + 6);
        return false;
    }

    public int obtainResourceOfStructure(Player currentPlayer, StructureType newStructureType) {
        Structure tempStrructure;
        switch (newStructureType){ // creates the object of new Structure
            case DWELLING:
                tempStrructure = new Dwelling();
            case TRADINGHOUSE:
                tempStrructure = new TradingHouse();
            case TEMPLE:
                tempStrructure = new Temple();
            case SANCTUARY:
                tempStrructure = new Sanctuary();
            default: //Otherwise it is Stronghold
                tempStrructure = new StrongHold();
        }
        int workersNeeded = tempStrructure.getRequiredWorkers();
        int coinsNeeded = tempStrructure.getRequiredWorkers();
        /* check worker and coins */
        if(currentPlayer.getNumOfWorkers() >= workersNeeded && currentPlayer.getCoins() >= coinsNeeded){
            currentPlayer.setNumOfWorkers(currentPlayer.getNumOfWorkers() - workersNeeded);
            currentPlayer.setCoins(currentPlayer.getCoins()-coinsNeeded);
            return 0;
        }
        if(currentPlayer.getNumOfWorkers() < workersNeeded){ //not enough workers
            return 2;
        }
        return 1; //not enough coins

    }

    public boolean obtainIncomeOfStructure(Player currentPlayer, StructureType newStructureType) {
        switch (newStructureType){ // creates the object of new Structure
            case DWELLING:
                currentPlayer.setNumOfWorkers(currentPlayer.getNumOfWorkers() + 1);
            case TRADINGHOUSE:
                currentPlayer.setCoins(currentPlayer.getCoins() + 2);
                currentPlayer.gainPower(2); //depends, may change!
            case TEMPLE:
                currentPlayer.setNumOfPriests(currentPlayer.getNumOfPriests() + 1);
            case SANCTUARY:
                currentPlayer.setNumOfPriests(currentPlayer.getNumOfPriests() + 1);  //depends, may change!
            default: //Otherwise it is Stronghold
                currentPlayer.gainPower(2);
        }
        return true;
    }

    public boolean payPriest( Player currentPlayer ) {
        if( currentPlayer.getNumOfPriests() == 0 ){
            return false;
        }
        else{
            currentPlayer.setNumOfPriests(currentPlayer.getNumOfPriests() - 1);
            return true;
        }
    }
}
