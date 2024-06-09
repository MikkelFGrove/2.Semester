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
            try {
                facade = new FacadeWithCallback(this);
                facade.start();
                stopButton.setDisable(false);
                startButton.setDisable(true);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        } else {
            facade.interrupt();
            stopButton.setDisable(true);
            startButton.setDisable(false);
        }
    }

    @Override
    public void updateMessage(String message) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                textArea.setText(textArea.getText() + message + "\n");
            }
        });

        if (!facade.isAlive()){
            stopButton.fire();
        }
    }

    @Override
    public void updateImages(File i1, File i2) {

       Platform.runLater(new Runnable() {
            @Override
            public void run() {
                die1view.setImage(new Image(i1.toURI().toString()));
                die2view.setImage(new Image(i2.toURI().toString()));
            }
        });



    }


}