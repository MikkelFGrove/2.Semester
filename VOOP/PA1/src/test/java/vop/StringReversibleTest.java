package vop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringReversibleTest {
    @Test
    public void test_string_can_be_reversed()
    {
        assertEquals(Fairytale.reverseString(".tset a si sihT"), "This is a test.");
    }

    @Test
    public void test_reversed_string_is_trimmed()
    {
        assertEquals(Fairytale.reverseString("  .tset a si sihT  "), "This is a test.");
    }
}
