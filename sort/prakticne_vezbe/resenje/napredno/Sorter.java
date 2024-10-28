package sort.prakticne_vezbe.resenje.napredno;

import java.util.Comparator;

public interface Sorter {
  public void sort(Film[] arr);

  public void sort(Film[] arr, Comparator<Film> c);
}
