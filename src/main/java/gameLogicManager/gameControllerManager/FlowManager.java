package gameLogicManager.gameControllerManager;

import gameLogicManager.gameModel.gameBoard.*;
import gameLogicManager.gameModel.player.*;

/**
 * This class is to control the game flow.
 * It is a facade class for controllers to communicate with entities and UI.
 * @author Rafi Coktalas
 * @version 10.05.2020
 */
public class FlowManager{

    private static FlowManager uniqueInstance; //Singleton

    // Controller Instances
    private ResourceController resourceController;
    private ActionController actionController;
    private AdjacencyController adjacencyController;

    private Player currentPlayer;
    private GameEngine gameEngine;
    private static Game game;

    public static FlowManager getInstance(){
        if( uniqueInstance == null ){
            uniqueInstance = new FlowManager();
        }
        return uniqueInstance;
    }

    private FlowManager(){
        resourceController = ResourceController.getInstance(); //TODO
        actionController = ActionController.getInstance(); //TODO
        adjacencyController = AdjacencyController.getInstance(); //TODO
        gameEngine = GameEngine.getInstance(); //TODO
    }

/*
    0: Action is successful.
    1: Not enough workers.
    2: Not enough power.
    3: Not enough coins.
    4: Not enough priests.
    5: Not enough victory points.
 */

    public void initializeGame(boolean isRandom) {
        game = Game.getInstance(isRandom); // + Players and their factions //TODO
    }

    public boolean transformTerrain(int terrainID, TerrainType newTerrainType) {
        Terrain terrain = getTerrain(terrainID); // getTerrain returns Terrain object from the given id.(DECIDE THE CLASS OF THE FUNCTION)

        /* Player cannot transform if the terrain is not available or it's the same terrain */
        if(!terrain.isAvailable() || terrain.getType().getTerrainTypeID() == newTerrainType.getTerrainTypeID()){
            return false;
        }

        /* Check if the player has enough workers to have enough spades, obtain spades if possible */
        if(!resourceController.obtainSpade(currentPlayer, terrain.getType().getTerrainTypeID(), newTerrainType.getTerrainTypeID())){
            return false;
        }

        actionController.transformTerrain(terrain, newTerrainType);

        adjacencyController.updateAdjacencyList(currentPlayer, terrain);

        return true;
    }

    /**
     * Build dwelling on the given terrain if you have enough resources
     * @param terrainID	where the dwelling will be built on
     * @return			whether build is successful or not
     */
    public boolean buildDwelling(int terrainID)
    {
        Terrain terrain = getTerrain(terrainID);

        /* If the terrain is not empty(available), you cannot build a dwelling */
        if(!terrain.isAvailable()){
            return false;
        }

        /* Chosen terrain must be adjacent to other structure terrains */
        if(!adjacencyController.isAdjacent(currentPlayer, terrain)){
            return false;
        }

        /* Check required resources and obtain resources if possible */
        if(!resourceController.obtainResourceOfDwelling(currentPlayer)){
            return false;
        }

        actionController.build(currentPlayer, terrain);//create dwelling object on terrain, update attributes of player
        resourceController.obtainIncomeOfDwelling(currentPlayer);
        adjacencyController.updateAdjacencyList(currentPlayer, terrain);

        return true;
    }

    public boolean improveShipping()
    {
        /*shipping cannot be more than 3, cannot be upgraded anymore */
        if(currentPlayer.getShipping() == 3){
            return false;
        }

        if(resourceController.obtainResourceForShipping(currentPlayer)){
            return false;
        }

        actionController.improveShipping(currentPlayer);
        resourceController.obtainIncomeForShipping(currentPlayer);
        adjacencyController.updateAdjacencyList(currentPlayer);

        return true;
    }

    public boolean improveTerraforming()
    {
        /*worker per spade cannot be less than 1, cannot be upgraded anymore */
        if(currentPlayer.getSpadeRate() == 1){
            return false;
        }

        if(!resourceController.obtainResourceForImprovement(currentPlayer)){
            return false;
        }
        actionController.improveTerraforming(currentPlayer);
        resourceController.obtainIncomeForImprovement(currentPlayer);

        return true;
    }

    private Terrain getTerrain(int terrainID) {

        return game.getTerrain( terrainID );
    }



}
