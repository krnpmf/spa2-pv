package sort.prakticne_vezbe.resenje.napredno;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSort implements Sorter {
  @Override
  public void sort(Film[] arr) {
    Arrays.sort(arr);
  }

  @Override
  public void sort(Film[] arr, Comparator<Film> c) {
    Arrays.sort(arr, c);
  }
}
