package TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/FeatureFiles/UserLogin.feature",
                "src/test/resources/FeatureFiles/LoggedInActions.feature",
                "src/test/resources/FeatureFiles/MultiCriteriaSearch.feature",
                "src/test/resources/FeatureFiles/UpperButtons.feature"
        },

        glue = {"StepDefinitions",
                "UtilityClasses"},

        tags = "@Active",

        plugin = {"pretty",
                "html:target/Reports/Cucumber-reports-html/cucumber-reports",
                "json:target/Reports/Cucumber-reports-json/cucumber-reports"}
)

public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
