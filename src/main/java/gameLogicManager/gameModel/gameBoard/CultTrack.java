package gameLogicManager.gameModel.gameBoard;

import gameLogicManager.gameModel.player.Player;

import java.util.HashMap;

/**
 * Entity object for Cult track
 * @author Rafi Coktalas
 * @version 10.05.2020
 */
public class CultTrack {
    private String name;
    private int advancements[];

    public CultTrack(String name, int numberOfPlayers){
        this.name = name;
        advancements = new int[numberOfPlayers];
        for(int i = 0; i < numberOfPlayers; i++){
            advancements[i] = 0;
        }
    }

    /*
    private Player[][] track;
    private HashMap<Integer, Boolean> orders;
    public CultTrack( Player[] players ){
        track = new Player[10][4]; // first index holds the slots on the track, the second index holds the players on the slot.

        for( int j = 0; j < 4; j++ ){
            track[0][j] = players[j];
        }

        for( int i = 1; i < 10; i++ ){
            for( int j = 0; j < 4; j++ ){
                track[i][j] = null;
            }
        }
    }

    public void updateCultTrack( Player p, int numberOfSteps ){
        for( int i = 0; i < 10; i++ ){
            for( int j = 0; j < 4; j++ ){
                if( track[i][j] == p ){
                    track[i][j] = null;
                    track[i+numberOfSteps][j] = p;
                }
            }
        }
    }*/
}
