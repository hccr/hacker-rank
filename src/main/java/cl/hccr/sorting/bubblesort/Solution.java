package cl.hccr.sorting.bubblesort;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'countSwaps' function below.
   *
   * The function accepts INTEGER_ARRAY a as parameter.
   */

  public static void countSwaps(List<Integer> a) {
    boolean isSorted = false;
    int swapsCount = 0;
    while (!isSorted) {
      isSorted = true;
      int lastSortedElement = a.size() - 1;

      for (int i = 0; i < lastSortedElement; i++) {
        if (a.get(i) > a.get(i + 1)) {
          swap(a, i, i + 1);
          isSorted = false;
          swapsCount++;
        }
      }
      lastSortedElement--;
    }
    System.out.printf("Array is sorted in %d swaps.\n", swapsCount);
    System.out.printf("First Element: %d\n", a.get(0));
    System.out.printf("Last Element: %d\n", a.get(a.size() - 1));
  }

  private static void swap(List<Integer> list, int a, int b) {
    int temp = list.get(a);
    list.set(a, list.get(b));
    list.set(b, temp);
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> a =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    Result.countSwaps(a);

    bufferedReader.close();
  }
}
