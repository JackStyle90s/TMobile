package hooks;

import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import baseTest.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	private WebDriver driver;
	private BaseTest baseTest;

	@Before(order = 0)
	public void launchBrowser() throws IOException {
		baseTest = new BaseTest();
		driver = baseTest.initialazeDriver();
	}

	@After(order = 0)
	public void captureLogs(Scenario scenario) {
		String scenarioName = scenario.getName();
		String scenarioStatus = scenario.getStatus().toString();
		System.out.println("Scenario: " + scenarioName + ", Status: " + scenarioStatus);
	}

	@After(order = 1)
	public void captureScreenshotOnFailure(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				TakesScreenshot ts = (TakesScreenshot) driver;
				byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshotBytes, "image/png", "Screenshot");
			} catch (Exception e) {
				System.out.println("Exception while capturing screenshot: " + e.getMessage());
			}
		}
	}
	@After(order = 2)
	public void closeDriver() {
		driver.quit();
	}
}
