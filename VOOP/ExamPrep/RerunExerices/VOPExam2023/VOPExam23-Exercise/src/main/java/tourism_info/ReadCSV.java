package tourism_info;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadCSV {

    private File file;
    private Map<String, Set<Tourism>> map;

    public ReadCSV(String fileName){
        this.map = new TreeMap(Collections.reverseOrder());
        this.file = new File(fileName);
    }

    public ReadCSV(File file) {
        this.map = new TreeMap();
        this.file = file;
    }

    public Map<String, Set<Tourism>> getMap() {
        return map;
    }

    public void readFile() {
        try {
            Scanner sc = new Scanner(file);
            String line = sc.nextLine();
            while (sc.hasNextLine()){
                String[] ary = sc.nextLine().split(",");
                Tourism country = new Tourism(ary[0], ary[1], Integer.parseInt(ary[2]), Double.parseDouble(ary[3]));
                if (!this.getMap().containsKey(country.getName())){
                    Set<Tourism> tourismSet = new TreeSet<>();
                    tourismSet.add(country);
                    this.getMap().put(country.getName(),tourismSet);
                } else {
                    this.getMap().get(country.getName()).add(country);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found:" + e);
        }
    }


    public static void main(String[] args) {
        ReadCSV readCSV = new ReadCSV("tourism-receipts.csv");
        readCSV.readFile();
        System.out.println(readCSV.getMap());
    }

}
