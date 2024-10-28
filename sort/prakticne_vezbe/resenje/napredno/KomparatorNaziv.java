package sort.prakticne_vezbe.resenje.napredno;

import java.util.Comparator;

public class KomparatorNaziv implements Comparator<Film> {
  @Override
  public int compare(Film o1, Film o2) {
    /*
     * Direktno poredimo nazive.
     * 
     * Ovde smo morali da koristimo getter-e zato sto se ova metoda ne nalazi unutar
     * klase Film i stoga ne moze da pristupi njenim privatnim poljima.
     */
    return o1.getNaziv().compareTo(o2.getNaziv());
  }
}
