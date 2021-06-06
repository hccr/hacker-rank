package cl.hccr;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BaseTest {

  protected InputStream getInputStreamFromFile(String fileName) {
    ClassLoader classLoader = getClass().getClassLoader();
    return classLoader.getResourceAsStream(fileName);
  }

  protected Scanner getScannerFromFile(String fileName) {
    return new Scanner(getInputStreamFromFile(fileName));
  }

  protected BufferedReader getBufferedReaderFromFile(String fileName) {
    return new BufferedReader(new InputStreamReader(getInputStreamFromFile(fileName)));
  }
}
