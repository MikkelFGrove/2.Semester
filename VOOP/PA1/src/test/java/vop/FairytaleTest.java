package vop;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class FairytaleTest {

    @Test
    public void test_fairytale_can_from_a_string() {
        Fairytale fairytale = new Fairytale("This is a test.", false);
        assertEquals("This is a test.", fairytale.getContents());
    }

    @Test
    public void test_fairytale_can_load_a_reversed_string() {
        Fairytale reversedFairytale = new Fairytale(".tset a si sihT", true);
        assertEquals("This is a test.", reversedFairytale.getContents());
    }

    @Test
    public void test_fairytale_can_load_a_fairytale_file() throws IOException {
        File testFile = new File("fairytales/tests/test.fairytale");
        Fairytale fairytale = new Fairytale(testFile, false);

        assertEquals(removeAllWhitespace("""
                Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                                
                Phasellus nec est dictum, porta nibh ac, gravida neque.
                Morbi sed leo imperdiet, lacinia metus at, eleifend massa. Cras dictum varius consequat.
                Pellentesque lacinia dolor sit amet varius porttitor.
                Suspendisse vel ante vel urna consequat congue."""), removeAllWhitespace(fairytale.getContents().trim()));
    }

    @Test
    public void test_fairytale_can_load_a_reversed_fairytale_file() throws IOException {
        File testFile = new File("fairytales/tests/reversed-test.fairytale");
        Fairytale fairytale = new Fairytale(testFile, true);
        String testText = """
                Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                                
                Phasellus nec est dictum, porta nibh ac, gravida neque.
                Morbi sed leo imperdiet, lacinia metus at, eleifend massa. Cras dictum varius consequat.
                Pellentesque lacinia dolor sit amet varius porttitor.
                Suspendisse vel ante vel urna consequat congue.""";
        assertEquals(removeAllWhitespace(testText), removeAllWhitespace(fairytale.getContents().trim()));
    }

    private String removeAllWhitespace(String input)
    {
        return input.replaceAll("[\n\r\s]", "");
    }

    @Test
    public void test_fairytale_throws_an_exception_if_incorrect_file_is_loaded() {
        File testFile = new File("fairytales/tests/not-a-fairytale.txt");
        assertThrows(NotAFairytaleException.class, () -> new Fairytale(testFile, false));
    }


    @Test
    public void test_verifies_that_getter_exists_for_longest_word_count() {
        Fairytale fairytale = new Fairytale("This is a test.", false);
        Method method = null;
        try {
            method = fairytale.getClass().getMethod("getLongestWordLength");
        } catch (NoSuchMethodException ignored) {

        }
        assertNotNull(method, "getLongestWordLength() getter method not found on class Fairytale!");
    }

    @Test
    public void test_fairytale_computes_correct_word_length() throws InvocationTargetException, IllegalAccessException {
        Fairytale fairytale = new Fairytale("This is a longer test. ", false);
        Method method = null;
        try {
            method = fairytale.getClass().getMethod("getLongestWordLength");
        } catch (NoSuchMethodException ignored) {

        }
        assertNotNull(method, "getLongestWordLength() getter method not found on class Fairytale!");
        fairytale.analyze();
        assertEquals(6, method.invoke(fairytale), "Incorrect longest word length found!");
    }

    @Test
    public void test_verifies_that_getter_exists_for_word_count() throws InvocationTargetException, IllegalAccessException {
        Fairytale fairytale = new Fairytale("This is a test.", false);
        Method method = null;
        try {
            method = fairytale.getClass().getMethod("getWords");
        } catch (NoSuchMethodException ignored) {

        }
        assertNotNull(method, "getWords() getter method not found on class Fairytale!");
        assertEquals(0, method.invoke(fairytale));
    }

    @Test
    public void test_fairytale_has_correct_word_count() throws InvocationTargetException, IllegalAccessException {
        Fairytale fairytale = new Fairytale("This is a test.", false);
        Method method = null;
        try {
            method = fairytale.getClass().getMethod("getWords");
        } catch (NoSuchMethodException ignored) {

        }
        assertNotNull(method, "getWords() getter method not found on class Fairytale!");
        fairytale.analyze();
        assertEquals(4, method.invoke(fairytale), "Incorrect number of words found!");
    }
}