package calculator;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MiniCalculatorTest {


    @BeforeAll
    static void setup(){
        System.out.println("@BeforeAll executed");
    }

    @BeforeEach
    void setUp() {
        System.out.println("@BeforeEach executed");
    }

    @Order(1)
    @Test
    void add() {
        System.out.println("======Add TEST EXECUTED=======");
        assertEquals( 6 , MiniCalculator.add(2, 4));
        assertNotEquals(3, MiniCalculator.add(2, 2));

    }

    @Order(2)
    @Test
        //@Order(2)
    void multiply() {
        System.out.println("======Multiply TEST EXECUTED=======");
        assertEquals( 8 , MiniCalculator.multiply(2, 4));
    }


    @Order(3)
    @Test

    void subtract() {
        System.out.println("======Subtract TEST EXECUTED=======");
        assertEquals( 2 , MiniCalculator.subtract(4, 2));
    }

    @Test
    @Order(4)
    void testException() {
        int x=-7;
        int y=5;
        System.out.println("======Subtract Exception TEST EXECUTED=======");
        assertThrows(IllegalArgumentException.class, () -> MiniCalculator.subtract(x, y));
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