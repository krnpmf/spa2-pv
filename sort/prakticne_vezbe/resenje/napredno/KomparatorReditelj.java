package sort.prakticne_vezbe.resenje.napredno;

import java.util.Comparator;

public class KomparatorReditelj implements Comparator<Film> {
  @Override
  public int compare(Film o1, Film o2) {
    // Direktno poredimo nazive
    return o1.getReditelj().compareTo(o2.getReditelj());
  }
}
