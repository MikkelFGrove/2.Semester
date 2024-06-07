package com.example;


import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class FXMLController implements Initializable {

    @FXML
    private Button replaceAllButton;


    @FXML
    private Button openFileButton;

    @FXML
    private Button saveAsButton;

    @FXML
    private TextField replaceTextField;

    @FXML
    private TextField searchTextField;

    @FXML
    private TextArea textArea;

    private FileChooser fileChooser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
    }
    @FXML
    private void replaceButtonHandler(ActionEvent event) {
        String searchText = searchTextField.getText();
        String replaceText = replaceTextField.getText();
        String originalText = textArea.getText();
        String newText = originalText.replaceAll(searchText, replaceText);
        textArea.setText(newText);
    }

    @FXML
    private void saveAsButtonHandler(ActionEvent event){
        File outFile = fileChooser.showSaveDialog(null);
        try (FileWriter fw = new FileWriter(outFile)) {
            fw.write(textArea.getText());
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    @FXML
    private void openFileButtonHandler(ActionEvent event){
        File inFile = fileChooser.showOpenDialog(null);
        Scanner inputStream = null;
        String tempString = "";
        try {
            inputStream = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            System.out.println("Scanner could not find file");
            System.exit(0);
        }
        while (inputStream.hasNextLine()){
            tempString += inputStream.nextLine() + "\n";
        }

        textArea.setText(tempString);
    }


}
