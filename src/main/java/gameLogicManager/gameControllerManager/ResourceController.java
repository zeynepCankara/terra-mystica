package gameLogicManager.gameControllerManager;

import gameLogicManager.gameModel.gameBoard.TerrainType;
import gameLogicManager.gameModel.player.Player;

/**
 * This class is to control all the resources in the game.
 * It is a Singleton.
 * @author Rafi Coktalas
 * @version 10.05.2020
 */
public class ResourceController implements NotificationHandler{

    private static ResourceController uniqueInstance; //Singleton

    public static ResourceController getInstance(){
        if( uniqueInstance == null ){
            uniqueInstance = new ResourceController();
        }
        return uniqueInstance;
    }

    private ResourceController(){}

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

    public boolean obtainResourceOfDwelling(Player currentPlayer) {
        int workersNeeded = 1;
        int coinsNeeded = 2;
        if(currentPlayer.getNumOfWorkers() >= workersNeeded && currentPlayer.getCoins() >= coinsNeeded){
            currentPlayer.setNumOfWorkers(currentPlayer.getNumOfWorkers() - workersNeeded);
            currentPlayer.setCoins(currentPlayer.getCoins()-coinsNeeded);
            return true;
        }
        return false;
    }
    public boolean obtainIncomeOfDwelling(Player currentPlayer) {
        //TODO

        return false;
    }

    public boolean obtainResourceForShipping(Player currentPlayer) {
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
            return true;
        }
        return false;
    }

    public boolean obtainIncomeForShipping(Player currentPlayer) {
        //TODO

        return false;
    }

    public boolean obtainResourceForImprovement(Player currentPlayer) {
        //TODO

        return false;
    }

    public boolean obtainIncomeForImprovement(Player currentPlayer) {
        //TODO

        return false;
    }
}
