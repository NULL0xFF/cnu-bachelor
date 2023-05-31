package homework06;

import java.util.Scanner;

/**
 * Day of the Week (요일)
 *
 * @author 201802065김세빈, 201802115안효건, 201802162지명하
 * @version 1.2-public
 */
public class DotW {

  // Global Declaration
  private static final int[] date = {0, 0, 0}; // 입력된 날짜의 (연, 월, 일)Array
  private static final Scanner input = new Scanner(System.in);
  private static int days = 0; // 총 일수

  // Custom Methods

  /**
   * 입력 연도가 윤년인지 아닌지 확인하는 메소드
   * <p>
   * 조건:
   * <p>
   * 윤년은 4의 배수이어야 한다 (LeapYear == 4의 배수)
   * <p>
   * 윤년은 100의 배수가 아니어야 한다 (LeapYear != 100의 배수)
   * <p>
   * 400의 배수는 "무조건" 윤년이 된다 (LeapYear == 400의 배수)
   * <p>
   * 출력:
   * <p>
   * 윤년일 경우: return true
   * <p>
   * 윤년이 아닐 경우: return false
   */
  private static boolean leapyear_boolean(int input_year) {
    // Declaration
    int fourMultiplier_int; // 4의 배수
    int oneHundredMultiplier_int; // 100의 배수
    int fourHundredMultiplier_int; // 400의 배수
    // Calculation
    fourMultiplier_int = input_year % 4; // 4의 배수를 나머지로 판단
    oneHundredMultiplier_int = input_year % 100; // 100의 배수를 나머지로 판단
    fourHundredMultiplier_int = input_year % 400; // 400의 배수를 나머지로 판단
    // Output
    if (fourHundredMultiplier_int == 0) {
      return true;
    } else {
      return fourMultiplier_int == 0 && oneHundredMultiplier_int != 0;
    }
  }

  /**
   * 광역 변수 data에 연, 월, 일을 입력하는 메소드
   * <p>
   * 메소드를 call 하면, int[] date에 입력값을 넣는다
   */
  private static void input_date() {
    // Declaration
    int input_year = 0;
    int input_month = 0;
    int input_day = 0;
    // Input
    System.out.print("연도를 입력하세요: ");
    input_year = input.nextInt();
    System.out.print("월을 입력하세요: ");
    input_month = input.nextInt();
    System.out.print("일을 입력하세요: ");
    input_day = input.nextInt();
    // Output to Global Variable
    date[0] = input_year;
    date[1] = input_month;
    date[2] = input_day;
  }

  /**
   * 월, 일 값의 유효성 확인 메서드
   */
  private static boolean input_test() {
    // 입력된 월에 대한 switch
    switch (date[1]) {
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
        // 입력된 일에 대한 유효성 판단
        return date[2] >= 1 && date[2] <= 31;
      case 2:
        // 2월일 경우, 윤년인지 확인
        if (leapyear_boolean(date[2])) {
          // 윤년일 경우, 입력된 일에 대한 유효성 판단
          return date[2] >= 1 && date[2] <= 29;
        } else {
          // 윤년이 아닐 경우, 입력된 일에 대한 유효성 판단
          return date[2] >= 1 && date[2] <= 28;
        }
      case 4:
      case 6:
      case 9:
      case 11:
        // 입력된 일에 대한 유효성 판단
        return date[2] >= 1 && date[2] <= 30;
      default:
        return false;
    }
  }

  /**
   * 1900/1/1 부터의 총 일수를 계산하고 광역 변수 days에 입력하는 메서드
   */
  private static void input_days() {
    days = 0; // Reset variables named days
    for (int n = date[0] - 1900; n > 0; n--) {
      if (leapyear_boolean(n + 1899)) {
        days = days + 366;
      } else {
        days = days + 365;
      }
    }
    for (int n = date[1] - 1; n > 0; n--) {
      switch (n) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
          days = days + 31;
          break;
        case 2:
          if (leapyear_boolean(date[0])) {
            days = days + 29;
          } else {
            days = days + 28;
          }
          break;
        case 4:
        case 6:
        case 9:
        case 11:
          days = days + 30;
          break;
      }
    }
    days = days + date[2];
  }

  /**
   * 요일 판별기
   */
  private static String day_string() {
    switch (days % 7) {
      case 0:
        return "일요일";
      case 1:
        return "월요일";
      case 2:
        return "화요일";
      case 3:
        return "수요일";
      case 4:
        return "목요일";
      case 5:
        return "금요일";
      case 6:
        return "토요일";
      default:
        return "ERROR";
    }
  }

  // Main Method
  public static void main(String[] args) {
    // Call Method
    input_date();
    // Algorithm Distinguisher - 입력 값의 유효성 판단
    // 유효할 경우, input_days 메소드를 call 하여 총 일수를 계산한다
    if (date[0] <= 0) {
      System.out.println("입력이 잘못되었습니다.");
    } else if ((date[0] < 1900) || (date[0] == 1900 && date[1] <= 2) || (date[0] == 2100
        && date[1] >= 3)
        || (date[0] > 2100)) {
      System.out.println("알고리즘을 사용할 수 없습니다.");
    } else {
      if (input_test()) {
        input_days();
        System.out.printf("%d년 %d월 %d일은 %s입니다.\n", date[0], date[1], date[2], day_string());
      } else {
        System.out.println("입력이 잘못되었습니다.");
      }
    }
  }
}
