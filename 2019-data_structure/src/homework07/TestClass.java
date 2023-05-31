package homework07;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TestClass {

  public static void main(String[] args) {
    // XXX 선언 관련
    LinearProbingTable linearTable = new LinearProbingTable(11, 0.75F);
    MidSquareSearch squareTable = new MidSquareSearch(11, 0.75F);
    DoubleHashingTable doubleTable = new DoubleHashingTable(11, 0.75F);
    try {
      BufferedReader bR = new BufferedReader(new FileReader("res/hw07/text.txt"));
      while (bR.ready()) {
        String l = bR.readLine();
        StringTokenizer p = new StringTokenizer(l, " ,:;-.?!");
        while (p.hasMoreTokens()) {
          // TODO 문자열 토큰화 후 해시 테이블에 추가 기능 구현
          String word = p.nextToken();
          if (linearTable.get(word) != null) {
            linearTable.put(word, (int) linearTable.get(word) + 1);
          } else {
            linearTable.put(word, 1);
          }
          if (squareTable.get(word) != null) {
            squareTable.put(word, (int) squareTable.get(word) + 1);
          } else {
            squareTable.put(word, 1);
          }
          if (doubleTable.get(word) != null) {
            doubleTable.put(word, (int) doubleTable.get(word) + 1);
          } else {
            doubleTable.put(word, 1);
          }
        }
      }
      bR.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      BufferedReader bR = new BufferedReader(new FileReader("res/hw07/text.txt"));
      while (bR.ready()) {
        String l = bR.readLine();
        StringTokenizer p = new StringTokenizer(l, " ,:;-.?!");
        while (p.hasMoreTokens()) {
          // TODO 문자열 토큰화 후 해시 테이블에 추가 기능 구현
          String word = p.nextToken();
          if (linearTable.get(word) != null) {
            System.out.println(word + ": " + linearTable.remove(word));
          } else {
          }
        }
      }
      bR.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
