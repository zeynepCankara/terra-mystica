package gameSceneManager;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Properties of a controller that will shared across all controllers related to the scene management
 * abstract initialize method.
 * @author Zeynep Cankara
 * @version 07.05.2020
 */

public abstract class SceneController {
    // Properties
    Scene scene;
    Parent root;

    // Constructor
    public SceneController()
    {
        //Initializations are done in the respective controller classes.
    }

    // Methods

    /**
     * To initialize the UI controller related with the scene
     * @param stage
     * @throws IOException is the file-not-found exception.
     */
    public abstract void initController(Stage stage) throws IOException;
}