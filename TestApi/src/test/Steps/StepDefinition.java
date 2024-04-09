package test.Steps;

import io.cucumber.java.en.*;
import static io.restassured.RestAssured.*;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class StepDefinition {
	static RequestSpecification httpRequest;
	static Response response;
	static JSONArray jsonArray;

	@Given("Wykonaj operacje GET dla tabeli {string}")
	public void wykonaj_operacje_get_dla_tabeli(String tabela) {
		baseURI = "http://api.nbp.pl/api/";
		response = given().contentType("ContentType.JSON").pathParam("tabela", tabela).when().get("/exchangerates/tables/{tabela}");
		jsonArray = new JSONArray(response.getBody().asString());
	}

	@Then("Wyświetl kod odpowiedzi API")
	public void wyświetl_kod_odpowiedzi_api() {
		int statusCode = response.statusCode();
		System.out.println("Kod odpowiedzi API: "+statusCode);
		Assert.assertEquals(statusCode, 200);
	}

	@When("Wyświetl kurs dla waluty o kodzie: {string}")
	public void wyświetl_kurs_dla_waluty_o_kodzie(String currencyCode) {
		double midValue = 0;
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject tableObject = jsonArray.getJSONObject(i);
			JSONArray rates = tableObject.getJSONArray("rates");
			for (int j = 0; j < rates.length(); j++) {
				JSONObject rate = rates.getJSONObject(j);
				String code = rate.getString("code");
				if (code.equals(currencyCode)) {
					midValue = rate.getDouble("mid");
					break;
				}
			}
		}
		System.out.println(midValue);
	}
	@When("Wyświetl kurs dla waluty o nazwie: {string}")
	public void wyświetl_kurs_dla_waluty_o_nazwie(String currencyName) {
		double midValue = 0;
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject tableObject = jsonArray.getJSONObject(i);
			JSONArray rates = tableObject.getJSONArray("rates");
			for (int j = 0; j < rates.length(); j++) {
				JSONObject rate = rates.getJSONObject(j);
				String rateCurrency = rate.getString("currency");
				if (rateCurrency.equals(currencyName)) {
					midValue = rate.getDouble("mid");
					break;
				}
			}
		}
		System.out.println(midValue);
	}

	@When("Wyświetl waluty o kursie powyżej: {int}")
	public void wyświetl_waluty_o_kursie_powyżej(Integer value) {
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject tableObject = jsonArray.getJSONObject(i);
			JSONArray rates = tableObject.getJSONArray("rates");
			for (int j = 0; j < rates.length(); j++) {
				JSONObject rate = rates.getJSONObject(j);
				double midValue = rate.getDouble("mid");
				if (midValue > value) {
					String currency = rate.getString("currency");
					String code = rate.getString("code");
					System.out.println("Currency: " + currency + ", Code: " + code);
				}
			}
		}
	}

	@When("Wyświetl waluty o kursie poniżej: {int}")
	public void wyświetl_waluty_o_kursie_poniżej(Integer value) {
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject tableObject = jsonArray.getJSONObject(i);
			JSONArray rates = tableObject.getJSONArray("rates");
			for (int j = 0; j < rates.length(); j++) {
				JSONObject rate = rates.getJSONObject(j);
				double midValue = rate.getDouble("mid");
				if (midValue < value) {
					String currency = rate.getString("currency");
					String code = rate.getString("code");
					System.out.println("Currency: " + currency + ", Code: " + code);
				}
			}
		}
	}

}
