package cl.hccr.dictionariesandhashmaps.twostrings;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class Result {

  /*
   * Complete the 'twoStrings' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. STRING s1
   *  2. STRING s2
   */

  public static String twoStrings(String s1, String s2) {
    boolean result;
    if (s1.length() > s2.length()) {
      result = compareBySet(s2, s1);
      //result = compareByChar(s2, s1);
    } else {
      result = compareBySet(s2, s1);
      //result = compareByChar(s2, s1);
    }
    return result ? "YES" : "NO";
  }

  private static boolean compareByChar(String smallestString, String biggestString) {
    char[] chars = smallestString.toCharArray();
    boolean contains = false;
    for (char c : chars) {
      if (biggestString.indexOf(c) > -1) {
        contains = true;
        break;
      }
    }
    return contains;
  }

  private static boolean compareBySet(String smallestString, String biggestString){
    char[] smallestCharArray = smallestString.toCharArray();
    char[] biggestCharArray = biggestString.toCharArray();
    Set<Character> characterSet = new HashSet<>();
    for (char c : biggestCharArray) {
      characterSet.add(c);
    }
    for (char c:smallestCharArray){
      if(characterSet.contains(c)){
        return true;
      }
    }
    return false;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q)
        .forEach(
            qItr -> {
              try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = Result.twoStrings(s1, s2);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
