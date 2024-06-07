package dk.sdu.pa2.task2;

import java.util.Comparator;

public class HealthComparator implements Comparator<Pokemon> {
    @Override
    public int compare(Pokemon p1, Pokemon p2) {
        if (p1.getHealth() == p2.getHealth()){
            return p1.getName().compareTo(p2.getName());
        } else if (p1.getHealth() > p2.getHealth()) {
            return -1;
        } else if (p1.getHealth() < p2.getHealth()){
            return 1;
        }
        return -1;
    }
}
