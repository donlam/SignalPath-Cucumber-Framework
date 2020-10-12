package env;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {
			 "pretty", "html:target/cucumberHtmlReport",
		     "html:target/cucumberHtmlReport",     //  for html result
			 "pretty:target/cucumber-json-report.json"   // for json result
		     },
		features = "classpath:features",
		glue = {"info.seleniumcucumber.stepdefinitions",   // predefined step definitions package
				"info.seleniumcucumber.userStepDefintions", // user step definitions package
				"info.seleniumcucumber.APIStepDefintions" // user step definitions package
			   }
)

public class RunCukeTest { 	
}
