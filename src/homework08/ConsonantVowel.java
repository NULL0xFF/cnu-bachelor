package homework08;

import java.util.Scanner;

/**
 * 사용자로부터 입력받은 영어 문자열로부터 모음과 자음의 개수를 출력해주는 프로그램을 만들어보자.
 * <p>
 * 예를 들어, “Happy”는 모음은 1개이고 자음은 4개이다.
 * <p>
 * “9Ball_Game”의 경우 모음은 3개, 자음은 5개이다.
 * <p>
 * 대소문자 구분없이 특정 알파벳을 식별하기 위해서는 String 클래스의 toLowerCase() 메소드를 사용한다.
 * <p>
 * (이 메 소드는 문자열의 대문자를 소문자로 바꾸어 반환한다.)
 * <p>
 * console
 * <p>
 * 문자열 입력 >> Infinity War
 * <p>
 * 모음의 개수: 4
 * <p>
 * 자음의 개수: 7
 *
 * @author JiMyoungHa
 * @version 2.0
 */
public class ConsonantVowel {

  private static final Scanner io_scanner = new Scanner(System.in);

  /**
   * checkABC(input)
   * <p>
   * input의 문자열의 길이를 측정 후, for 문과 charAt 을 이용하여 자음과 모음의 개수를 구한다
   *
   * @param input
   */
  private static void checkABC(String input) {
    int consonantNum = 0; // 자음의 개수 변수 초기화
    int vowelNum = 0; // 모음의 개수 변수 초기화
    int inputLength = input.length(); // 입력된 문자열의 길이 변수
    for (int n = inputLength; n > 0; n--) {
      char frontChar = input.charAt(n - 1); // (n-1)번째의 문자를 확인
      /*
       * frontChar 가 알파벳 소문자일 경우, switch 문을 통해 자음과 모음의 개수를 정한다
       */
      if (frontChar >= 'a' && frontChar <= 'z') {
        switch (frontChar) {
          case 'a':
          case 'e':
          case 'i':
          case 'o':
          case 'u':
            vowelNum++;
            break;
          default:
            consonantNum++;
        }
      }
    }
    System.out.printf("모음의 개수: %d\n", vowelNum);
    System.out.printf("자음의 개수: %d\n", consonantNum);
  }

  public static void main(String[] args) {
    System.out.print("문자열 입력 >> ");
    String input = io_scanner.nextLine();
    input = input.toLowerCase();
    checkABC(input);
  }
}
