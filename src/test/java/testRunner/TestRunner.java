package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"features"},
        glue = {"steps"},
        plugin = {"pretty", "html:Report"},
        tags = "@ValidatePackagesForAllCountries or @ValidateOffersForSomeCountries"
)
public class TestRunner {

}
