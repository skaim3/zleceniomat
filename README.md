# zleceniomat

Projekt prostej aplikacji webowej, pozwalająca na tworzenie i zarządzanie zleceniami IT.

## Użytkownicy:
- CUSTOMER - zleceniodawaca, może dodawać i edytować zlecenia (przycisk edycji przy każdym zleceniu), widzi tylko swoje zlecenia (zarówno te dostępne jak i niedostępne), może przeglądać oferty zaproponowane w odpowiedzi do swoich zleceń (przycisk wykrzyknika przy każdym zleceniu)
- CONTRACTOR - zleceniobiorca, może dodawać oferty do wszystkich **dostępnych** zleceń, ma możliwość przeglądania złożonych przez siebie ofert (przycisk w menu), może edytować swoje oferty

## Funkcjonalności:
- Rejestrowanie użytkownika do bazy danych
- Logowanie
- Dodawanie zleceń (Assignments) jako zleceniodawca (Customer)
- Dodawanie ofert do zleceń (Offers) jako zleceniobiorca (Contractor)
- Edytowanie istniejących zleceń jako zleceniodawca
- Edytowanie istniejących ofert do zleceń jako zleceniobiorca

## Webservice: 
Aplikacja posiada wbudowany webserwis wypełniający bazę danych przykładowymi danymi:
- Użytkownik Zleceniobiorca - Login: Andrzej, hasło: andrzej
- Użytkownik Zleceniodawca - Login: Anton, hasło: anton
- Przykładowe zlecenia należące do użytkownika Anton

**Ważne! Aby Webservice zadziałał musimy najpierw uruchomić aplikację a następnie: ** 
- Skorzystać z aplikacji mogącej przesłać żądanie GET (przykładowo Insomnia). W aplikacji Insomnia wykonujemy następujące żądanie GET: http://localhost:8080/fillTheDatabase 
- Alternatywnie możemy wpisać żądanie http://localhost:8080/fillTheDatabase bezpośrednio w naszej przeglądarce w polu gdzie wprowadzamy adres strony internetowej (lub nacisnąć na hiperłącze do tego linku, jeżeli program/przeglądarka w którym czytamy ten plik ReadMe nam na to pozwala)

## Planowane zmiany:
Aplikacja zawiera kilka niedociągnięć, Kod HTML i CSS aplikacji wymaga optymalizacji pod kątem czytelności i poprawy struktury (brak oddzielnych arkuszów stylów dla ofert, id/klasy powtarzane pomiędzy podstronami html gdy powinny prezentować inne dane niż wskazuje nazwa). Kontynuując ten projekt dopracowałbym te niedociągnięcia, jak również dodał kilka funkcjonalności (przykładowo możliwość zaakceptowania proponowanej oferty i tym samym zmianę statusu dostępności zlecenia)
