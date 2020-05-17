package gameLogicManager.gameControllerManager;

import gameLogicManager.gameModel.gameBoard.*;
import gameLogicManager.gameModel.gameResources.ScoringTile;
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
    private static Game game;

    private int currentRound;//used for scoring tile checking


    public static FlowManager getInstance(){
        if( uniqueInstance == null ){
            uniqueInstance = new FlowManager();
        }
        return uniqueInstance;
    }

    private FlowManager(){
        resourceController = ResourceController.getInstance();
        actionController = ActionController.getInstance();
        adjacencyController = AdjacencyController.getInstance();
        game = Game.getInstance();
        currentPlayer = game.getNextPlayer();
        currentRound = 0;
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

    /**
     @param terrainID ID of the chosen terrain
     @return Terrain
     */
    private Terrain getTerrain(int terrainID) {
        game = Game.getInstance();
        return game.getTerrain( terrainID );
    }

    /**
     * Terraform the given terrain if you have enough resources
     * @param terrainID	which terrain to tranform
     * @param newTerrainType chosen new type of the terrain
     * @return int	0 if it is successful, otherwise a positive integer according to the reason of failure
     */
    public int transformTerrain(int terrainID, TerrainType newTerrainType) {
        Terrain terrain = getTerrain(terrainID); // getTerrain returns Terrain object from the given id.

        /* Player cannot transform if the terrain is not available or it's the same terrain */
        //if(!terrain.isAvailable() || terrain.getType().getTerrainTypeID() == newTerrainType.getTerrainTypeID()){
            //return 4;
        //}

        /* Check if the player has enough workers to have enough spades, obtain spades if possible */
        //if(!resourceController.obtainSpade(currentPlayer, terrain.getType().getTerrainTypeID(), newTerrainType.getTerrainTypeID())){
            //return 2;
        //}

        actionController.transformTerrain(terrain, newTerrainType);

        //adjacencyController.updateAdjacencyList(currentPlayer, terrain);
        //Bu method score güncelleye bir method halini alacak

        return 0;
    }

    /**
     * Build dwelling on the given terrain if you have enough resources
     * @param terrainID	where the dwelling will be built on
     * @return int 0 if it is successful, otherwise a positive integer according to the reason of failure
     */
    public int buildDwelling(int terrainID)
    {
        Terrain terrain = getTerrain(terrainID);

        /* If the terrain is not empty(available), you cannot build a dwelling */
        if(!terrain.isAvailable()){
            return 4;
        }

        /* Chosen terrain must be adjacent to other structure terrains */
        if(!adjacencyController.isAdjacent(currentPlayer, terrain, game.getTerrainList())){
            return 5;
        }

        /* Check required resources and obtain resources if possible */
        int result = resourceController.obtainResourceOfStructure(currentPlayer ,StructureType.Dwelling);
        if(result != 0){
            return result;
        }

        actionController.build(currentPlayer, terrain);//create dwelling object on terrain, update attributes of player

        resourceController.obtainIncomeOfStructure(currentPlayer, StructureType.Dwelling);
        resourceController.obtainIncomeOfScoringTile(currentPlayer, currentRound, StructureType.Dwelling);

        //adjacencyController.updateAdjacencyList(currentPlayer, terrain);

        return 0;
    }

    public int improveShipping()
    {
        /*shipping cannot be more than 3, cannot be upgraded anymore */
        if(currentPlayer.getShipping() == 3){
            return 6;
        }
        //Added a '!' since the obtainResourceForShipping returns true when player can afford coins & priests.
        if(resourceController.obtainResourceForShipping(currentPlayer) != 0){
            return resourceController.obtainResourceForShipping(currentPlayer);
        }

        actionController.improveShipping(currentPlayer);
        resourceController.obtainIncomeForShipping(currentPlayer);
        //adjacencyController.updateAdjacencyList(currentPlayer);

        return 0;
    }
    /**
     * Improve the terraforming skills
     * @return	0 if it is successful, otherwise a positive integer according to the reason of failure
     */
    public int improveTerraforming()
    {
        /*worker per spade cannot be less than 1, cannot be upgraded anymore */
        if(currentPlayer.getSpadeRate() == 1){
            return 6;
        }
        if(resourceController.obtainResourceForImprovement(currentPlayer) != 0){
            return resourceController.obtainResourceForImprovement(currentPlayer);
        }
        actionController.improveTerraforming(currentPlayer);
        resourceController.obtainIncomeForImprovement(currentPlayer);
        return 0;
    }

    public int upgradeStructure(int terrainID, StructureType newStructureType) {
        Terrain terrain = getTerrain(terrainID);

        /* Check required resources and obtain resources if possible,
        structure pointer is upgraded to new structure in this method */
        int result = resourceController.obtainResourceOfStructure(currentPlayer, newStructureType);
        if(result != 0){
            return result;
        }

        actionController.upgradeStructure(currentPlayer, terrain, newStructureType);//create new Structure on terrain, update attributes of player
        resourceController.obtainIncomeOfStructure(currentPlayer, newStructureType);
        resourceController.obtainIncomeOfScoringTile(currentPlayer, currentRound, newStructureType);
        //adjacencyController.updateAdjacencyList(currentPlayer, terrain);

        return result;
    }


    public int sendPriestToCult(int trackID) {
        if( currentPlayer.getNumOfPriests() == 0 ){
            return 0;
        }
        else if( true ) {
            //TODO check cult track
        }
        return 0;
    }

    public void pass(){
        resourceController.getEndOfRoundIncomeOfScoringTile(currentPlayer, currentRound);
    }

}
