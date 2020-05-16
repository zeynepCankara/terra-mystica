package gameLogicManager.gameControllerManager;

import gameLogicManager.gameModel.gameBoard.*;
import gameLogicManager.gameModel.player.*;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

/**
 * This class is to control if an action is affected by adjacency.
 * It is a Singleton.
 * @author Rafi Coktalas
 * @version 10.05.2020
 */
public class AdjacencyController{

    private static AdjacencyController uniqueInstance; //Singleton

    public static AdjacencyController getInstance(){
        if( uniqueInstance == null ){
            uniqueInstance = new AdjacencyController();
        }
        return uniqueInstance;
    }

    private AdjacencyController(){

    }


    public boolean isAdjacent(Player player, Terrain terrain, Terrain[] terrainList ) {

        int[] level0 = {-13,-12,-1,1,12,13};
        int[] level1 = {-25,-14,-11,11,14,25};
        int[] level2 = {-26,-24,-2,2,24,26};
        int[] level3 = {-38,-37,-27,-23,-15,-10,10,15,23,27,37,38};
        int[] level4 = {-39,-36,-3,3,36,39};
        switch(player.getShipping()) {
            case 4:
                for( int i = 0; i < 6; i++ ){
                    if(terrain.getId()+level4[i]<113 && terrain.getId()+level4[i]>=0 ){
                        if( terrainList[terrain.getId()+level4[i]].getOwner()==player ){
                            return true;
                        }
                    }
                }
            case 3:
                for( int i = 0; i < 12; i++ ){
                    if(terrain.getId()+level3[i]<113 && terrain.getId()+level3[i]>=0 ){
                        if( terrainList[terrain.getId()+level3[i]].getOwner()==player ){
                            return true;
                        }
                    }
                }
            case 2:
                for( int i = 0; i < 6; i++ ){
                    if(terrain.getId()+level2[i]<113 && terrain.getId()+level2[i]>=0 ){
                        if( terrainList[terrain.getId()+level2[i]].getOwner()==player ){
                            return true;
                        }
                    }
                }
            case 1:
                for( int i = 0; i < 6; i++ ){
                    if(terrain.getId()+level1[i]<113 && terrain.getId()+level1[i]>=0 ){
                        if( terrainList[terrain.getId()+level1[i]].getOwner()==player ){
                            return true;
                        }
                    }
                }
            case 0:
                for( int i = 0; i < 6; i++ ){
                    if(terrain.getId()+level0[i]<113 && terrain.getId()+level0[i]>=0 ){
                        if( terrainList[terrain.getId()+level0[i]].getOwner()==player ){
                            return true;
                        }
                    }
                }
                break;
            default:
                return false;
        }
        return false;

    }
}
