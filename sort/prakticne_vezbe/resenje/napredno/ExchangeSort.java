package sort.prakticne_vezbe.resenje.napredno;

import java.util.Comparator;

public class ExchangeSort implements Sorter {
  @Override
  public void sort(Film[] arr) {
    this.sort(arr, Comparator.naturalOrder());
  }

  @Override
  public void sort(Film[] arr, Comparator<Film> c) {
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
