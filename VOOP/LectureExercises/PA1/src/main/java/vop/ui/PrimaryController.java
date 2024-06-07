package vop.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import vop.Fairytale;
import vop.NotAFairytaleException;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable{



    @FXML
    public ToggleGroup fairytaleToggleGroup = new ToggleGroup();
    public TextArea fairytaleContent;
    public Label WordsLabel;
    public Label LongestWordLabel;

    private Fairytale fairytale = null;

    public void changeFairytaleThree() throws FileNotFoundException, NotAFairytaleException {
        try {
            fairytale = new Fairytale(new File("fairytales/goldilocks-and-the-three-bears.fairytale"), false);
        } catch (Exception e){
            System.out.println("Something went wrong");
        }

        fairytaleContent.setText(fairytale.getContents());
        fairytale.analyze();
        WordsLabel.setText("Words: " + fairytale.getWords());
        LongestWordLabel.setText("Longest word: " + fairytale.getLongestWordLength());
    }

    public void changeFairytalePrincess() throws FileNotFoundException, NotAFairytaleException {

        try {
            fairytale = new Fairytale(new File("fairytales/the-princess-and-the-pea.fairytale"), false);
        } catch (Exception e){
            System.out.println("Something went wrong");
        }

        fairytaleContent.setText(fairytale.getContents());
        fairytale.analyze();
        WordsLabel.setText("Words: " + fairytale.getWords());
        LongestWordLabel.setText("Longest word: " + fairytale.getLongestWordLength());
    }

    public void exportResults(ActionEvent event) {
    }

    @FXML
    public RadioButton PrincessButton;

    @FXML
    public RadioButton ThreeBears;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
