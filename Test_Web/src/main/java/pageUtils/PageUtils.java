package pageUtils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtils {

	WebDriver driver;
	WebDriverWait wait;

	public PageUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void acceptCookies(WebElement button) {
		try{
			button.click();
		}
		catch(Exception exception){
			System.out.println("There is no pop-up");
		}
	}
	
	public void waitForElement(By webBy) {
	wait = new WebDriverWait(driver, Duration.ofMillis(5000));
	wait.until(ExpectedConditions.visibilityOfElementLocated(webBy));
    }
}