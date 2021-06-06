package cl.hccr.arrays.minimumswaps2;

import cl.hccr.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class SolutionTest extends BaseTest {

  @Test
  void minimumSwapsTest1() {
    Assertions.assertEquals(3, Solution.minimumSwaps(new int[] {4, 3, 1, 2}));
  }

  @Test
  void minimumSwapsTest2() {
    String fileName = "test.txt";
    Scanner scanner = getScannerFromFile(fileName);

    int n = scanner.nextInt();
    scanner.nextLine();
    int[] data = new int[n];

    for (int i = 0; i < n; i++) {
      data[i] = scanner.nextInt();
    }
    scanner.close();
    Assertions.assertEquals(99987, Solution.minimumSwaps(data));
  }
}
