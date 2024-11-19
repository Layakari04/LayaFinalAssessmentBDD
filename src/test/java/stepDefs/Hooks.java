package stepDefs;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;


import base.TestBasePage;
import io.cucumber.java.After;

import io.cucumber.java.Before;

import io.cucumber.java.Scenario;

public class Hooks {

	@Before
	public static void setupDriver() {
		TestBasePage.initDriver();
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot screen = (TakesScreenshot) TestBasePage.getDriver();
			byte[] imgBytes = screen.getScreenshotAs(OutputType.BYTES);
			scenario.attach(imgBytes, "image/png", "ScreenImage");
		}
//		TestBase.tearDown();
	}
}
