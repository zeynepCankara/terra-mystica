package gameLogicManager.gameControllerManager;

/**
 * This class is to control the game flow.
 * It is a facade class for controllers to communicate with entities and UI.
 * @author Rafi Coktalas
 * @version 10.05.2020
 */
public class FlowManager{

    private static FlowManager uniqueInstance; //Singleton

    public static FlowManager getInstance(){
        if( uniqueInstance == null ){
            uniqueInstance = new FlowManager();
        }
        return uniqueInstance;
    }

    private FlowManager(){}

    public boolean transformTerrain(int terrainID, int newTerrainTypeID) {
        //TODO

        //check

        return true;
    }
}
