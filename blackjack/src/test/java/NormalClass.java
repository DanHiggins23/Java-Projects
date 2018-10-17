import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NormalClass {
    BlackjackExample b = new BlackjackExample();

    @Test
    public void test8() {
        assertEquals("2 valid entries", 20, b.play(20, 10));
    }

    @Test
    public void test9() {
        assertEquals("2 valid entries", 20, b.play(10, 20));
    }
}
