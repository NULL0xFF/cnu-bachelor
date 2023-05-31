package homework09;

import java.util.Scanner;

public class TestBankAccount {

  public static void main(String[] args) {

    Scanner io_scanner = new Scanner(System.in);
    BankAccount tony_account = new BankAccount();
    BankAccount steve_account = new BankAccount();

    System.out.print("테스트 코드 실행 예시 번호를 적으세요(1, 2): ");

    switch (io_scanner.nextLine()) {
      case "1":
        /*
         * Lab09의 실행 예시 (1)
         */
        tony_account.deposit(10000);
        steve_account.deposit(500);

        tony_account.transfer(4500, steve_account);

        System.out.println("토니 계좌의 잔액: " + tony_account.getBalance());
        System.out.println("스티브 계좌의 잔액: " + steve_account.getBalance());
        break;
      case "2":
        /*
         * Lab09의 실행 예시 (2)
         */
        tony_account.deposit(-2000);
        tony_account.deposit(10000);
        tony_account.withdraw(-2000);

        steve_account.deposit(500);
        steve_account.withdraw(2000);

        tony_account.transfer(20000, steve_account);
        System.out.println("토니 계좌의 잔액: " + tony_account.getBalance());
        System.out.println("스티브 계좌의 잔액: " + steve_account.getBalance());
        break;
      default:
        System.out.println("실행을 종료합니다.");
    }

    io_scanner.close();
  }
}
