package TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//, "UtilityClasses"
@CucumberOptions(
        features = {"src/test/resources/FeatureFiles/LoggedInActions.feature"},
        glue = {"StepDefinitions", "UtilityClasses"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)

public class TestRunnerLoggedInActions extends AbstractTestNGCucumberTests{
}
