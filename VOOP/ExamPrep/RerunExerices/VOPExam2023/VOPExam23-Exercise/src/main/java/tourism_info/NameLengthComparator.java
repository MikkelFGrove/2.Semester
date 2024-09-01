package tourism_info;

import java.util.Comparator;

public class NameLengthComparator implements Comparator<Tourism> {
    @Override
    public int compare(Tourism o1, Tourism o2) {
        if (o1.getName().length() > o2.getName().length()){
            return 1;
        } else if (o1.getName().length() < o2.getName().length()) {
            return -1;
        } else if (o1.getValue() > o2.getValue()) {
            return 1;
        } else if (o1.getValue() < o2.getValue()) {
            return -1;
        }
        return 0;
    }
}
