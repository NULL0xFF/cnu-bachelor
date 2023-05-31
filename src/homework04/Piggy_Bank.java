package homework04;

import java.util.Scanner;

public class Piggy_Bank {

  private static final Scanner input = new Scanner(
      System.in); // main 함수 안에 넣게 되면 Scanner 사용 후 닫아야 하기 때문에 정적 메소드 선언을 했다

  public static void main(String[] args) {
    // Declaration
    int oneTen = 0; // 개수는 소수가 필요하지 않다
    int fiveTen = 0; // 동전을 매우 많이 가지고 있는 경우는 거의 없으므로 int 변수를 사용한다
    int oneHundred = 0;
    int fiveHundred = 0;
    int totalValue = 0; // 정수의 덧셈 식에서 소수는 필요하지 않다
    // Input
    System.out.print("10원 동전의 갯수를 입력해 주세요 : ");
    oneTen = input.nextInt(); // Scanner를 이용하여 10원 개수를 정수로 받는다
    System.out.print("50원 동전의 갯수를 입력해 주세요 : ");
    fiveTen = input.nextInt(); // Scanner를 이용하여 50원 개수를 정수로 받는다
    System.out.print("100원 동전의 갯수를 입력해 주세요 : ");
    oneHundred = input.nextInt(); // Scanner를 이용하여 100원 개수를 정수로 받는다
    System.out.print("500원 동전의 갯수를 입력해 주세요 : ");
    fiveHundred = input.nextInt(); // Scanner를 이용하여 500원 개수를 정수로 받는다
    // Calculation
    totalValue = oneTen * 10 + fiveTen * 50 + oneHundred * 100 + fiveHundred * 500;
    // Output
    System.out.printf("저금통에 들어있는 10원 동전 %d개, 50원 동전 %d개, 100원 동전 %d개, 500원 동전 %d개의 총 금액은 %d원 입니다",
        oneTen, fiveTen, oneHundred, fiveHundred, totalValue);
  }
}