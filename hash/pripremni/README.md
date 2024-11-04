# Pripremni zadatak iz hashCode i equals metoda

Pošto su se radovi studenata informatike dopali Deda Mrazu, odlučio je da im zada još jedan zadatak.
Planira da napravi jedan veliki sistem kojim bi pratio svu decu i koji bi bio dovoljno efikasan da pretražuje informacije o njima.
Za to je naravno najbolje koristiti neke naprednije strukture podataka poput Mape i Seta.
Da bi uspešno koristio te strukture podataka, strukture u kojima se skladište informacije o deci moraju biti adekvatno implementirane.
Zato će od studenata informatike Deda Mraz tražiti da napišu klase koje implementiraju hash funckiju i funkciju jednakosti.

Deda Mraz želi da pored samih informacija o deci prati i u kom gradu žive.
Zbog toga je potrebno implementirati dve klase, jedna za informacije o lokaciji a druga za informacije o deci.

## Lokacija

Od informacija o lokaciji, Deda Mraz ima samo geografsku širinu i dužinu neke lokacije.
Zapis o jednoj lokaciji je pretstavljen samo jednim redom u kom se nalaze celobrojni deo geografske širine, decimalni deo geografkse širine, celobrojni deo geografske dužine i decimalni deo geografske dužine odvojeni razmacima.
Pošto baza podataka koju koristi na svojim serverima, RudolfDB 4.2, je mnogo bolja u skladištenju integer-a u odnosu na floating point vrednosti, Deda Mraz bi hteo da se u programu koriste integer-i za zapisivanje ovih vrednosti.

Sve te informacije je potrebno koristiti u hash funckiji i funkciji jednakosti koju implementirate u toj klasi.
Pored toga, klasa mora da implementira i metod `učitaj` koji će učitati samo jedan element iz fajla.
Pošto Deda Mraz koristi TestHash klasu da bi testirao Vaše metode, nije potrebno da išta sem tih funckija i praznog kao i parametrizovanog konstruktora da implementirate.

Testirajte ispravnost vaših hash i funckija jednakosti pokretanjem fajla Lokacija.java.
U njemu je implementirana main metoda koju takođe nije potrebno menjati.
Da bi Deda Mraz traži da hash code funkcija dobije ocenu 100% i da funkcija jednakosti prođe sve testove ispravno.
Imajte u vidu da ti testovi ne mogu garantovati potpunu ispravnost Vaših funkcija.

## Dete

Kao i u prošlom zadatku koji Vam je zadao Deda Mraz, od informacija o deci ima
njihovo ime, prezime, uzrast i da li su deca bila dobra ove godine.
Radi povećanja efikasnosti, Deda Mraz traži da se koristi boolean vrednost za informaciju o ponašanju.
Pored toga ovaj put ima i informaciju o lokaciji njihovog grada, kuće i lokaciju dimnjaka pošto će sa tom informacijom moći mnogo bolje da nacilja gde da parkira sanke.

U fajlu u prvom redu zapisa jednog deteta se nalazi njihovo ime, u drugom prezime a u trećem informacija o tome da li je dete bilo dobro ili ne ("da" ili "ne") i njihov uzrast (ceo broj) odvojeni razmakom.
Nakon toga, u naredna tri reda se nalaze informacije o lokacijama grada, kuće i dimnjaka u istom formatu kao što su zapisane geografske lokacije za klasu Lokacija.

Potrebno je da koristite klasu Lokacija da biste skladištili informaciju o lokaciji deteta u klasi Dete.

Sve te informacije je potrebno koristiti u hash funckiji i funkciji jednakosti koju implementirate u toj klasi.
Pored toga, klasa mora da implementira i metod `učitaj` koji će učitati samo jedan element iz fajla.
Pošto Deda Mraz koristi TestHash klasu da bi testirao Vaše metode, nije potrebno da išta sem tih funckija i praznog kao i parametrizovanog konstruktora da implementirate.

Testirajte ispravnost vaših hash i funckija jednakosti pokretanjem fajla Dete.java.
