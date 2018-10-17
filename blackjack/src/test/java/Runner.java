import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Runner {
    public static void main(String[] args) {
        Runner.allTests();
    }

    public static void allTests() {
        Result result = JUnitCore.runClasses (
                InvalidEntriesSuite.class,
                ValidEntriesSuite.class);

        System.out.println("All tests passed: " + result.wasSuccessful() + "\n");

        if (!result.wasSuccessful()) {
            System.out.println("Failed Tests:");
            for (Failure failure: result.getFailures()) {
                System.out.println(failure.toString());
            }
        }
    }
}
