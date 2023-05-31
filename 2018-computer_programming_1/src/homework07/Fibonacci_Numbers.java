package homework07;

import java.util.Scanner;

/**
 * Fibonacci Numbers
 * <p>
 * 피보나치 수열을 출력하는 프로그램을 만들어 보자.
 * <p>
 * n = 0일 때를 첫번째 항이라고 하고 입력한 번째의 항까지 출력하는 프로그램을 만들어보자.
 *
 * @author 201802162지명하
 * @version 1.1-submit
 */
public class Fibonacci_Numbers {

  public static void main(String[] args) {
    // Declaration
    Scanner io_scanner = new Scanner(System.in);
    int input_int = 0; // 입력 변수값 초기화
    int fn_2 = 0; // f(n-2), 초기 값은 f(0)의 값
    int fn_1 = 1; // f(n-1), 초기 값은 f(1)의 값
    int fn = 0; // f(n), 초기화
    int count = 3;
    String output_fibonacci = fn_2 + " " + fn_1;
    // Input
    do {
      System.out.print("몇번째 항까지 출력하시겠습니까?(3 이상 입력): ");
      input_int = io_scanner.nextInt();
      if (input_int >= 3) {
        break;
      } else {
        System.out.println("3 이상의 수를 입력해 주세요.");
      }
    } while (input_int < 3);
    // Calculation
    do {
      // Fibonacci Algorithm
      fn = fn_1 + fn_2;
      fn_2 = fn_1;
      fn_1 = fn;
      count++;
      output_fibonacci = output_fibonacci + " " + fn;

    } while (count != input_int + 1);
    // Output
    System.out.print(output_fibonacci);
    // End Phase
    io_scanner.close();
  }
}
