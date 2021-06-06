package cl.hccr.dictionariesandhashmaps.ransomnote;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'checkMagazine' function below.
   *
   * The function accepts following parameters:
   *  1. STRING_ARRAY magazine
   *  2. STRING_ARRAY note
   */

  public static void checkMagazine(List<String> magazine, List<String> note) {
    Map<String, Integer> mapsOfWords = new HashMap<>();

    for (String word : magazine) {
      if (mapsOfWords.containsKey(word)) {
        int count = mapsOfWords.get(word) + 1;
        mapsOfWords.put(word, count);
      } else {
        mapsOfWords.put(word, 1);
      }
    }

    boolean canIWrite = true;
    for (String word : note) {
      if (!mapsOfWords.containsKey(word)) {
        canIWrite = false;
        break;
      } else {
        int wordCount = mapsOfWords.get(word) - 1;

        if (wordCount <= 0) {
          mapsOfWords.remove(word);
        } else {
          mapsOfWords.put(word, wordCount);
        }
      }
    }

    if (canIWrite) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int m = Integer.parseInt(firstMultipleInput[0]);

    int n = Integer.parseInt(firstMultipleInput[1]);

    List<String> magazine =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).collect(toList());

    List<String> note =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).collect(toList());

    Result.checkMagazine(magazine, note);

    bufferedReader.close();
  }
}
