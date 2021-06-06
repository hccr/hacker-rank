package cl.hccr.dictionariesandhashmaps.twostrings;

import cl.hccr.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.IntStream;

class ResultTest extends BaseTest {

  @Test
  void twoStrings() throws IOException {
    BufferedReader bufferedReader = getBufferedReaderFromFile("twoStringsTest4.txt");
    StringBuilder sb = new StringBuilder();

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q)
        .forEach(
            qItr -> {
              try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = Result.twoStrings(s1, s2);

                sb.append(result);
                sb.append("\n");
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();

    String expectedResult = "NO\n" +
            "NO\n" +
            "YES\n" +
            "NO\n" +
            "NO\n" +
            "YES\n" +
            "NO\n" +
            "NO\n" +
            "YES\n" +
            "NO\n";

      Assertions.assertEquals(expectedResult, sb.toString());
  }
}
