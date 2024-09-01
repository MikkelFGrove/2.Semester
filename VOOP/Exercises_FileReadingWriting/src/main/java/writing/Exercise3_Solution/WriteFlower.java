package writing.Exercise3_Solution;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

import java.util.TreeMap;

public class WriteFlower {
    private String outFile;

    public WriteFlower(String outFile) {
        this.outFile=outFile;
    }

    public void writeFile(Map<String, Flower> m) {

        try(PrintWriter p = new PrintWriter(outFile))
        {
            for (Map.Entry<String, Flower> entry : m.entrySet()) {
                p.write(entry.getKey() + ": " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
       Flower f1=new Flower(33,5,20,4,10,"Iris-setosa");
       Flower f2=new Flower(129,6,40,2,80, "Iris-virginica");
       Flower f3=new Flower(66,6.7,3.1,4.4,1.4,"Iris-versicolor");

       Map<String, Flower> m=new TreeMap<>();
       m.put(f1.getSpecies(), f1);
       m.put(f2.getSpecies(), f2);
       m.put(f3.getSpecies(), f3);
       WriteFlower fileIO = new WriteFlower ("flowerInfo.txt");
       fileIO.writeFile(m);

    }
}
