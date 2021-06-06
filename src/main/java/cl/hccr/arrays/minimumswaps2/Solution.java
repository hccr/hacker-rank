package cl.hccr.arrays.minimumswaps2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

  // Complete the minimumSwaps function below.
  static int minimumSwaps(int[] arr) {
    // Create an array n+1 to simplify math
    int[] array = new int[arr.length + 1];


    for (int i = 0; i < arr.length; i++) {
      int newIndex = i + 1;
      int value = arr[i];
      array[newIndex] = value;
    }

    int swapsCount = 0;
    for (int i = 1; i < array.length; i++){
      while(i != array[i]){
        int value1 = array[i];
        int value2 = array[value1];

        array[value1] = value1;
        array[i] = value2;
        swapsCount++;
      }
    }

    return swapsCount;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] arr = new int[n];

    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }

    int res = minimumSwaps(arr);

    bufferedWriter.write(String.valueOf(res));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
