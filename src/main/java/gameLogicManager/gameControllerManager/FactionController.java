package gameLogicManager.gameControllerManager;

import gameLogicManager.gameModel.player.FactionType;
import gameLogicManager.gameModel.player.Player;


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


    /**
     *
     * @param p
     * @return 0: Faction of the player has no effect.
     * @return 1: Darklings pay with priests instead of workers
     * @return 2: Giants always pay 2 Spades for transformation
     */
    public int transformTerrain( Player p ){
        if( p.getFaction().getType() == FactionType.DARKLINGS ){ //general ability
            return 1;
        }
        else if(p.getFaction().getType() == FactionType.GIANTS ){
            return 2;
        }
        else{
            return 0;
        }

    }

    /**
     *
     * @param p
     * @return 0: Faction of the player has no effect.
     * @return 1: Witches can build a dwelling on an unoccupied Forest Terrain without any cost, regardless of adjacency.
     */
    public int buildDwelling( Player p ){
        if( p.hasStronghold() && p.getFaction().getType() == FactionType.WITCHES){ //special action
            return 1;
        }
        else{
            return 0;
        }
    }
}
