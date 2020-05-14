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

    public boolean obtainSpade(Player currentPlayer,TerrainType type) {
        int spadesNeedToConvert = Math.abs(currentPlayer.getFaction().getTerrainType().getTerrainTypeID() - type.getTerrainTypeID());
        if(spadesNeedToConvert > 3)
            spadesNeedToConvert = 7 - spadesNeedToConvert;
        if(spadesNeedToConvert*currentPlayer.getSpadeRate() <= currentPlayer.getNumOfWorkers())
        {
            currentPlayer.setNumOfWorkers(spadesNeedToConvert*currentPlayer.getSpadeRate()-currentPlayer.getNumOfWorkers());
            return true;
        }
        return false;
    }

    public boolean obtainResourceOfDwelling(Player currentPlayer) {
        //TODO

        return false;
    }

    public boolean obtainIncomeOfDwelling(Player currentPlayer) {
        //TODO

        return false;
    }

    public boolean obtainResourceForShipping(Player currentPlayer) {
        //TODO

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
