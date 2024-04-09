package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageUtils.PageUtils;


public class HomePage extends PageUtils {

	WebDriver driver;

//	WebElement btn_AcceptCookies = driver.findElement(By.id("didomi-notice-agree-button"));
	@FindBy(id = "didomi-notice-agree-button")
	WebElement btn_AcceptCookies;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goTo() {
		driver.get("https://www.t-mobile.pl/");
		acceptCookies(btn_AcceptCookies);
	}

	public String getTitle() {
		return driver.getTitle();
	}

}
