package TestRunner;
import cucumber.deps.com.thoughtworks.xstream.io.json.JsonWriter;
import io.cucumber.core.options.CucumberOptionsAnnotationParser;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/Features/Login.feature", "src/Features/Customers.feature"},
        glue={"stepDefinitions"},dryRun =false,
        monochrome = true,
        plugin = {"pretty","html:test-outputt.html"}

         )


public class Testrunner {

}
