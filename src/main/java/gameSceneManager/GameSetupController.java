package gameSceneManager;

import javafx.animation.FadeTransition;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

import static gameSceneManager.App.loadFXML;

/**
 * Controls the game initialization parameters
 * @author Zeynep Cankara
 * @version 11.05.2020
 */
public class GameSetupController extends SceneController {
    // Properties
    ImageView goBackImg;
    Button defaultMapButton;
    Button randomMapButton;

    public GameSetupController(Stage stage) throws IOException {
        super.root = null;
        try {
            super.root = loadFXML("gameSetup");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // scene = stage.getScene(); // NOTE: This causes error in exec
        scene = new Scene(super.root);
        initController(stage);
    }


    @Override
    public void initController(Stage stage) throws IOException {
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource("gameSetup.css").toExternalForm());
        stage.setScene(scene);
        stage.show();


        // Retrieve the UI items from fxml file
        goBackImg = (ImageView) scene.lookup("#goBackImg");
        defaultMapButton = (Button) scene.lookup("#defaultMapBtn");
        randomMapButton = (Button) scene.lookup("#randomMapBtn");


        Parent finalRoot = super.root;
        goBackImg.setOnMouseClicked(event -> {
            FadeTransition fadeAnimation = new FadeTransition(Duration.seconds(1), finalRoot);
            fadeAnimation.setOnFinished(event1 ->
            {
                try {
                    finalRoot.setVisible(false);
                    App.setController(0, stage);
                } catch (IOException e) {
                    System.out.println(e);
                }
            });
            fadeAnimation.play();
        });

        defaultMapButton.setOnMouseClicked(event -> {
            FadeTransition fadeAnimation = new FadeTransition(Duration.seconds(0.5), finalRoot);
            fadeAnimation.setOnFinished(event1 ->
            {
                try {
                    finalRoot.setVisible(false);
                    App.setController(2, stage);
                } catch (IOException e) {
                    System.out.println(e);
                }
            });
            fadeAnimation.play();
        });

        randomMapButton.setOnMouseClicked(event -> {
            FadeTransition fadeAnimation = new FadeTransition(Duration.seconds(0.5), finalRoot);
            fadeAnimation.setOnFinished(event1 ->
            {
                try {
                    finalRoot.setVisible(false);
                    App.setController(2, stage);
                } catch (IOException e) {
                    System.out.println(e);
                }
            });
            fadeAnimation.play();
        });
    }

}

