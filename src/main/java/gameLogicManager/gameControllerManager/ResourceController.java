package gameLogicManager.gameControllerManager;

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

}
