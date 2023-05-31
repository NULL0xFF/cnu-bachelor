package lab09.practice01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyLines {

  public static void main(String[] args) throws IOException {

    BufferedReader inputStream = null;
    BufferedWriter outputStream = null;

    try {
      inputStream = new BufferedReader(new FileReader("res/lab09/practice01/input.txt"));
      outputStream = new BufferedWriter(new FileWriter("res/lab09/practice01/output.txt"));

      String l;

      while ((l = inputStream.readLine()) != null) {
        outputStream.write(l);
        outputStream.newLine();
      }
    } finally {
      if (inputStream != null) {
        inputStream.close();
      }
      if (outputStream != null) {
        outputStream.close();
      }
    }
  }
}
