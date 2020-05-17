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
    //  static properties
    static HashMap<String, Integer> gameState = new HashMap<String, Integer>();
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
    static HashMap<String, Integer> factionToTerrain = new HashMap<String, Integer>();
    /*
     -1: not initialized, transparent
      0: plainColor, (default)
      1: swampColor,
      2: lakeColor
      3: forestColor
      4: mountainColor
      5: wastelandColor
      6: desertColor
      7: riverColor
     */
    static {
        factionToTerrain.put("AUREN", 3);
        factionToTerrain.put("WITCHES", 3);
        factionToTerrain.put("ALCHEMISTS",1);
        factionToTerrain.put("DARKLINGS", 1);
        factionToTerrain.put("HALFLINGS", 0);
        factionToTerrain.put("CULTISTS", 0);
        factionToTerrain.put("ENGINEERS", 4);
        factionToTerrain.put("DWARVES", 4);
        factionToTerrain.put("SWARMLINGS", 2);
        factionToTerrain.put("MERMAIDS", 2);
        factionToTerrain.put("CHAOS_MAGICIANS", 5);
        factionToTerrain.put("GIANTS", 5);
        factionToTerrain.put("FAKIRS", 6);
        factionToTerrain.put("NOMADS", 6);
    }
    // UI Properties
    ImageView goBackImg;
    Button defaultMapButton;
    Button randomMapButton;
    // Logic properties (gameState)
    Integer isDefaultMap = 1;
    Integer factionColorId = -1;
    String factionName = "";
    Integer factionId = -1;

    ImageView[] factionImageViews;



    // Constructor
    public GameSetupController(Stage stage) throws IOException {
        // Faction Image setup
        factionImageViews = new ImageView[14];
        super.root = null;
        try {
            super.root = loadFXML("gameSetup");
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.scene = new Scene(super.root);
        initController(stage);
    }


    @Override
    public void initController(Stage stage) throws IOException {
        // Retrieve Stylesheets for the scene
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

        // Add listeners of the faction images
        for(int i = 0; i  < 14; i++){
            factionImageViews[i] = (ImageView) super.scene.lookup("#" + factionNames[i]);
            // remember the selected faction
            Integer finalI = i;
            factionImageViews[i].setOnMouseClicked(event -> {
                System.out.println("select: " + factionNames[finalI]);
                // Note: Used the index of factionNames as Id
                factionId = finalI;
                factionName = factionNames[finalI];
                factionColorId = factionToTerrain.get(factionName);
                setInitParameters();
            });
        }

        // initialize the game parameters

    }

    /**
     * Setter for game state initialization
     * isDefaultMap: default map (Integer: 1), random map (Integer: 0)
     * factionId: index factionNames array
     * factionColorId: factionToTerrainHashmap to find terrain colors
     */
    public void setInitParameters(){
        gameState.put("isDefaultMap", isDefaultMap);
        gameState.put("factionId", factionId);
        gameState.put("factionColorId", factionColorId);
    }

    /**
     * Getter for game initialization parameters
     *
     */
    public static HashMap<String, Integer> getInitParameters(){
        return gameState;
    }

}

