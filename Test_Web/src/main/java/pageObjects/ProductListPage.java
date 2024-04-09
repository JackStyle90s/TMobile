package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageUtils.PageUtils;

public class ProductListPage extends PageUtils {
	
	WebDriver driver;
	
	@FindBy(css = ".dt_productCards")
	List<WebElement> products;
	
	@FindBy(css = ".leftText .variant_h4")
	List<WebElement> startPrices;
	
	@FindBy(css = ".rightText .variant_h4")
	List<WebElement> rates;
	
	public ProductListPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectFirstProduct() {
		products.get(0).click();
	}

}
