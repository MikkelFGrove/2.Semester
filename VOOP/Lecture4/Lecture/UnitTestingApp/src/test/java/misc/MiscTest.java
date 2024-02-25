package misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MiscTest {

    String nullString = null;
    String notNullString = "howtodoinjava.com";
    String originalObject = "howtodoinjava.com";
    String cloneObject = originalObject;
    String otherObject = "example.com";
    boolean trueBool = true;
    boolean falseBool = false;
    Boolean result=true;
    String message="Test execution result";


    @Test
    public void testingCondition()
    {
        int result = randomInteger(); ;
        if(result >Integer.MAX_VALUE)
        {
            fail("Result cannot be >= integer max value");
        }
        assertNotNull(Integer.valueOf(result));
    }

    private int randomInteger() {
        return (int) Math.random()*Integer.MAX_VALUE;
    }


    @Test
    void testAssertNotNull()
    {
        assertNotNull(notNullString); //Test will pass
        assertNotNull(nullString,"String is null"); //Test will fail

    }

    @Test
    void testAssertNull()
    {

        assertNull(nullString);   //Test will pass
        assertNull(notNullString,"String is not null");  // Test will fail

    }

    @Test
    void testAssertSame()
    {
        assertSame(originalObject, cloneObject); //Test will pass
        assertSame(originalObject, otherObject); // Test will fail
    }

    @Test
    void testAssertNotSame()
    {
        assertNotSame(originalObject, otherObject);   //Test will pass
        assertNotSame(originalObject, cloneObject);  //Test will fail

    }

    @Test
    public void testAssertTrue() {
        assertTrue(5 > 4, "5 is greater the 4");
        assertTrue(null == null, "null is equal to null");
    }

    @Test
    public void testAssertFalse() {
        assertFalse(4 > 5, "5 is greater than 4");
        assertFalse(null == null, "null is equal to null");
    }

    @Test
    void testAssertArray()
    {

//Test will pass
        assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3}, "Array Equal Test");

//Test will fail because element order is different
        assertArrayEquals(new int[]{1,2,3}, new int[]{1,3,2}, "Array Equal Test");

//Test will fail because number of elements are different
        assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3,4}, "Array Equal Test");

    }
}
