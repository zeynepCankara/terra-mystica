package org.example;

import javafx.stage.Stage;

import java.io.IOException;

/**
 * Manages the transition between scenes switches the game control
 * @author Zeynep Cankara
 * @version 04.05.2020
 */


public class GameEngine {
    /*

    //Singleton
    private static GameEngine gameEngine = null;

    // Properties
    private SceneController controller;
    private Stage primaryStage;
    //private ArrayList<Player> players;

    // Constructor
    private GameEngine() {
        primaryStage = null;
        //players = null;
    }



    public static GameEngine getInstance(){
        if( gameEngine == null )
            gameEngine = new GameEngine();
        return gameEngine;
    }


    public void initializePrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        try {
            // To run the game from the beginning, comment the lines below and uncomment the commented line.
            // This is for faster testing.

            controller = new MainMenu(primaryStage);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        // Maximize the stage window and show the stage.
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }


    public void setPlayers(ArrayList<Player> players)
    {
        this.players = players;
    }

    public void setController(int controllerType) throws IOException {
        switch (controllerType)
        {
            // 0 is the code for Main Menu Controller.
            case 0:
                controller = new MainMenu(primaryStage);
                break;
            // 1 is the code for Help Controller.
            case 1:
                controller = new HelpController(primaryStage);
                break;
            // 2 is the code for Player Selection Controller.
            case 2:
                controller = new PlayerSelectionController(primaryStage);
                break;
            // 3 is the code for Single Game Controller.
            case 3:
                controller = new SingleGameController(primaryStage, players);
                break;
            // 4 is the code for Login Controller.
            case 4:
                controller = new LoginController(primaryStage);
                break;
            // 5 is the code for Register Controller.
            case 5:
                controller = new RegisterController(primaryStage);
                break;
            // 6 is the coded for Matchmaking Controller.
            case 6:
                controller = new MatchmakingController(primaryStage);
                break;
            // 7 is the coded for Matchmaking Controller.
            case 7:
                controller = new MultiGameController(primaryStage);
                break;

        }
    }

    public SceneController getController() {
        return controller;
    }

    */
}

