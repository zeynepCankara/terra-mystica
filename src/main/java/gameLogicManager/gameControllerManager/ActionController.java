package gameLogicManager.gameControllerManager;

import gameLogicManager.gameModel.gameBoard.*;
import gameLogicManager.gameModel.player.Player;

/**
 * This class is to control the outcome of an action.
 * It is a Singleton.
 * @author Rafi Coktalas
 * @version 10.05.2020
 */
public class ActionController{

    private static ActionController uniqueInstance; //Singleton

    public static ActionController getInstance(){
        if( uniqueInstance == null ){
            uniqueInstance = new ActionController();
        }
        return uniqueInstance;
    }

    private ActionController(){}

    /**
     @param terrain which terrain to tranform
     @param newTerrainType the new type of the terrain
     @return boolean always true
     */
    public boolean transformTerrain(Terrain terrain, TerrainType newTerrainType){
        terrain.setType(newTerrainType);
        return true;
    }

    /**
     * @param currentPlayer action owner player
     * @param terrain which terrain to build the dwelling on
     * @return oolean always true
     */
    public boolean build(Player currentPlayer, Terrain terrain) { //ADD SERVER METHOD!!!!!!
        Dwelling  dwelling = new Dwelling();
        currentPlayer.addStructure(dwelling);
        terrain.setStructure(dwelling); //needs server update for map
        return true;
    }

    public boolean improveShipping(Player currentPlayer) {
        //Assuming there are no exceptional cases since all were checked in the flowManager
        currentPlayer.setShipping(currentPlayer.getShipping() + 1);
        return true;
    }

    public boolean improveTerraforming(Player currentPlayer) {
        currentPlayer.setSpadeRate(currentPlayer.getSpadeRate() - 1);
        return true;
    }

    //HANDLE SERVER IN THIS METHOD!!!!!!
    public boolean upgradeStructure(Player currentPlayer, Terrain terrain, StructureType newStructureType) {
        Structure newStructure;
        switch (newStructureType){
            case TRADINGHOUSE:
                newStructure = new TradingHouse();
            case TEMPLE:
                newStructure = new Temple();
            case SANCTUARY:
                newStructure = new Sanctuary();
            default:
                newStructure = new StrongHold();
        }
        currentPlayer.removeStructure(terrain.getStructure()); //remove old structure from player's list
        currentPlayer.addStructure(newStructure);
        terrain.setStructure(newStructure);//needs server update for map
        return true;
    }
}
