package reading.Exercise1_Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadCSV {
    private File file;
    private Map<String, Set<Flower>> map;

    public ReadCSV(String fileName){
        this.file = new File(fileName);
        map=new TreeMap<>();
    }

    public void readFile() {

        int i = 0;
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if(i>0) {
                    String[] file_info = line.split(",");

                    Flower f = new Flower(Integer.parseInt(file_info[0]),Double.parseDouble(file_info[1]),Double.parseDouble(file_info[2]), Double.parseDouble(file_info[3]),Double.parseDouble(file_info[4]), file_info[5]);
                    if(!(map.containsKey(f.getSpecies())))
                    {
                        map.put(f.getSpecies(),new HashSet<>());
                    }
                    map.get(f.getSpecies()).add(f);
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);

        }
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
