import java.util.Comparator;

public class MountainRangeComparator implements Comparator<Mountain> {
    public int compare(Mountain mountain1, Mountain mountain2){
        if(mountain1.getMountainRange().compareTo(mountain2.getMountainRange()) > 0){
            return 1;
        } else if (mountain1.getMountainRange().compareTo(mountain2.getMountainRange()) < 0){
            return -1;
        } else {
            return mountain1.compareTo(mountain2);
        }
    }
}
