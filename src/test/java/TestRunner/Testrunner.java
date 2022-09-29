package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\felta\\Desktop\\Cucumber\\src\\Features",
        glue={"stepDefinitions"})
public class Testrunner {
}
