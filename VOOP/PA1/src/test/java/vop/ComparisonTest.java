package vop;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ComparisonTest {

    @Test
    public void test_fairytale_implements_comparator_interface() {
        Fairytale fairytale = new Fairytale("This is also a test.", false);
        assertTrue(fairytale instanceof Comparable, "Fairytale instance is not comparable!");
    }

    @Test
    public void test_fairytales_are_compared_against_characters() {
        Fairytale fairytaleOne = new Fairytale("This fairytale has a long word, princesses!", false);
        fairytaleOne.analyze();
        Fairytale fairytaleTwo = new Fairytale("Can you imagine the length of this word, unimaginatively!", false);
        fairytaleTwo.analyze();
        Fairytale fairytaleThree = new Fairytale("This is an incredible long word, adventurous!", false);
        fairytaleThree.analyze();

        ArrayList<Fairytale> fairytales = new ArrayList<>();
        fairytales.add(fairytaleOne);
        fairytales.add(fairytaleTwo);
        fairytales.add(fairytaleThree);
        Collections.sort(fairytales);
        assertEquals(fairytaleTwo, fairytales.get(0));
        assertEquals(fairytaleThree, fairytales.get(1));
        assertEquals(fairytaleOne, fairytales.get(2));
    }

    @Test
    public void test_fairytales_are_compared_against_words_using_comparator() {
        Fairytale firstFairytale = new Fairytale("This fairytale contains a few words!", false);
        firstFairytale.analyze();
        Fairytale secondFairytale = new Fairytale("This fairytale contains at least six words!", false);
        secondFairytale.analyze();
        Fairytale thirdFairytale = new Fairytale("Supercalifragilisticexpialidocious fairytale", false);
        thirdFairytale.analyze();

        List<Fairytale> fairytales = new ArrayList<>();
        fairytales.add(firstFairytale);
        fairytales.add(secondFairytale);
        fairytales.add(thirdFairytale);

        assertTrue(new WordComparator() instanceof Comparator, "WordComparator class does not implement the Comparator interface");

        fairytales.sort((Comparator<? super Fairytale>) new WordComparator());
        assertEquals(thirdFairytale, fairytales.get(0));
        assertEquals(firstFairytale, fairytales.get(1));
        assertEquals(secondFairytale, fairytales.get(2));
    }
}
