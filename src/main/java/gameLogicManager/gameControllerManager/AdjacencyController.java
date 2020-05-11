package gameLogicManager.gameControllerManager;

/**
 * This class is to control if an action is affected by adjacency.
 * It is a Singleton.
 * @author Rafi Coktalas
 * @version 10.05.2020
 */
public class AdjacencyController implements NotificationHandler{

    private static AdjacencyController uniqueInstance; //Singleton

    public static AdjacencyController getInstance(){
        if( uniqueInstance == null ){
            uniqueInstance = new AdjacencyController();
        }
        return uniqueInstance;
    }

    private AdjacencyController(){}
}
