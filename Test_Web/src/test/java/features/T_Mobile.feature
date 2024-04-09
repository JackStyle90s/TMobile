

Feature: T_Mobile
	@Test
  Scenario: Wybranie telefonu z listy ofert
    Given Otwórz odpowiednią przeglądarkę
    And Przejdź na stronę "https://www.t-mobile.pl/"
    When Z górnej belki wybierz "Urządzenia"
    And Kliknij "Bez abonamentu" z kolumny "Smartwatche i opaski"
    And Kliknij w pierwszy element z listy
    Then Dodaj produkt do koszyka
    And Przejdź na stronę główną T-Mobile
