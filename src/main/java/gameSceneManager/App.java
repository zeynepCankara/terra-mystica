package gameSceneManager;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Application logic for starting the Desktop App
 * @author Zeynep Cankara
 * @version 06.05.2020
 */
public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    // will belong to GameEngine Singleton
    private static SceneController controller;

    @Override
    public void init() throws Exception {
        // Useful when loading assets
        System.out.println("Start Application...");
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Terra Mystica Desktop");
        stage.setWidth(1536);
        stage.setHeight(824);

        // controller = new MainMenuController(stage);
        //LocalGameController localGameController = new LocalGameController(stage);
        controller = new MainMenuController(stage);
    }


    static void setRoot(String fxml, Scene scene) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static void setController(int controllerNo, Stage stage) throws IOException {
        switch (controllerNo)
        {
            // 0 is the code for Main Menu Controller.
            case 0:
                controller = new MainMenuController(stage);
                break;
            // 1 is the code for Help Controller.
            case 1:
                controller = new HelpMenuController(stage);
                break;
            // 2 is the code for Player Selection Controller.
            case 2:
                controller = new LocalGameController(stage);
                break;
        }
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }



    @Override
    public void stop() throws Exception{
        // When Application stops running
        System.out.println("Stop Application...");
    }

}
