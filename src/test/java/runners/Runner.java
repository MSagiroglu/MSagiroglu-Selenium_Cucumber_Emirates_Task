package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
        "html:target/default-cucumber-reports.html",
        "json:target/json-reports/cucumber.json",
        "junit:target/xml-report/cucumber.xml",
        "rerun:target/failed_scenarios.txt"
},

        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        tags = "@emirates2",
        dryRun = false,
        monochrome = true


)
public class Runner {
}
