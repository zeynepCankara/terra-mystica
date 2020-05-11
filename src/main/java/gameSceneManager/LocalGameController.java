package gameSceneManager;

import javafx.animation.FadeTransition;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

import static gameSceneManager.App.loadFXML;

/**
 * Controls the local game play UI of the application
 * @author Zeynep Cankara
 * @version 09.05.2020
 */

public class LocalGameController extends SceneController {
    // Properties
    ImageView goBackImg;

    public LocalGameController(Stage stage) throws IOException {
        super.root = null;
        try {
            super.root = loadFXML("localGame");
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
        scene.getStylesheets().add(getClass().getResource("localGame.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

        // Return to the main window
        goBackImg = (ImageView) scene.lookup("#goBackImg");


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
