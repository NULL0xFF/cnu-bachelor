package lab09.practice01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScanTest {

  public static void main(String[] args) throws IOException {
    Scanner s = null;

    try {
      s = new Scanner(new BufferedReader(new FileReader("res/lab09/practice01/input.txt")));

      while (s.hasNext()) {
        System.out.println(s.next());
      }
    } finally {
      if (s != null) {
        s.close();
      }
    }
  }
}
