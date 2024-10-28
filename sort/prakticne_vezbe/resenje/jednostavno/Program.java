package sort.prakticne_vezbe.resenje.jednostavno;

import java.util.Arrays;
import java.util.Comparator;

import org.svetovid.Svetovid;

public class Program {
  public static void main(String[] args) {
    String fajl = Svetovid.in.readLine("Unesite naziv fajla:");
    Film[] filmovi = ucitaj(fajl);

    if (filmovi == null) {
      return;
    }

    String metod = Svetovid.in.readLine("Unesite metod za sortiranje:");
    String komparator = Svetovid.in.readLine("Unesite nacin poredjenja:");

    if (metod.equals("arrays")) {
      if (komparator.equals("prirodni"))
        Arrays.sort(filmovi);
      else if (komparator.equals("naziv"))
        Arrays.sort(filmovi, new KomparatorNaziv());
      else if (komparator.equals("reditelj"))
        Arrays.sort(filmovi, new KomparatorReditelj());
      else if (komparator.equals("reditelj naziv"))
        Arrays.sort(filmovi, new KomparatorRediteljNaziv());
      else {
        System.out.println("Komparator nije ispravan!");
        return;
      }
    } else if (metod.equals("insertion")) {
      if (komparator.equals("naziv"))
        insertionSort(filmovi, new KomparatorNaziv());
      else if (komparator.equals("reditelj"))
        insertionSort(filmovi, new KomparatorReditelj());
      else if (komparator.equals("reditelj naziv"))
        insertionSort(filmovi, new KomparatorRediteljNaziv());
      else {
        System.out.println("Komparator nije ispravan!");
        return;
      }
    } else if (metod.equals("selection")) {
      if (komparator.equals("naziv"))
        selectionSort(filmovi, new KomparatorNaziv());
      else if (komparator.equals("reditelj"))
        selectionSort(filmovi, new KomparatorReditelj());
      else if (komparator.equals("reditelj naziv"))
        selectionSort(filmovi, new KomparatorRediteljNaziv());
      else {
        System.out.println("Komparator nije ispravan!");
        return;
      }
    } else if (metod.equals("exchange")) {
      if (komparator.equals("naziv"))
        exchangeSort(filmovi, new KomparatorNaziv());
      else if (komparator.equals("reditelj"))
        exchangeSort(filmovi, new KomparatorReditelj());
      else if (komparator.equals("reditelj naziv"))
        exchangeSort(filmovi, new KomparatorRediteljNaziv());
      else {
        System.out.println("Komparator nije ispravan!");
        return;
      }
    } else {
      System.out.println("Metod za sortiranje nije ispravan!");
      return;
    }

    fajl = Svetovid.in.readLine("Unesite naziv fajla za ispis:");
    ispisi(filmovi, fajl);
  }

  private static Film[] ucitaj(String fajl) {
    if (Svetovid.testIn(fajl) == false) {
      return null;
    }

    int n = Svetovid.in(fajl).readInt();
    Film[] filmovi = new Film[n];

    for (int i = 0; i < n; i++) {
      int id = Svetovid.in(fajl).readInt();
      String naziv = Svetovid.in(fajl).readLine();
      String reditelj = Svetovid.in(fajl).readLine();
      filmovi[i] = new Film(id, naziv, reditelj);
    }

    Svetovid.in(fajl).close();

    return filmovi;
  }

  private static void ispisi(Film[] arr, String fajl) {
    if (Svetovid.testOut(fajl) == false) {
      System.out.println("Nije moguce ispisati u navedeni fajl!");
    }

    Svetovid.out(fajl).println(arr.length);

    for (int i = 0; i < arr.length; i++) {
      Svetovid.out(fajl).println(arr[i].getId());
      Svetovid.out(fajl).println(arr[i].getNaziv());
      Svetovid.out(fajl).println(arr[i].getReditelj());
    }

    Svetovid.out(fajl).close();
  }

  private static void insertionSort(Film[] arr, Comparator<Film> c) {
    for (int i = 1; i < arr.length; i++) {
      Film key = arr[i];
      int j = i - 1;

      while (j >= 0 && c.compare(arr[j], key) > 0) {
        arr[j + 1] = arr[j];
        j = j - 1;
      }
      arr[j + 1] = key;
    }
  }

  private static void selectionSort(Film[] arr, Comparator<Film> c) {
    for (int i = 0; i < arr.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (c.compare(arr[j], arr[minIndex]) < 0) {
          minIndex = j;
        }
      }
      Film temp = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = temp;
    }
  }

  private static void exchangeSort(Film[] arr, Comparator<Film> c) {
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (c.compare(arr[i], arr[j]) > 0) {
          Film temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }
}

class Film implements Comparable<Film> {
  private int id;
  private String naziv;
  private String reditelj;

  public Film(int id, String naziv, String reditelj) {
    this.id = id;
    this.naziv = naziv;
    this.reditelj = reditelj;
  }

  public int getId() {
    return id;
  }

  public String getNaziv() {
    return naziv;
  }

  public String getReditelj() {
    return reditelj;
  }

  @Override
  public int compareTo(Film o) {
    /*
     * Ovde nismo morali da koristimo getter zato sto je metoda implementirana u
     * klasi film.
     * 
     * Da je metoda implementirana izvan klase film, ne bi mogli da pristupamo polju
     * direktno posto je private (vidljivo samo iz klase Film) vec bi morali da
     * koristimo getter.
     */

    return this.id - o.id;
  }
}

class KomparatorNaziv implements Comparator<Film> {
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

class KomparatorReditelj implements Comparator<Film> {
  @Override
  public int compare(Film o1, Film o2) {
    // Direktno poredimo nazive
    return o1.getReditelj().compareTo(o2.getReditelj());
  }
}

class KomparatorRediteljNaziv implements Comparator<Film> {
  @Override
  public int compare(Film o1, Film o2) {
    // Poredimo po prvom navedenom polju
    int rezultat = o1.getReditelj().compareTo(o2.getReditelj());

    // Ukoliko dva filma nisu jednaka po prvom polju, vracamo rezultat poredjenja
    if (rezultat != 0) {
      return rezultat;
    }

    // Poredimo po drugom navedenom polju
    rezultat = o1.getNaziv().compareTo(o2.getNaziv());

    // Ukoliko dva filma nisu jednaka po drugom polju, vracamo rezultat poredjenja
    if (rezultat != 0) {
      return rezultat;
    }

    // Ukoliko su bili jednaki po svakom polju, onda su dva filma jednaka
    return 0;
  }
}
