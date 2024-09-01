package reading.Exercise1;


import java.io.File;
import java.util.*;

public class ReadCSV {
    private File file;
    private Map<String, Set<Flower>> map;

    public ReadCSV(String fileName){
        this.file = new File(fileName);
        map=new TreeMap<>();
    }


    public void readFile() {
        throw new UnsupportedOperationException("Implement Method");
    }

    public Map<String, Set<Flower>> getMap() {
        return map;
    }

    public static void main(String[] args) {
        ReadCSV readCSV = new ReadCSV("csv\\flowerData.csv");
        readCSV.readFile();
        Map<String, Set<Flower>> mapFlower= readCSV.getMap();
        System.out.println(mapFlower);
    }
}
