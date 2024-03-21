package UtilityClasses;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CucumberReporting {

    public static void main(String[] args) {
        String buildNumber = "200324";
        String projectName = "SeleniumFramework";


        File reportOutputDirectory = new File("target/Reports");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/Reports/Cucumber-reports-json/cucumber-report"); // Path to your JSON-formatted Cucumber test results

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setBuildNumber(buildNumber);


        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
