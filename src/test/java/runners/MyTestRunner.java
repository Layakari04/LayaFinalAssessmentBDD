package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "src//test//resources//features//ConduitCRUD.feature",
		glue = {"stepDefs"},
		dryRun=false,
		monochrome=true,
		plugin = {"pretty",
				"html:target/reports/HtmlReport.html",
			}
//		tags = "@SmokeTest"
	)

public class MyTestRunner extends AbstractTestNGCucumberTests{
 
}
