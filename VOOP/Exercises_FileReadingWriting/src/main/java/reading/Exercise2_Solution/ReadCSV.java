package reading.Exercise2_Solution;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadCSV {
    private File file;
    private Set<Store> set;

    public ReadCSV(String fileName){
        this.file = new File(fileName);
        set=new LinkedHashSet<>();
    }

    public void readFile() {

        int i = 0;
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if(i>0) {
                    String[] file_info = line.split(",");
                    Store s = new Store(Integer.parseInt(file_info[0]),Double.parseDouble(file_info[1]), file_info[2],file_info[3], file_info[4],Integer.parseInt(file_info[5]), Long.parseLong(file_info[6]));
                    if(s.getProperty().equals("\"Rental\""))
                    {
                        set.add(s);
                    }
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);

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
