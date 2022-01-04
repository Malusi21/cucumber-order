package StepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/UserRegistration.feature", glue={"StepDefinitions"},
        monochrome = true,
        plugin = {"pretty","junit:target/JUnitReport.xml","html:target/HtmlReport.html","json:target/JsonReport.json"},
        tags = "@Registration")
public class UserOnlineRegistrationRunner {

}