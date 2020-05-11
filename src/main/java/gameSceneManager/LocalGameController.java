package gameSceneManager;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static gameSceneManager.App.loadFXML;

/**
 * Controls the local game play UI of the application
 * @author Zeynep Cankara
 * @version 09.05.2020
 */

public class LocalGameController extends SceneController {

    public LocalGameController(Stage stage) throws IOException {
        Parent root = null;
        try {
            root = loadFXML("localGame");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // scene = stage.getScene(); // NOTE: This causes error in exec
        scene = new Scene(root);
        initController(stage);
    }


    @Override
    public void initController(Stage stage) throws IOException {
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource("localGame.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    /*
    for( int i = 0; i < 13 ){
        for( int j = 0; j < 5; j++ ){
            //ADD A HEXAGON at (236 + 68*i, x + 120*j)
            //ID = j*25 + i
        }
    }

    for( int i = 0; i < 12 ){
        for( int j = 0; j < 4; j++ ){
            //ADD A HEXAGON at (236 + 34 + 68*i, x + 60 + 120*j)
            //ID = 13 + j*25 + i
        }
    }
     */
}
