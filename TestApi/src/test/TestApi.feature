Feature: Waluty


Scenario: Pobierz kursy walut 
Given Wykonaj operacje GET dla tabeli "A"
Then Wyświetl kod odpowiedzi API

Scenario: Wyświetl kurs dla waluty o podanym kodzie
When Wyświetl kurs dla waluty o kodzie: "USD"

Scenario: Wyświetl kurs dla waluty o podanej nazwie
When Wyświetl kurs dla waluty o nazwie: "dolar amerykański"

Scenario: Wyświetl waluty o kursie wiekszym niz
When Wyświetl waluty o kursie powyżej: 5

Scenario: Wyświetl waluty o kursie mniejszym niz
When Wyświetl waluty o kursie poniżej: 3