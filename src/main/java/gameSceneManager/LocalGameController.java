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
            root = loadFXML("gameSceneManager/localGame");
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
        scene.getStylesheets().add(getClass().getResource("gameSceneManager/localGame.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
