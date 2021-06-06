package cl.hccr.arrays.newyearchaos;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'minimumBribes' function below.
   *
   * The function accepts INTEGER_ARRAY q as parameter.
   */

  public static void minimumBribes(List<Integer> q) {

    boolean chaotic = false;
    int[] array = new int[q.size() + 1];

    int indexAtMaxDiff = -1;
    int maxDiff = -1;
    for (int i = 0; i < q.size(); i++) {
      int indexAdjusted = i + 1;
      array[indexAdjusted] = q.get(i);

      int diff = array[indexAdjusted] - indexAdjusted;

      if (diff > 2) {
        chaotic = true;
        break;
      }

      int absoluteDiff = Math.abs(diff);
      if (maxDiff < absoluteDiff) {
        maxDiff = absoluteDiff;
        indexAtMaxDiff = indexAdjusted;
      }
    }

    if (chaotic) {
      System.out.println("Too chaotic");
    } else {
      int swaps = orderArray(array);
      System.out.println(swaps);
    }
  }

  private static int orderArray(int[] data){
    int indexToFix = getIndexWithMaxDiff(data);
    int swapsCount = 0;
    while (indexToFix > 0){
      int diff = data[indexToFix] - indexToFix;

      if(diff>0){
        moveToRight(diff, indexToFix, data);
        swapsCount +=diff;
      }else if(diff<0){
        moveToLeft(-diff, indexToFix, data);
        swapsCount += -diff;
      }
      indexToFix = getIndexWithMaxDiff(data);
    }
    return swapsCount;
  }

  private static int getIndexWithMaxDiff(int[] data){
    int indexAtMaxDiff = -1;
    int maxDiff = -1;

    for (int i = 1; i <data.length; i++) {
      if(data[i] != i){
        int diff = Math.abs(data[i] - i);
        if(diff>maxDiff){
          maxDiff = diff;
          indexAtMaxDiff = i;
        }
      }
    }

    return indexAtMaxDiff;
  }

  private static void moveToLeft(int times, int indexToMove, int[] data) {
    while (times-- > 0) {
      int valueOriginal = data[indexToMove];
      int valueToSwap = data[indexToMove - 1];
      data[indexToMove] = valueToSwap;
      data[indexToMove - 1] = valueOriginal;
      indexToMove--;
    }
  }
  private static void moveToRight(int times, int indexToMove, int[] data) {
    while (times-- > 0) {
      int valueOriginal = data[indexToMove];
      int valueToSwap = data[indexToMove + 1];
      data[indexToMove] = valueToSwap;
      data[indexToMove + 1] = valueOriginal;
      indexToMove++;
    }
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t)
        .forEach(
            tItr -> {
              try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q =
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result.minimumBribes(q);
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
  }
}
