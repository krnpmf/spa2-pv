package sort.prakticne_vezbe.resenje.napredno;

/*
 * Kako je `compare` metoda za kompozitni komparator vec implementirana, potrebno
 * je samo definitisati koji komparatori se koriste kada se pravi kompozitni komparator
 * koji koristi odredjene komparatore.
 * 
 * To se moze vrlo lako uraditi prostim implementiranjem konstruktora koji direktno
 * instancira odredjene komparatore.
 */
public class KomparatorRediteljNaziv extends KompozitniKomparator {
  public KomparatorRediteljNaziv() {
    super(new KomparatorReditelj(), new KomparatorNaziv());
  }
}
