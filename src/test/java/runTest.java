import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import net.serenitybdd.junit.runners.SerenityRunner;

@RunWith(Cucumber.class)
//@RunWith(SerenityRunner.class)
//@RunWith(CucumberWithSerenity.class)
@CucumberOptions( features = "src/test/resources/featurefile/" )
public class runTest { }