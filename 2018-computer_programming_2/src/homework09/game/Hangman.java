package homework09.game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

  public static void main(String[] args) {

    Scanner bufferedFileReadScanner = null;
    ArrayList<String> wordList = new ArrayList<>();
    String word = "";
    try {
      bufferedFileReadScanner = new Scanner(
          new BufferedReader(new FileReader("res/hw09/hangman.txt")));
      while (bufferedFileReadScanner.hasNext()) {
        wordList.add(bufferedFileReadScanner.next());
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } finally {
      bufferedFileReadScanner.close();
    }
    Random random = new Random();
    word = wordList.get(random.nextInt(wordList.size()));
    Scanner inputStreamScanner = new Scanner(System.in);
    int FLAG = 0;
    String inputString = "";
    StringBuilder hangWord = new StringBuilder("");
    for (int i = 0; i < word.length(); i++) {
      hangWord.append("_ ");
    }
    System.out.printf("행맨 게임!\n(제한 횟수는 %d번 입니다.)\n", (word.length() * 2));
    while (true) {
      System.out.printf("현재 상태: %s\n", hangWord);
      System.out.print("문자를 입력해 주세요(한글자): ");
      inputString = inputStreamScanner.next();
      if (inputString.length() > 1) {
        System.out.print("한글자만 입력가능합니다.\n");
      } else {
        FLAG++;
        int inputStringIndex = -1;
        while (true) {
          inputStringIndex = word.toLowerCase()
              .indexOf(inputString.toLowerCase(), inputStringIndex + 1);
          if (inputStringIndex != -1) {
            hangWord.replace(inputStringIndex * 2, inputStringIndex * 2 + 1,
                Character.toString(word.charAt(inputStringIndex)));
          } else {
            break;
          }
        }
      }
      String resultWord = hangWord.toString();
      if (resultWord.replaceAll("\\s+", "").equals(word)) {
        System.out.printf("현재 상태: %s\n", hangWord);
        System.out.print("정답을 맞췄습니다.\n");
        break;
      }
      if (FLAG >= word.length() * 2) {
        System.out.printf("정답을 맞추지 못했습니다.\n정답: %s\n", word);
        break;
      }
    }
    inputStreamScanner.close();
  }
}
