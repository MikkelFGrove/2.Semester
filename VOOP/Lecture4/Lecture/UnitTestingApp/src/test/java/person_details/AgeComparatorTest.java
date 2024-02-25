package person_details;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class AgeComparatorTest {
    Person  p1 = new Person("Ali",112233, 29);
    Person  p2 = new Person("Rasmus",112234, 29);
    Person  p3 = new Person("Alizeh",112235, 10);
    AgeComparator ageComparator=new AgeComparator();

    @BeforeAll
    static void setup(){
        System.out.println("@BeforeAll executed");
    }

    @BeforeEach
    void setUp() {
        System.out.println("@BeforeEach executed");
    }

    @RepeatedTest(5)
    public void testEqual() {
        int result = ageComparator.compare(p1,p2);
        assertEquals(0,result,"P1 and P2 are not equal");
    }

    @Test
    public void testGreaterThan() {
        int result = ageComparator.compare(p1,p3);
        assertTrue(result >= 1, "P1 is not older than P3");
    }

    @Tag("Basic")
    @Test
    public void testLessThan() {
        int result = ageComparator.compare(p3,p1);
        assertTrue(result <= -1, "P3 is not younger than P3");
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach executed");
    }

    @AfterAll
    static void tear(){
        System.out.println("@AfterAll executed");
    }

}