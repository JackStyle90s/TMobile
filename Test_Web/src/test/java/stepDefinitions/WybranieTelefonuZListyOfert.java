package stepDefinitions;

import java.io.IOException;

import baseTest.BaseTest;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.BasketPage;
import pageObjects.HomePage;
import pageObjects.MainMenu;
import pageObjects.ProductListPage;
import pageObjects.ProductPage;

@SuppressWarnings("deprecation")
public class WybranieTelefonuZListyOfert extends BaseTest {
	

	@Given("Otwórz odpowiednią przeglądarkę")
	public void otwórz_odpowiednią_przeglądarkę() throws IOException {
//		System.out.println(getDriver().toString().contains(getBrowserFromProperties()));
	}

	@Given("Przejdź na stronę {string}")
	public void przejdź_na_stronę(String url) {
		HomePage homePage = new HomePage(driver);
		homePage.goTo();
		Assert.assertEquals(homePage.getTitle(), "Telefony, Tablety, Laptopy, Szybki Internet - Dołącz do T-Mobile");
	}

	@When("Z górnej belki wybierz {string}")
	public void z_górnej_belki_wybierz_urządzenia(String category) {
		MainMenu mainMenu = new MainMenu(driver);
		mainMenu.selectMenuCategory(category);
	}

	@When("Kliknij {string} z kolumny {string}")
	public void kliknij_z_kolumny(String list, String group) {
		MainMenu mainMenu = new MainMenu(driver);
		mainMenu.selectListFromGroup();
	}

	@When("Kliknij w pierwszy element z listy")
	public void kliknij_w_pierwszy_element_z_listy() {
		ProductListPage urzadzeniaSmartwatcheIOpaskiBezAbonamentu = new ProductListPage(
				driver);
		urzadzeniaSmartwatcheIOpaskiBezAbonamentu.selectFirstProduct();
	}

	@Then("Dodaj produkt do koszyka")
	public void dodaj_produkt_do_koszyka() {
		ProductPage productPage = new ProductPage(driver);
		productPage.addToCart();
		String productInitialPrice = productPage.getInitialPrice();
		String productInitialRate = productPage.getMonthRate();
		BasketPage basketPage = new BasketPage(driver);
		Assert.assertEquals(productInitialPrice, basketPage.getInitialPrice());
		Assert.assertEquals(productInitialRate, basketPage.getInitialRate());
	}

	@Then("Przejdź na stronę główną T-Mobile")
	public void przejdź_na_stronę_główną_t_mobile() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.goTo();
		MainMenu mainMenu = new MainMenu(driver);
		Assert.assertNotNull(mainMenu.getCartCounter());
	}
	


}
