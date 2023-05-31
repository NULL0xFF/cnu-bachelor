package lab09.practice02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CaesarCipher {

  public static void main(String[] args) throws IOException {
    FileInputStream in = null;
    FileOutputStream out = null;

    try {
      in = new FileInputStream("res/lab09/practice02/original.txt");
      out = new FileOutputStream("res/lab09/practice02/cipher.txt");
      int c;
      int shift = 5;

      while ((c = in.read()) != -1) {
        if (c >= 65 && c <= 90 - shift) {
          out.write(c + shift);
        } else if (c >= 90 - shift && c <= 90) {
          out.write(c - (25 - shift));
        } else if (c >= 97 && c <= 122 - shift) {
          out.write(c - (32 - shift));
        } else if (c >= 122 - shift && c <= 122) {
          out.write(c - (57 - shift));
        } else {
          out.write(c);
        }
      }
    } finally {
      if (in != null) {
        in.close();
      }
      if (out != null) {
        out.close();
      }
    }
  }
}