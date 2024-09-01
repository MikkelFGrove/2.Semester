package com.example.vopexam2023;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import tourism_info.ReadCSV;
import tourism_info.Tourism;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

public class PrimaryController {

    @FXML
    private ListView lsCountries;
    @FXML
    private TextArea txtTourInfo;

    private File selectedFile;

    private ReadCSV readCSV;


    public void showCountries(ActionEvent actionEvent){

        selectedFile = new File("tourism-receipts.csv");

        readCSV = new ReadCSV(selectedFile);

        readCSV.readFile();

        lsCountries.setItems(FXCollections.observableArrayList(readCSV.getMap().keySet()));
    }



    public void showTourInfo(MouseEvent actionEvent){

        txtTourInfo.clear();

        String country = lsCountries.getSelectionModel().getSelectedItem().toString();

        Set<Tourism> items = new TreeSet<>();
        items = readCSV.getMap().get(country);

        for (Tourism i : items) {
            txtTourInfo.appendText(i.toString() + "\n");
        }
    }

    public void clearAction(ActionEvent actionEvent) {

        txtTourInfo.clear();
        lsCountries.scrollTo(0);
        lsCountries.getFocusModel().focus(0);
        lsCountries.getSelectionModel().select(0);
    }

}