package org.example.camelwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CamelWriter {

    private File inFile;


    public CamelWriter(String fName) {
        //Initialiser inFile med fName
        inFile = null;
        try {
            inFile = new File(fName);
        }
        catch (NullPointerException e){
            System.out.println("Error opening file "+fName);
            System.exit(0);
        }
    }

    public void readLines() {
        // Benyt en Scanner til at læse inFile én linje ad gangen
        // Kald convert2camel med hver linje.
        Scanner myScanner = null;
        try {
            myScanner = new Scanner(inFile);
        }
        catch (FileNotFoundException e){
            System.out.println("Error reading file "+inFile);
            System.exit(0);
        }
        while (myScanner.hasNextLine()){
            String line = myScanner.nextLine();
            convert2camel(line);
        }
    }

    private void convert2camel(String line) {
        // Split line til et String[] af de enkelte ord i linjen
        // Konverter 1. ord til små og resten til stort begyndelsesbogstav
        // Sammensæt ordene til ét langt ord og udskriv.



        String[] arrayString = line.split(" ");
        String tempString;
        for (int i = 0; i < arrayString.length; i++){
            tempString = arrayString[i];
            
        }

        /*
        for (int i = 0; i < arrayString.length; i++) {
            if (i == 0 && arrayString[i] != null){
                System.out.println(arrayString[i]);
                StringBuilder tempString = new StringBuilder(arrayString[i]);
                tempString.setCharAt(0,Character.toLowerCase(arrayString[i].charAt(0)));
                arrayString[i] = tempString.toString();
                System.out.println(arrayString[i]);
            } else if (arrayString[i] != null){
                arrayString[i].toLowerCase();
                System.out.println(arrayString[i]);
            }
        }*/
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CamelWriter cw = new CamelWriter("DryLips.txt");
        cw.readLines();
    }

}
