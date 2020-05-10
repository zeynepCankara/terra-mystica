package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Application logic for starting the Desktop App
 * @author Zeynep Cankara
 * @version 06.05.2020
 */
public class App extends Application {

    private static Scene scene;


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

        scene = new Scene(loadFXML("mainMenu"));
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource("mainMenu.css").toExternalForm());
        stage.setScene(scene);
        stage.show();


    }


    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }


    /*
    public static void main(String[] args) {
        launch();
    }
     */

    @Override
    public void stop() throws Exception{
        // When Application stops running
        System.out.println("Stop Application...");
    }

}