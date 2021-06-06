package cl.hccr.dictionariesandhashmaps.frecuencyqueries;

import cl.hccr.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest extends BaseTest {

  @Test
  void freqQueryTest0() throws IOException {
      List<Integer> respuesta = Solution.freqQuery(getQueriesByFileName("frequency_queries/sampleInput0.txt"));
      List<Integer> expected = Arrays.asList(new Integer[]{0, 1});
      Assertions.assertEquals(expected, respuesta);
  }

    @Test
    void freqQueryTest1() throws IOException {
        List<Integer> respuesta = Solution.freqQuery(getQueriesByFileName("frequency_queries/sampleInput1.txt"));
        List<Integer> expected = Arrays.asList(new Integer[]{0, 1});
        Assertions.assertEquals(expected, respuesta);
    }
    @Test
    void freqQueryTest2() throws IOException {
        List<Integer> respuesta = Solution.freqQuery(getQueriesByFileName("frequency_queries/sampleInput2.txt"));
        List<Integer> expected = Arrays.asList(new Integer[]{0, 1, 1});
        Assertions.assertEquals(expected, respuesta);
    }

    @Test
    void freqQueryTest8() throws IOException {
        List<Integer> respuesta = Solution.freqQuery(getQueriesByFileName("frequency_queries/inputTest8.txt"));
        List<Integer> expected = getExpectedResultByFileName("frequency_queries/outputTest8.txt");
        Assertions.assertEquals(expected, respuesta);
    }

  private List<List<Integer>> getQueriesByFileName(String fileName) throws IOException {
    BufferedReader bufferedReader = getBufferedReaderFromFile(fileName);

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<Integer>> queries = new ArrayList<>();

    IntStream.range(0, q)
        .forEach(
            i -> {
              try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList()));
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    return queries;
  }
  private List<Integer> getExpectedResultByFileName(String fileName){
      Scanner scanner = getScannerFromFile(fileName);
      String line ;
      List<Integer> expectedResult = new ArrayList<>();
      while (scanner.hasNext() && !(line = scanner.nextLine()).trim().isEmpty()){
          expectedResult.add(Integer.parseInt(line));
      }
      return expectedResult;
  }
}
