# Automobili

Date su dve klase koje treba dopuniti `Boja` u `Boja.java` fajlu i `Automobil` u `Automobil.java` fajlu.

Osim toga su dati ulazni fajlovi, kao i klasa StatSet koja je primer klasicnog Java skupa i program TestHash koji sluzi za testiranje napravljenog.
Ove fajlove nema potrebe menjati, pa cak ni pokretati, posto postoje `main` metodi u datim klasama koji ih koriste.

## Zadatak 1

Data je nedovrsena klasa `Boja`.
U okviru nje treba definisati polja u skladu sa opisom tipa, te napraviti metod za ucitavanje podataka, a nakon toga i `equals` i `hashCode` metode.

Glavni metod ove klase ce pokrenuti `TestHash` program za testiranje, sa adekvatnim parametrima za ovu klasu.
Test program ce ucitati podatke koristeci ovde definisani metod za ucitavanje, smestiti ih u skupove tipa `StatSet` razlicitih velicina i ispisati statistike o koriscenju.   
Takodje ce uraditi dodatne testove ubacivanja i izbacivanja
iz skupa.


### Tip podataka

Boja u ovoj klasi je predstavljena u RGB prostoru boja, tj sastoji se od tri broja u opsegu 0-255.

U fajlu se ovo predstavlja sa 3 broja razdvojena razmacima u istom redu.

Neke od vrednosti u ovim opsezima su cesce od drugih.
U datim primerima su boje koje koriste programeri, a oni tipicno vole da koriste stepene dvojke kao vrednosti.


## Zadatak 2

Potrebno je dopuniti iste metode i u klasi `Automobil`.

Automobil je predstavljen svojim modelom i sa tri boje -- karoserija, sedista i volan.
Model je stringovni opis i tipicno se sastoji od imena kompanije i konkretnog imena modela, ali se moze posmatrati kao jedan string.
Boje su predstavljene u RGB prostoru, odnosno primerci su klase iz prvog zadatka.

U fajlu je Automobil dat sa opisom modela u prvom redu, a u sledeca tri reda su opisi boja, kao sto je dato u prvom zadatku.
Dalje postoji prazan red pre sledeceg automobila u fajlu.

U datim primerima fajlova postoji samo nekoliko razlicitih modela automobila, od kojih su neki cesci od drugih.
Takodje boje delova su obicno iz relativno malog skupa od 15-ak boja, medju kojima su neke (npr bela i crna) cesce od drugih.
