import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ExampleTest {
    BlackjackExample b = new BlackjackExample();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{0,0,0}, {1,1,0}, {2,1,2}, {3,2,3}, {4,3,4}, {5,5,0}, {6,8,8}});
    }

    private int input1;
    private  int input2;
    private int intExpected;

    public ExampleTest(int numberOne, int numberTwo, int expected) {
        input1 = numberOne;
        input2 = numberTwo;
        intExpected = expected;
    }


    @Test
    public void test() {
        assertEquals(intExpected, b.play(input1, input2));
    }
}
