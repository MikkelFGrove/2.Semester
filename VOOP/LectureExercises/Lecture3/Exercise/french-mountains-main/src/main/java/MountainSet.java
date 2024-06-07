import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MountainSet {
    Set<Mountain> tree;

    MountainSet(){
        tree = new TreeSet<Mountain>();
    }

    public Set getMountainSet(){
        return tree;
    }

    public Set<Mountain> sortByRange(Comparator comp){
        Set<Mountain> rangeTree = new TreeSet<>(comp);
        rangeTree.addAll(tree);
        return rangeTree;
    }

    public static void main(String[] args) {
        MountainSet mSet = new MountainSet();
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new File("FrenchMountains.csv"));
        }catch (FileNotFoundException e){
            System.out.println("Could not find file");
        }

        String line;

        while (inputStream.hasNextLine()){
            line = inputStream.nextLine();
            String[] mountainValues = line.split(";");
            mSet.tree.add(new Mountain(mountainValues[0], mountainValues[1], mountainValues[2], mountainValues[3], mountainValues[4], mountainValues[5]));
        }
        inputStream.close();

        System.out.print(mSet.tree.toString());

        System.out.println("Sorted by range:");
        System.out.println(mSet.sortByRange(new MountainRangeComparator()));


    }
}
