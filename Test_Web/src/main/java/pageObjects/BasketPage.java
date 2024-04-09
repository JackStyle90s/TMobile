package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageUtils.PageUtils;




public class BasketPage extends PageUtils {

	WebDriver driver;

	@FindBy(xpath = "//span [@data-qa='BKT_TotalupFront']")
	WebElement txt_InitialPriceValue;
	@FindBy(xpath = "//span [@data-qa='BKT_TotalupFrontSymbol']")
	WebElement txt_InitialPriceCurrency;
	@FindBy(xpath = "//span [@data-qa='BKT_TotalMonthly']")
	WebElement txt_MonthRateValue;
	@FindBy(xpath = "//span [@data-qa='BKT_TotalMonthlySymbol']")
	WebElement txt_MonthRateCurrency;

	public BasketPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getInitialPriceValue() {
		String initialPriceValue = txt_InitialPriceValue.getText();
		return initialPriceValue;
	}

	public String getInitialPriceCurrency() {
		String InitialPriceCurrency = txt_InitialPriceCurrency.getText();
		return InitialPriceCurrency;
	}

	public String getMonthRateValue() {
		String MonthRateValue = txt_MonthRateValue.getText();
		return MonthRateValue;
	}

	public String getMonthRateCurrency() {
		String MonthRateCurrency = txt_MonthRateCurrency.getText();
		return MonthRateCurrency;
	}

	public String getInitialPrice() {
		String initialPrice = getInitialPriceValue() + " " + getInitialPriceCurrency();
		return initialPrice;
	}

	public String getInitialRate() {
		String initialRate = getMonthRateValue() + " " + getMonthRateCurrency();
		return initialRate;
	}

}
