package org.example.danishisland;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DanishIslandFileReader {

    private File inFile;
    private List<DanishIsland> islandList;

    public DanishIslandFileReader(String fName) {
        inFile = new File(fName);
    }

    private void readFile() {
        islandList = new ArrayList<DanishIsland>();
        Scanner scan = null;
        String line;
        String[] tokens;

        String name = "";
        double circ;
        double area;
        int addr;
        int adkm;

        // OPGAVEN:
        // Laes filen en linje ad gangen. Split linjen paa mellemrums tegnet.
        // Konverter de enkelte vaerdier til typerne der skal bruges i DanishIsland.
        // Opret et objekt for hver linje og tilfoej det til listen.
        // Vaer omhyggelig med at fange exceptions og faa lukke Scanner og fil

    }

    public List<?> getList(){
        return islandList;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(new File(".").getAbsolutePath());
        DanishIslandFileReader fr = new DanishIslandFileReader("Islands punktum.txt");
        //DanishIslandFileReader fr = new DanishIslandFileReader("Islands komma.txt");
        fr.readFile();


        System.out.println("Result:\n" + fr.getList());

    }


}

