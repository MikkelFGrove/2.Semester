package vop;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrimaryController implements Initializable, CallBackInterface {

    @FXML
    private TextArea textArea;
    @FXML
    private Button startButton;
    @FXML
    private Button stopButton;
    @FXML
    private ImageView die1view;
    @FXML
    private ImageView die2view;

    private FacadeWithCallback facade;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        startButton.setDisable(false);
        stopButton.setDisable(true);
    }

    @FXML
    private void buttonAction(ActionEvent event) {
        if (event.getSource() == startButton) {
            // Initialize the facade and start it.
            // handle access to the buttons
            try {
                facade = new FacadeWithCallback(this);
            } catch (URISyntaxException e){
                System.out.println("Cant instance facade in PrimaryController");
            }
            facade.start();
            stopButton.setDisable(false);
            startButton.setDisable(true);
        } else {
            // Stop the facade
            facade.interrupt();
            startButton.setDisable(false);
            stopButton.setDisable(true);
        }
    }

    @Override
    public void updateMessage(String message) {
        // This is the implementation of the CallBack. Remember it is called from a Thread!
        // append the message to the textArea
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                textArea.appendText("\n" + message);
                if (!facade.isAlive()){
                    stopButton.fire();
                }
            }
        });
    }

    @Override
    public void updateImages(File i1, File i2) {
        // Changes the pictures on the imageViews
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                die1view.setImage(new Image(i1.toURI().toString()));
                die2view.setImage(new Image(i2.toURI().toString()));
            }
        });
    }


}