import java.util.Comparator;

public class MountainRangeComparator implements Comparator<Mountain> {

    @Override
    public int compare(Mountain o1, Mountain o2) {
        if (o1.range.compareTo(o2.getRange()) != 0){
            return o1.range.compareTo(o2.getRange());
        } else return o1.compareTo(o2);
    }
}
