# Pripremni zadatak iz sortiranja

Deda Mraz već sada krajem novembra meseca treba da počne sa pripremama za novu godinu kako bi mogao da spremi sve poklone na vreme.
Pošto je do sada to radio na staromodan način tako što je prolazio kroz svoje beleške ko je bio dobar u toku godine a ko nije, shvatio je da je to dosta neefikasno i da ukoliko bi ubrzao taj proces, mogao bi da ima više slobodnog vremena.

Kako su svi podaci o deci i da li su ona dobra ili ne već uneti u tekstualni fajl, Deda Mraz je rešio da se ove godine digitalizuje i pripremi program koji će mu sortirati svu decu da bi što brže mogao da pripremi poklone.
Odklučio se da mu studenti informatike Prirodno-matematičkog Fakulteta ponude neka rešenja.

Podaci se nalaze u direktorijumu [res](./res/).

## Sadržaj fajla

Informacije o deci se nalaze u tekstualnom fajlu u čijem prvom redu se nalazi
broj dece u tom fajlu.
Informacije o svakom detetu se prostiru na tri reda.
U prvom se nalazi ime a u drugom prezime deteta.
U trećem se nalazi informacija da li je dete bilo dobro te godine ("da" ili "ne") i broj godina odvojeni razmakom.

Informaciju da li je dete bilo dobro ili ne bi Deda Mraz hteo da se skladišti u `boolean` polju.

Deda Mraz je obezbedio i jedan manji fajl na kom možete testirati vaš program.

Potrebno je napisati program "Sortiranje" koji učitava podatke od deci iz fajla, sortira ih i skladišti u drugi fajl.

## Klasa

Potrebno je napraviti klasu koja predstavlja tip podatka deteta i skladišti sve informacije jednog deteta iz fajla.

Pošto Deda Mraz želi da se prate konvencije OOP-a, treba obratiti pažnju na definicije polja klase i njihov pristup i promenu izvan nje.

## Učitavanje i snimanje podataka

Deda Mraz bi hteo da ima mogućnost da unese naziv fajla koji će se učitati.
Ukoliko se ispostavi da taj fajl ne postoji ili nije moguće da se pročita, treba obustaviti dalji rad programa.

Deda Mraz je vrlo temeljan tako da se pretpostavlja da je fajl ispravno formatiran po pravilima koja su opisana gore.

Sortirani podaci trebaju da budu sačuvani u fajl koji je formatiran isto kao ulazni, to jest da se može koristiti kao ulazni fajl opet.
Takođe je potrebno da se omogući unos fajla u koji se čuvaju podaci.

## Poredak dece

Klasa koja predstavlja dete treba da implementira interfejs `Comparable` i da ima svoj `compareTo` metod da bi niz mogao biti sortiran.

Prirodni poredak dece je takav da se prvo sortiraju po tome koja su dobra a koja ne (prvo idu dobra deca), pa po prezimenu a zatim po imenu.

Pored toga je potrebno implementirati komparatore za druge poretke koji će Deda Mrazu biti korisni.
On bi takođe hteo da ima opciju da bira na koji način će se spisak sortirati unosom broja.
Ukoliko slučajno unese pogrešan broj, treba prijaviti grešku i odustati od daljeg rada.

Prva opcija je sortiranje prirodnim uređenjem.

Ostale opcije su soritranje komparatorima (klase koje implementiraju interfejs `Comparator` iz paketa `java.util`).

Drugi poredak treba da bude po tome da li je dete dobro ili nije, po njihovom
uzrastu i imenu.
Odnosno deca trebaju da budu sortirana po ponašanju (prvo idu dobra pa onda ona koja nisu), potom treba da budu sortirana po uzrastu a ona koja su istog uzrasta po imenu.

Treći poredak je po njihovom uzrastu, zatim po ukupnoj dužini imena i prezimena a na kraju po tome da li su dobra ili ne.
Odnosno deca koja su istog uzrasta treba da budu sortirana po zbiru dužina imena i prezimena a ona koja imaju iste dužine imena i prezimena da budu sortirana po tome da li su dobra ili ne (prvo idu dobra deca pa onda ona koja nisu).

## Sortiranje

Napisati metod koji sortira prosleđeni niz dece po prosleđenom poretku (komparatoru).
Potrebno je koristiti jedan od elementarnih metoda sortiranja.

Pošto Deda Mraz ima dosta snažnu mašinu, implementirati sortiranje tako da ono maksimalno traje, odnosno da treba izabrati najneefikasniju metodu.

## Stil programiranja

Pri pisanju programa obratiit pažnju na stil, što uključuje organizaciju koda u klase i metode, vidljivost polja u klasama, uredno formatiranje koda, logična imena klasa, metoda i polja u skladu sa standardima jezika Java.
