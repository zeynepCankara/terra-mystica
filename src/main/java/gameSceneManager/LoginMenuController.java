package gameSceneManager;

import javafx.animation.FadeTransition;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.HashMap;

import static gameSceneManager.App.loadFXML;

/**
 * Controls the login menu of the application
 * @author Zeynep Cankara
 * @version 09.05.2020
 */

public class LoginMenuController extends SceneController {
    static HashMap<String, String> loginGameState;
    // Properties
    ImageView goBackImg;
    Button submitBtn;
    TextField usernameField;
    PasswordField passwordField;
    Label statusLabel;


    public LoginMenuController(Stage stage) throws IOException {

        super.root = null;
        try {
            super.root = loadFXML("loginMenu");
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
        super.scene.getStylesheets().add(getClass().getResource("loginMenu.css").toExternalForm());
        stage.setScene(super.scene);
        stage.show();

        // Return to the main window
        goBackImg = (ImageView) super.scene.lookup("#goBackImg");
        submitBtn = (Button) super.scene.lookup("#submitBtn");
        usernameField = (TextField) super.scene.lookup("#usernameField");
        passwordField = (PasswordField) super.scene.lookup("#passwordField");
        statusLabel = (Label) super.scene.lookup("#statusLabel");


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
        submitBtn.setOnMouseClicked(event -> {
            String enteredName = usernameField.getText();
            String enteredPassword = passwordField.getText();
            // TODO: Implement GameStateWrapper.validateUsername
            //if(GameStateWrapper.validateUsername(enteredName, enteredPassword));
            FadeTransition fadeAnimation = new FadeTransition(Duration.seconds(1), finalRoot);
            fadeAnimation.setOnFinished(event1 ->
            {
                try {
                    finalRoot.setVisible(false);
                    App.setController(3, stage);
                } catch (IOException e) {
                    System.out.println(e);
                }
            });
            fadeAnimation.play();
        });
    }
}
