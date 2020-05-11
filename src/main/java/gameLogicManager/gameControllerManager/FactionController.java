package gameLogicManager.gameControllerManager;

/**
 * This class is to control if an action is affected by one of the players' faction.
 * It is a Singleton.
 * @author Rafi Coktalas
 * @version 10.05.2020
 */
public class FactionController implements NotificationHandler{

    private static FactionController uniqueInstance; //Singleton

    public static FactionController getInstance(){
        if( uniqueInstance == null ){
            uniqueInstance = new FactionController();
        }
        return uniqueInstance;
    }

    private FactionController(){}
}
