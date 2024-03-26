package UtilityClasses;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CucumberReporting {

    public static void main(String[] args) {
        String buildNumber = "230324";
        String projectName = "SeleniumFramework";
        File reportOutputDir = new File("target/Reports/ReportMasterthought");

            Configuration configuration = new Configuration(reportOutputDir, projectName);
            configuration.setBuildNumber(buildNumber);

            List<String> jsonInput = new ArrayList<>();
            jsonInput.add("target/Reports/Cucumber-reports-json/cucumber-reports");

                ReportBuilder reportBuilder = new ReportBuilder(jsonInput, configuration);
                reportBuilder.generateReports();

    }
}
