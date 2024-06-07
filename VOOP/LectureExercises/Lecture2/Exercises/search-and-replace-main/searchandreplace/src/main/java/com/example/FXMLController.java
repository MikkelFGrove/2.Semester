package com.example;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class FXMLController implements Initializable {
    @FXML
    private TextArea outputText;

    @FXML
    private Button replaceButton;

    @FXML
    private TextField replaceText;

    @FXML
    private TextField searchText;

    @FXML
    private Button openFileButton;

    @FXML
    private Button saveButton;

    private FileChooser chooser = new FileChooser();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        chooser.setInitialDirectory(new File("."));
    }

    @FXML
    void replace(ActionEvent event) {
        String outText = outputText.getText().replaceAll(searchText.getText(), replaceText.getText());
        outputText.setText(outText);
    }

    @FXML
    void openFile(ActionEvent event) throws IOException {
        File inFile = chooser.showOpenDialog(null);
        outputText.setText(Files.readString(inFile.toPath()));
    }

    @FXML
    void saveFile(ActionEvent event) throws IOException {



        File outFile = chooser.showSaveDialog(null);
        FileWriter fileWriter = new FileWriter(outFile);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(outputText.getText());
        printWriter.close();
    }
}
