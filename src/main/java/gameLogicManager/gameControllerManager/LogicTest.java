package gameLogicManager.gameControllerManager;


import gameLogicManager.gameModel.gameBoard.Game;

public class LogicTest {

    public static void main( String[] args ){

        GameEngine gameEngine = GameEngine.getInstance(false);


        //FlowManager a servercontroller eklenmeli

        gameEngine.transformTerrain(0,6); //DESERT
        gameEngine.transformTerrain(1, 6); //DESERT
        gameEngine.transformTerrain(2, 6); //DESERT

       //GameEngine.update();

        //for( int i = 0; i < 113; i++ ){
        //    System.out.println(i+": " + game.getTerrainList()[i].getType() + " | " + game.getTerrainList()[i].getStructure().toString() );
        //}

    }
}
