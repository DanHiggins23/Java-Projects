import org.junit.*;
import static org.junit.Assert.assertEquals;

public class BlackjackTest {
    BlackjackExample b = new BlackjackExample();
    static int count = 1;

    @BeforeClass
    public static void before() {
        System.out.println("\nWelcome to the Tests");
    }

    @Before
    public void setup() {
        System.out.println("Test: " + count + "/17");
    }

    @Test
    public void test1() {
        assertEquals("2 low invalid entries", 0, b.play(-10, -10));
    }

    @Test
    public void test2() {
        assertEquals("1 low invalid entries, 1 low valid", 0, b.play(-10, 10));
    }

    @Test
    public void test3() {
        assertEquals("1 low, 1 high valid entries", 0, b.play(-10, 30));
    }

    @Test
    public void test4() {
        assertEquals("2 low invalid entries", 0, b.play(-10, -50));
    }

    @Test
    public void test5() {
        assertEquals("1 valid, 1 invalid entries", 0, b.play(10, -10));
    }

    @Test
    public void test6() {
        assertEquals("1 low valid, 1 high valid entries", 10, b.play(10, 30));
    }

    @Test
    public void test7() {
        assertEquals("1 low valid, 1 high invalid entries", 0, b.play(10, 50));
    }

    @Test
    public void test8() {
        assertEquals("2 valid entries", 20, b.play(20, 10));
    }

    @Test
    public void test9() {
        assertEquals("2 valid entries", 20, b.play(10, 20));
    }

    @Test
    public void test10() {
        assertEquals("1 high valid, 1 low invalid entries", 0, b.play(30, -10));
    }

    @Test
    public void test11() {
        assertEquals("1 high valid, 1 low valid", 10, b.play(30, 10));
    }

    @Test
    public void test12() {
        assertEquals("2 high valid entries", 0, b.play(30, 30));
    }

    @Test
    public void test13() {
        assertEquals("1 high valid, 1 high invalid entries", 0, b.play(30, 50));
    }

    @Test
    public void test14() {
        assertEquals("1 high invalid, 1 low invalid entries", 0, b.play(50, -10));
    }

    @Test
    public void test15() {
        assertEquals("1 high invalid, 1 low invalid entries", 0, b.play(50, 10));
    }

    @Test
    public void test16() {
        assertEquals("2 low invalid entries", 0, b.play(50, 30));
    }

    @Test
    public void test17() {
        assertEquals("2 low invalid entries", 0, b.play(50, 50));
    }

    @After
    public void teardown() {
        System.out.println("Test finished\n");
        count ++;
    }

    @AfterClass
    public static void after() {
        System.out.println("All tests completed");
    }
}
