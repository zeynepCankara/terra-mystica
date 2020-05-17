package gameSceneManager;

import javafx.animation.FadeTransition;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.HashMap;

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
    // Button pressed
    static HashMap<String, Integer> gameState = new HashMap<String, Integer>();
    Integer isDefaultMap = 1;

    // ImageViews from UI
    ImageView[] factionImageViews;
    static String []factionNames = {"AUREN",
            "WITCHES",
            "ALCHEMISTS",
            "DARKLINGS",
            "HALFLINGS",
            "CULTISTS",
            "ENGINEERS",
            "DWARVES",
            "MERMAIDS",
            "SWARMLINGS",
            "CHAOS_MAGICIANS",
            "GIANTS",
            "FAKIRS",
            "NOMADS"};


    public GameSetupController(Stage stage) throws IOException {
        factionImageViews = new ImageView[14];
        // Note: Used the index of factionNames as Id

        super.root = null;
        try {
            super.root = loadFXML("gameSetup");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // scene = stage.getScene(); // NOTE: This causes error in exec
        super.scene = new Scene(super.root);
        initController(stage);

    }


    @Override
    public void initController(Stage stage) throws IOException {
        super.scene.getStylesheets().clear();
        super.scene.getStylesheets().add(getClass().getResource("gameSetup.css").toExternalForm());
        stage.setScene(super.scene);
        stage.show();


        // Retrieve the UI items from fxml file
        goBackImg = (ImageView) super.scene.lookup("#goBackImg");
        defaultMapButton = (Button) super.scene.lookup("#defaultMapBtn");
        randomMapButton = (Button) super.scene.lookup("#randomMapBtn");


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
                    setInitParameters();
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
                    isDefaultMap = 0;
                    setInitParameters();
                    finalRoot.setVisible(false);
                    App.setController(2, stage);
                } catch (IOException e) {
                    System.out.println(e);
                }
            });
            fadeAnimation.play();
        });

        // Init listeners of the factions
        for(int i = 0; i  < 14; i++){
            factionImageViews[i] = (ImageView) super.scene.lookup("#" + factionNames[i]);
            // remember the selected faction
            Integer finalI = i;
            factionImageViews[i].setOnMouseClicked(event -> {
                System.out.println("select: " + factionNames[finalI]);
                gameState.put("faction", finalI);
            });
        }

        // initialize the game parameters

    }

    /**
     * Setter for game initialization parameters
     *
     */
    public void setInitParameters(){
        gameState.put("isDefaultMap", isDefaultMap);
    }

    /**
     * Getter for game initialization parameters
     *
     */
    public static HashMap<String, Integer> getInitParameters(){
        return gameState;
    }

}

