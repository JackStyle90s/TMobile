package baseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	protected static WebDriver driver;
	protected String browser;

	public WebDriver initialazeDriver() throws IOException {
		browser = System.getProperty("browser")!=null ? System.getProperty("browser") : getBrowserFromProperties();
		if ("chrome".equals(browser)) {
			this.driver = new ChromeDriver();
		} else if ("firefox".equals(browser)) {
			this.driver = new FirefoxDriver();
		} else if ("edge".equals(browser)) {
			this.driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		return driver;
	}

	public String getBrowserFromProperties() throws IOException {

		Properties prop = new Properties();
		FileInputStream fil = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/Properties.properties");
		prop.load(fil);
		String browser = prop.getProperty("browser");
		return browser;
	}

	public WebDriver getDriver() {
		return driver;
	}

}
