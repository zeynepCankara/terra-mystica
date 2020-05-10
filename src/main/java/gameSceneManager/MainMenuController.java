package gameSceneManager;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

import static gameSceneManager.App.loadFXML;

/**
 * Controls the main menu UI of the application
 * @author Zeynep Cankara
 * @version 07.05.2020
 */

public class MainMenuController extends SceneController {
    //private static Scene scene;
    // Properties
    Button localButton;
    Button onlineButton;
    Button helpButton;
    Button exitButton;
    Slider masterVolume;

    public MainMenuController(Stage stage) throws IOException {
        super.root = null;
        try {
            root = loadFXML("mainMenu");
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
        scene.getStylesheets().add(getClass().getResource("mainMenu.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

        // Get the 3 main buttons of the main menu from its fxml file.
        localButton = (Button) scene.lookup("#localButton");
        onlineButton = (Button) scene.lookup("#onlineButton");
        helpButton = (Button) scene.lookup("#helpButton");
        exitButton = (Button) scene.lookup("#exitButton");

        // Exit button closes the application
        Parent finalRoot = super.root;
        helpButton.setOnMouseClicked(event -> {
            FadeTransition fadeAnimation = new FadeTransition(Duration.seconds(1), finalRoot);
            fadeAnimation.setOnFinished(event1 ->
            {
                try {
                    finalRoot.setVisible(false);
                    App.setController(1, stage);
                } catch (IOException e) {
                    System.out.println(e);
                }
            });
            fadeAnimation.play();
        });
        exitButton.setOnMouseClicked(event -> {
            // // Initialize closing animation for main menu with 2x the normal speed.
            FadeTransition fadeAnimation = new FadeTransition(Duration.seconds(1), finalRoot);
            fadeAnimation.setFromValue(1.0);
            fadeAnimation.setToValue(0.3);
            fadeAnimation.setAutoReverse(true);
            fadeAnimation.setOnFinished(event1 ->
            {
                // Close the application.
                Platform.exit();
                System.exit(0);
            });
            fadeAnimation.play();
        });
        localButton.setOnMouseClicked(event -> {
            FadeTransition fadeAnimation = new FadeTransition(Duration.seconds(1), finalRoot);
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

