package vop;

import java.util.Comparator;

public class WordComparator implements Comparator<Fairytale>{

    @Override
    public int compare(Fairytale o1, Fairytale o2) {
        if (o1.getWords() > o2.getWords()){
            return 1;
        } else if (o1.getWords() < o2.getWords()) {
            return -1;
        } else{
            return 0;
        }
    }
}

