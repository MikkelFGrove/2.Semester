import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MountainSet {
    Set<Mountain> tree;

    public MountainSet(){
        tree = new TreeSet<>();
    }

    public Set<Mountain> getSet() {
        return tree;
    }

    public static void main(String[] args) {
        MountainSet mSet = new MountainSet();
        Scanner stream = null;
        try {
            stream = new Scanner (new File("FrenchMountains.csv"));
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file :(");
            System.exit(0);
        }
        while (stream.hasNextLine())
        {
            String[] ary = stream.nextLine().split(";");
            mSet.tree.add(new Mountain(ary[0],ary[1], ary[2], ary[3], ary[4], ary[5]));
        }
        System.out.println(mSet.tree.toString());

        System.out.println("Sorted by range:");
        System.out.println(mSet.sortByRange(new MountainRangeComparator()));
    }

    public Set<Mountain> sortByRange(Comparator comp){
        Set<Mountain> rangeTree = new TreeSet<>(comp);
        rangeTree.addAll(tree);
        return rangeTree;
    }


}
