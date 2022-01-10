import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/Users/higorbiz/Downloads/CucumberSelenium/src/test/java/feature/",
        glue = "steps",
        plugin = "pretty",
        dryRun = false,
        tags = "@validarDados"
        )
public class Runner {

}
