import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"/Users/user/IdeaProjects/lv.onea.final/src/test/resources/features"},
        glue = {"steps", "utils"},
        tags = {"@Chrome or @ChromeHeadless"}
)
public class TestRunner {
}