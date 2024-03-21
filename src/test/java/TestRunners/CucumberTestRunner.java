package TestRunners;
import io.cucumber.core.cli.Main;
public class CucumberTestRunner {
    //Custom Test Runner Class:
    //Instead of using JUnit or TestNG, you can create your own custom test runner class to execute Cucumber tests.
    // This class can directly invoke Cucumber's execution engine and specify the configuration options programmatically.

    public static void main(String[] args) {
        String[] options = {
                "--glue",
                "UtilityClasses", // First package where step definitions are located
                "--glue",
                "StepDefinitions", // Second package where step definitions are located
                "src/test/resources/FeatureFiles" // Directory where feature files are located
        };

        Main.run(options, Thread.currentThread().getContextClassLoader());
    }
}
