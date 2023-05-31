package homework07;

import java.util.Scanner;

/**
 * Banking Program
 * <p>
 * 예금, 출금, 조회, 종료 기능을 제공하는 프로그램을 만들어보자.
 * <p>
 * 어떤 예외들이 있을지 생각해보고 상황에 따라 에러 메시지를 출력하고 제대로 된 입력을 다시 받도록 만들어보자.
 *
 * @author 201802162지명하
 * @version 1.2-submit
 */
public class Banking_Program {

  // Global Declaration

  private static final Scanner io_scanner = new Scanner(System.in);
  private static long balance = 0L;

  // Custom Methods

  /**
   * 은행 메뉴 메소드
   */
  private static void initial_setup() {
    System.out.print("----------------------------\n");
    System.out.print("1.예금 | 2.출금 | 3.잔고 | 4.종료\n");
    System.out.print("----------------------------\n");
    System.out.print("선택 > ");
  }

  /**
   * 은행 (1)예금 메소드
   */
  private static void deposit() {
    // Declaration
    long input_deposit = 0; // 예금 변수 초기화
    boolean input_possibility = false; // 금액의 추가 가능성 여부 (양의 정수인가)
    // Input Algorithm
    while (!input_possibility) {
      System.out.print("예금 > ");
      input_deposit = io_scanner.nextLong();
      if (input_deposit < 0) {
        // Error
        System.out.print("금액이 잘못 입력되었습니다.(음수 입력)\n");
        System.out.print("다시 입력해 주세요.\n");
        input_possibility = false;
      } else {
        // Calculation
        balance = balance + input_deposit; // 입력한 금액을 예금으로 추가
        input_possibility = true;
      }
    }
    // End Phase
  }

  /**
   * 은행 (2)출금 메소드
   */
  private static void withdraw() {
    // Declaration
    long input_withdraw = 0L; // 예금 변수 초기화
    boolean input_possibility = false; // 금액의 추가 가능성 여부 (양의 정수인가)
    // Input Algorithm
    while (!input_possibility) {
      System.out.print("출금 > ");
      input_withdraw = io_scanner.nextLong();
      if (input_withdraw < 0) {
        // Error
        System.out.print("금액이 잘못 입력되었습니다.(음수 입력)\n");
        System.out.print("다시 입력해 주세요.\n");
        input_possibility = false;
      } else {
        if (input_withdraw > balance) {
          System.out.print("잔고가 부족합니다.\n");
          System.out.print("다시 입력해 주세요.\n");
          input_possibility = false;
        } else {
          balance = balance - input_withdraw;
          input_possibility = true;
        }
      }
    }
    // End Phase
  }

  /**
   * 은행 (3)잔고 메소드
   */
  private static void balance() {
    System.out.printf("잔고 > %d\n", balance);
  }

  // Main Method
  public static void main(String[] args) {
    // Declaration
    byte input_num = 0; // 변수 초기화
    // Calculation
    while (input_num != 4) {
      // Initial Call
      initial_setup();
      // Input
      input_num = io_scanner.nextByte();
      switch (input_num) {
        case 1:
          deposit();
          break;
        case 2:
          withdraw();
          break;
        case 3:
          balance();
          break;
        case 4:
          break;
        default:
          System.out.print("잘못된 입력입니다.\n");
          break;
      }
    }
    // End Phase
    System.out.print("프로그램 종료\n");
    io_scanner.close();
  }
}
