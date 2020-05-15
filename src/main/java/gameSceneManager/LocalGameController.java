package gameSceneManager;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static gameSceneManager.App.loadFXML;
import static gameSceneManager.BoardGenerator.terrainColorMap;


/**
 * Controls the local game play UI of the application
 * @author Zeynep Cankara
 * @version 12.05.2020
 */

public class LocalGameController extends SceneController {
    // Properties: UI Related
    ImageView goBackImg;



    static HashMap<Integer, Polygon> dwellingMap = new HashMap<Integer, Polygon>();
    // Define the dwelling polygons
    //Polygon polygon = new Polygon();



    // Constructor
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


        //scene = BoardGenerator.generateDefaultTerrainMap(scene);
        HashMap<String, Boolean> gameState = GameSetupController.getInitParameters();
        if( gameState.get("isDefaultMap")){
            scene = BoardGenerator.generateDefaultTerrainMap(scene);
        } else {
            scene = BoardGenerator.generateRandomTerrainMap(scene, (int) (Math.random() * 6 + 1));
        }

        //popup for action round
        displayActionRoundPopup();
        // buttonmain.setOnAction(e -> displayActionPopup());


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

    // METHODS for Terrain Manipulation

    /**
     * Transforms terrain space with specified terrain type when pressed.
     * @param polygonId reference to the UI hexagon
     * @param terrainId, terrain type
     */
    public void changeTerrainOnMouseClick(int polygonId, int terrainId) {
        Polygon hexagon = (Polygon) scene.lookup("#" + polygonId);
        hexagon.setOnMouseClicked(event -> {
            hexagon.setFill(terrainColorMap.get(terrainId));
        });
    }

    /**
     * Place dwelling on board
     * @param polygonId reference to the UI hexagon
     */
    public void buildDwellingOnMouseClick(int polygonId) {
        Rectangle rectangle = new Rectangle(200, 200);
        rectangle.setFill(Color.AZURE);

        Polygon hexagon = (Polygon) scene.lookup("#" + polygonId);
        System.out.println("Hexagon selected...");
        hexagon.setOnMouseClicked(event -> {
            System.out.println("Hexagon clicked...");
            rectangle.setLayoutX(hexagon.getLayoutX());
            rectangle.setLayoutY(hexagon.getLayoutY());

            rectangle.setVisible(true);
        });
    }

    /**
     * Action Round Popup Stage initializer
     * @return chosenAction chosen action from the popup window
     */
    public void  displayActionRoundPopup() throws IOException {
        // Properties
        Button transformAndBuildActionBtn;
        Button advanceShippingActionBtn;
        Button lowerExchangeRateSpadesActionBtn;
        Button upgradeStructureActionBtn;
        Button sendPriestToCultActionBtn;
        Button takePowerActionBtn;
        Button takeSpecialActionBtn;
        Button passActionBtn;


        Stage actionRoundStage = new Stage();
        actionRoundStage.initModality(Modality.APPLICATION_MODAL);
        actionRoundStage.setTitle("Action Round Popup");
        actionRoundStage.setHeight(500);
        actionRoundStage.setWidth(400);

        //load the css file
        Parent actionRoundPopupFXML  = loadFXML("actionRoundPopup");
        Scene actionRoundScene = new Scene(actionRoundPopupFXML);

        actionRoundScene.getStylesheets().clear();
        actionRoundScene.getStylesheets().add(getClass().getResource("actionRoundPopup.css").toExternalForm());
        actionRoundStage.setScene(actionRoundScene);
        actionRoundStage.show();

        // connect the button logic
        transformAndBuildActionBtn = (Button) actionRoundScene.lookup("#action1Btn");
        advanceShippingActionBtn = (Button) actionRoundScene.lookup("#action2Btn");
        lowerExchangeRateSpadesActionBtn = (Button) actionRoundScene.lookup("#action3Btn");
        upgradeStructureActionBtn = (Button) actionRoundScene.lookup("#action4Btn");
        sendPriestToCultActionBtn = (Button) actionRoundScene.lookup("#action5Btn");
        takePowerActionBtn = (Button) actionRoundScene.lookup("#action6Btn");
        takeSpecialActionBtn = (Button) actionRoundScene.lookup("#action7Btn");
        passActionBtn = (Button) actionRoundScene.lookup("#action8Btn");

        // TODO: Connect buttons to the action logic
        transformAndBuildActionBtn.setOnMouseClicked(event -> {
            System.out.println("transformAndBuildAction...");
        });
        advanceShippingActionBtn.setOnMouseClicked(event -> {
            System.out.println("advanceShippingAction...");
        });
        lowerExchangeRateSpadesActionBtn.setOnMouseClicked(event -> {
            System.out.println("lowerExchangeRateSpadesAction...");
        });
        upgradeStructureActionBtn.setOnMouseClicked(event -> {
            System.out.println("upgradeStructureAction...");
        });
        sendPriestToCultActionBtn.setOnMouseClicked(event -> {
            System.out.println("sendPriestToCultActionAction...");
        });
        takePowerActionBtn.setOnMouseClicked(event -> {
            System.out.println("takePowerAction...");
        });
        takeSpecialActionBtn.setOnMouseClicked(event -> {
            System.out.println("takeSpecialAction...");
        });
        passActionBtn.setOnMouseClicked(event -> {
            System.out.println("passAction...");
        });
    }


    /**
     * Random popup example
     */
    public void displayActionRoundPopup_demo() {
        Stage actionRoundStage = new Stage();
        actionRoundStage.initModality(Modality.APPLICATION_MODAL);
        actionRoundStage.setTitle("Action Round Popup");
        actionRoundStage.setHeight(500);
        actionRoundStage.setWidth(400);

        //load the css file
        String actionRoundPopupCss = getClass().getResource("actionRoundPopup.css").toExternalForm();


        final Popup popup = new Popup();
        popup.setX(300);
        popup.setY(200);

        // this add a circle on the screen
        popup.getContent().addAll(new Circle(25, 25, 50, Color.AQUAMARINE));

        Button show = new Button("Show");
        show.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                popup.show(actionRoundStage);
            }
        });

        Button hide = new Button("Hide");
        hide.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                popup.hide();
            }
        });

        HBox layout = new HBox(10);
        layout.getChildren().addAll(show, hide);
        actionRoundStage.setScene(new Scene(layout));
        actionRoundStage.show();
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
