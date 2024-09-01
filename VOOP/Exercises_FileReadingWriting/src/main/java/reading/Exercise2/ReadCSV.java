package reading.Exercise2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ReadCSV {
    private File file;
    private Set<Store> set;

    public ReadCSV(String fileName){
        this.file = new File(fileName);
        set=new LinkedHashSet<>();
    }

    public void readFile() {

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                getSet().add(new Store());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }

    public Set<Store> getSet() {
        return set;
    }

    public static void main(String[] args) {
        ReadCSV readCSV = new ReadCSV("csv\\storeData.csv");
        readCSV.readFile();
        Set<Store> setStore= readCSV.getSet();
        System.out.println(setStore);
    }
}
