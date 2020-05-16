package gameLogicManager.gameModel.gameBoard;

import gameLogicManager.gameModel.player.Player;

import java.util.ArrayList;

public class CultBoard {
    private CultTrack[] cults;

    public CultBoard( Player[] players){
        cults = new CultTrack[4];
        for( int i = 0; i < 4; i++ ){
            cults[i] = new CultTrack(players);
        }
    }
}
