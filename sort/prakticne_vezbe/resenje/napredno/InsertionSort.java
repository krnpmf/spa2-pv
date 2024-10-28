package sort.prakticne_vezbe.resenje.napredno;

import java.util.Comparator;

public class InsertionSort implements Sorter {
  @Override
  public void sort(Film[] arr) {
    this.sort(arr, Comparator.naturalOrder());
  }

  @Override
  public void sort(Film[] arr, Comparator<Film> c) {
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
}
