package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageUtils.PageUtils;

public class MainMenu extends PageUtils {

	WebDriver driver;
	

	@FindBy(id = "didomi-notice-agree-button")
	WebElement btn_AcceptCookies;

	@FindBy(css = "button[class*='group menu-dropdown-item dropdown-toggle']")
	List<WebElement> menuCategories;

	@FindBy(xpath = "//li [contains(@class,'group')]/p")
	List<WebElement> categoryGroups;

	@FindBy(xpath = "(//span [contains(., 'Bez abonamentu')])[2]")
	WebElement link_BezAbonamentuInSmartwatcheIZegarki;

	@FindBy(xpath = "(//span)[4]")
	WebElement counter_cartCounter;

	public MainMenu(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getMenuCategories() {
		return menuCategories;
	}

	public void selectMenuCategory(String category) {
		for (int i = 0; i < getMenuCategories().size(); i++) {
			String menuName = getMenuCategories().get(i).getText();
			if (menuName.contains(category)) {
				getMenuCategories().get(i).click();
			}
		}
	}

	public void selectListFromGroup() {
		link_BezAbonamentuInSmartwatcheIZegarki.click();
	}

	public WebElement getCartCounter() throws InterruptedException {
		return counter_cartCounter;
	}
}
