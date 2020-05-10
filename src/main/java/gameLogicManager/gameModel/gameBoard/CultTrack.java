package gameLogicManager.gameModel.gameBoard;

import java.util.HashMap;

/**
 * Entity object for Cult track
 * @author Rafi Coktalas
 * @version 10.05.2020
 */
public class CultTrack {
    private String name;
    private int noOfPlayers;
    private int[][] track;
    private HashMap<Integer, Boolean> orders;
}
