package sort.prakticne_vezbe.resenje.napredno;

import java.util.Comparator;

/*
 * Kompozitni komparator moze da nam sluzi ako imamo vise komparatora koji porede
 * dve klase po nekim kiterijumima da te klase poredimo po kombinaciji tih individualnih
 * kriterijuma, tj. da ih komponujemo u novi komparator.
 *
 * On radi po principu primanja dva komparatora u konstruktoru i skladistenja tih
 * komparatora u polja instance klase. Kada se poziva metoda compare, ona nece porediti
 * objekte po njihovim poljima vec ce pozivati komparatore koji su prosledjeni u
 * konstruktoru i njihov rezultat ce koristiti za poredjenje.
 * 
 * Ovim nacinom se moze implementirati nekoliko komparatora koji porede individualna
 * polja klase a potom koristeci kompozitni komparator, mogu se kombinovati kako bi se dobio
 * jedan veliki komparator koji poredi po svim kriterijumima po kojima objekte porede
 * individualni komparatori.
 */
public class KompozitniKomparator implements Comparator<Film> {
  // Polja za dva komparatora
  private Comparator<Film> c1, c2;

  public KompozitniKomparator(Comparator<Film> c1, Comparator<Film> c2) {
    // Dva komparatora se prosledjuju u konstruktoru
    this.c1 = c1;
    this.c2 = c2;
  }

  @Override
  public int compare(Film o1, Film o2) {
    // Poredimo po prvom prosledjenom komparatoru
    int rezultat = this.c1.compare(o1, o2);

    // Ukoliko rezultat poredjenja nije 0, tj. po prvom komparatoru su objekti
    // razliciti, onda se rezultat poredjenja vraca
    if (rezultat != 0) {
      return rezultat;
    }

    // Poredimo po drugom prosledjenom komparatoru
    rezultat = this.c2.compare(o1, o2);

    // Ukoliko rezultat poredjenja nije 0, tj. po drugom komparatoru su objekti
    // razliciti, onda se rezultat poredjenja vraca
    if (rezultat != 0) {
      return rezultat;
    }

    // Ukoliko su po oba komparatora objekti jednaki, onda se smatraju jednakim
    // i stoga se vraca 0
    return 0;
  }
}
