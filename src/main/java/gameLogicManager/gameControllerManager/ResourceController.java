package gameLogicManager.gameControllerManager;

import gameLogicManager.gameModel.gameBoard.Dwelling;
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

    public int obtainResourceOfDwelling(Player currentPlayer) {
        /* out of dwelling */
        if(currentPlayer.getRemainedDwelling() == 0){
            return 7;
        }
        int workersNeeded = (new Dwelling()).getRequiredWorkers();
        int coinsNeeded = (new Dwelling()).getRequiredWorkers();
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
    /* Income is 1 worker */
    public boolean obtainIncomeOfDwelling(Player currentPlayer) {
        currentPlayer.setNumOfWorkers(currentPlayer.getNumOfWorkers() + 1);
        return true;
    }

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

    public boolean obtainResourceForImprovement(Player currentPlayer) {
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
            return true;
        }
        /* inadequate resource */
        return false;
    }

    public boolean obtainIncomeForImprovement(Player currentPlayer) {
        currentPlayer.setScore(currentPlayer.getScore() + 6);
        return false;
    }
}
