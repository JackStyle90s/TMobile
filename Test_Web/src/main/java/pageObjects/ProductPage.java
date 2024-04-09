package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageUtils.PageUtils;

public class ProductPage extends PageUtils {

	WebDriver driver;

	@FindBy(xpath = "//div [@class='sc-gzzPqb fdaVoX dt_typography variant_bodyBold']")
	List<WebElement> btnList_AddToCart;
	
	@FindBy(css = ".rightAlignment .dt_price_change")
	List<WebElement> txtList_MonthRates;
	
	@FindBy(xpath = "//div[contains(@class, 'heading') and contains(.,'Do zapłaty na start')]/parent::div/following-sibling::div[contains(@class,'variant_h4')]")
	List<WebElement> txtList_InitialPrices;

	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addToCart() {
		for (int i = 0; i < btnList_AddToCart.size(); i++) {
			if (btnList_AddToCart.get(i).isDisplayed() == true) {
				btnList_AddToCart.get(i).click();
			}
		}
	}
	
	public String getInitialPrice() {
		String initialPrice = null;
		for (int i = 0; i < txtList_InitialPrices.size(); i++) {
			if (txtList_InitialPrices.get(i).isDisplayed() == true) {
				initialPrice = txtList_InitialPrices.get(i).getText();
			}
		}
		return initialPrice;
	}
	
	public String getMonthRate() {
		String monthRate = null;
		for (int i = 0; i < txtList_MonthRates.size(); i++) {
			if (txtList_MonthRates.get(i).isDisplayed() == true) {
				monthRate = txtList_MonthRates.get(i).getText();
			}
		}
		return monthRate;
	}

}
