# Filmovi

Napisati program koji ucitava niz filmova iz fajla, sortira ih i ispisuje u drugi fajl.
Imena fajlova zadaje korisnik.
Fajlovi se mogu naci u [res](./res/) direktorijumu.

## Format fajla

Fajl je formatiran na sledeci nacin:
U prvom redu stoji broj N.
Posle njega sledi opis N elemenata niza.

Svaki element je predstavljen u tri reda.
U prvom redu se nalazi Id filma, tipa `int`, u sledecem je naziv filma, a u trecem ime reditelja. Imena su stringovi.

1. Id
2. Naziv
3. Reditelj

Dati su fajlovi filmovi12.txt i filmovi146.txt sa po 12 i 146 filmova u njima, respektivno, na kojima se moze testirati program.

Predpostaviti ako fajl postoji da je ispravan, odnosno da je u tacno opisanom formatu.

## O sortiranju

### 1. nivo

Za sortiranje koristiti metod `sort` iz klase `Arrays` iz paketa `java.util`.

Klasa koja predstavlja knjigu treba da implementira interfejs `Comparable` i da ima svoj `compareTo` metod da bi niz mogao biti sortiran gore pomenutim metodom. Na primer

```java
class Film implements Comparable<Film> {
  ...

	public int compareTo(Film drugiFilm) {
	...
	}
  ...
}
```

Najjednostavnija varijanta je da se niz filmova sortira po id-u filma.

Kada se testira da to radi, prepraviti da se filmovi sortiraju po reditelju i po nazivu, odnosno kod filmova kod kojih je reditelj isti filmovi treba da su sortirane po nazivu.

Sortirani niz snimiti u novi fajl u formatu kao u ulaznom fajlu.
Ovo se najbolje testira tako sto se program ponovo pokrene i ucita se novonapravljeni fajl.
Ako program normalno ucita i snimi podatke trebalo bi da je zadovoljen format.

### 2. nivo

#### Metod za sortiranje

Umesto da se koristi `Arrays.sort`, napisati sopstveni metod koji radi sortiranje.
Koristiti proizvoljnu metodu za sortiranje, a preporucuje se jedna od elementarnih metoda koje su opisane nize.


#### Komparatori

Komparatori su klase koje uporedjuju elemente neke druge klase.
Ovako se omogucava da se isti objekti mogu porediti na razlicite nacine, a ne samo na nacin definisan u `compareTo` metodu klase.

Da se ovakav komparator koristi u `Arrays.sort` treba dodati njegovu
instancu kao drugi parametar u pozivu metoda, na primer

```java
Arrays.sort(mojNiz, new MojKomparatorNizova());
```

Da bi se komparator koristio u sopstvenom metodu isto se moze definisati drugi parametar tipa Comparator ciji metod `compare` ce se onda pozivati u kodu umesto `compareTo` na objektu.

Na primer:

```java
//umesto
if (o.compareTo(o2)>0)
//koristiti
if (comp.compare(o,o2)>0)
```

#### Izbor sortiranja

Ponuditi korisniku da bira po cemu ce biti sortiran niz i na osnovu
odabira koristiti odgovarajuci komparator za sortiranje.

Ponuditi bar sledece opcije:
- id
- naziv
- reditelj
- reditelj/naziv

## Metode sortiranja

Postoje tri elementarne metode sortiranja.


### Sortiranje umetanjem (insertion)

Pretpostavimo da je pocetak niza sortiran.
Prvi element iz nesortiranog dela niza ubacujemo u sortirani deo na odgovarajuce mesto i to ponavljamo dokle god ne dodjemo do kraja niza.


### Sortiranje izabiranjem (selection)

Pretpostavimo da je pocetak niza, prvih K elemenata, sortiran i da je u njemu K najmanjih elemenata.
U nesortiranom delu niza nadjemo najmanji element i postavimo ga na pocetak nesortiranog dela.


### Sortiranje razmenom (exchange)

Pretpostavimo da je pocetak niza, prvih K elemenata, sortiran i da je u njemu K najmanjih elemenata.
Prolazimo kroz nesortirani deo, od kraja prema pocetku i za svaka dva elementa razmenimo mesta ako "stoje pogresno".

Takodje je poznato pod imenom "Bubble sort".

### Poredjenje metoda

Sortiranje razmenom u opstem slucaju daje najgore rezultate.

Sortiranje izabiranjem je najbolje ukoliko su elementi niza veliki, odnosno ako je operacija poredjenja brza od premestanja elemenata u nizu.

Sortiranje umetanjem daje najbolje rezultate ukoliko su elementi niza mali ili je poredjenje komplikovano, tj ako je premestanje brze od poredjenja.
