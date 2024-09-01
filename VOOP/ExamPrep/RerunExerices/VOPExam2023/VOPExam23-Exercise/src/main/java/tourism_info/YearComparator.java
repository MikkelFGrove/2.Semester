package tourism_info;

import java.util.Comparator;

public class YearComparator implements Comparator<Tourism> {
    @Override
    public int compare(Tourism o1, Tourism o2) {
        if (o1.getYear() > o2.getYear()){
            return 1;
        } else if (o1.getYear() < o2.getYear()) {
            return -1;
        } else if (o1.getValue() > o2.getValue()) {
            return 1;
        } else if (o1.getValue() < o2.getValue()) {
            return -1;
        }
        return 0;
    }
}
