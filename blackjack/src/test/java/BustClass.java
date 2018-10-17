import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BustClass {
    BlackjackExample b = new BlackjackExample();

    @Test
    public void test6() {
        assertEquals("1 low valid, 1 high valid entries", 10, b.play(10, 30));
    }

    @Test
    public void test11() {
        assertEquals("1 high valid, 1 low valid", 10, b.play(30, 10));
    }

    @Test
    public void test12() {
        assertEquals("2 high valid entries", 0, b.play(30, 30));
    }

}
