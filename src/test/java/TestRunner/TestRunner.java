package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= "src/test/resources/features",
        glue = "stepDefinitions",
//        tags = "@AddPlace",
        plugin = {"pretty", "json:target/jsonReports/cucumber-report.json"}
)
public class TestRunner {
}
