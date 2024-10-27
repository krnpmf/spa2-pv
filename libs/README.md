# Pomoćne biblioteke

## Učitavanje i ispisivanje podataka

Pored ugrađenih alata za čitanje i pisanje podataka, bilo sa konzole ili iz fajla, moguće je koristiti i razne dodatne biblioteke koje će olakšati taj posao.
Umesto da se stalno instanciraju klase poput `BufferedReader` i `BufferedWriter` i potom hvataju izuzeci za te klase i parsiraju linije koje se učitaju, moguće je iskoristiti neku biblioteku koja rešava sve to za nas od otvaranja fajla do parsiranja individualnih tokena u traženi tip podatka.

### Svetovid

Na katedri za računarske nauke je razvijena biblioteka koja između svih njenih drugih funkcionalnosti može da učitava i ispisuje bilo koji tip podatka sa konzole i na konzolu kao i da učitava i ispisuje bilo koji tip podatka u i iz fajla.
Predviđena je da olakša rad na krusevima gde nije fokus sam rad programskog jezika Java već neke druge oblasti računarstva, kao što su to na ovom kursu strukture podataka i algoritmi.

Može se preuzeti sa zvaničnog sajta biblioteke [svetovid.org](https://svetovid.org) a uputstva za dodavanje u radno okruženje se za sada mogu naći na Moodle stranici kursa.

### stdlib/algs4 sa Univerziteta Princeton

Kao dodatak uz dve knjige od autora Robert Sedgewick i Kevin Wayne [^1][^2] su implementirana je biblioteka koja pruža učitavanje i ispisivanje podataka, [stdlib](https://introcs.cs.princeton.edu/java/stdlib/).
Slično kao Svetovid, značajno olakšava rad sa fajlovima i može ubrzati pisanje programa.

Ukoliko biste hteli da je koristite, stdlib biblioteka se može koristiti samo unutar `default` paketa u Java projektima dok [algs4](https://algs4.cs.princeton.edu/code/) biblioteka koja sadrži sve klase koje se nalaze i u stdlib se može koristiti u "imenovanim" paketima.


[^1]: Computer Science: An Interdisciplinary Approach by Robert Sedgewick and Kevin Wayne

[^2]: Algorithms, 4th Edition by Robert Sedgewick and Kevin Wayne
