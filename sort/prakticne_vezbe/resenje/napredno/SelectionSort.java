package sort.prakticne_vezbe.resenje.napredno;

import java.util.Comparator;

public class SelectionSort implements Sorter {
  @Override
  public void sort(Film[] arr) {
    this.sort(arr, Comparator.naturalOrder());
  }

  @Override
  public void sort(Film[] arr, Comparator<Film> c) {
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
}
