package sort.prakticne_vezbe.resenje.napredno;

import java.util.Comparator;

import org.svetovid.Svetovid;

public class Program {
  public static void main(String[] args) {
    String fajl = Svetovid.in.readLine("Unesite naziv fajla:");
    Film[] filmovi = UlazIzlaz.ucitaj(fajl);

    if (filmovi == null) {
      return;
    }

    String metod = Svetovid.in.readLine("Unesite metod za sortiranje:");
    Sorter sorter;

    switch (metod.toLowerCase()) {
      case "arrays":
        sorter = new ArraysSort();
        break;
      case "insertion":
        sorter = new InsertionSort();
        break;
      case "selection":
        sorter = new SelectionSort();
        break;
      case "exchange":
        sorter = new ExchangeSort();
        break;
      default:
        System.err.println("Odabrani metod nije ponudjen!");
        return;
    }

    String komparator = Svetovid.in.readLine("Unesite nacin poredjenja:");
    Comparator<Film> c;

    switch (komparator.toLowerCase()) {
      case "prirodni":
        c = Comparator.naturalOrder();
        break;
      case "naziv":
        c = new KomparatorNaziv();
        break;
      case "reditelj":
        c = new KomparatorReditelj();
        break;
      case "reditelj naziv":
        c = new KomparatorRediteljNaziv();
        break;
      default:
        System.err.println("Odabrani komparator nije ponudjen!");
        return;
    }

    sorter.sort(filmovi, c);

    fajl = Svetovid.in.readLine("Unesite naziv fajla za ispis:");
    UlazIzlaz.ispisi(filmovi, fajl);
  }
}
