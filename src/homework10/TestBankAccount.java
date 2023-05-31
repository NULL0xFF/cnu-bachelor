package homework10;

import java.util.Scanner;

public class TestBankAccount {

  public static void main(String[] args) {
    Scanner io_scanner = new Scanner(System.in);
    String owner = "";
    String accountNumber = "";
    int balance;

    owner = "";
    accountNumber = "";
    balance = 0;

    System.out.print("첫 번째 고객의 정보를 입력하세요.\n");
    System.out.print("예금주: ");
    owner = io_scanner.next();
    System.out.print("계좌 번호: ");
    accountNumber = io_scanner.next();
    System.out.print("초기 금액: ");
    balance = io_scanner.nextInt();

    BankAccount my_acct = new BankAccount(owner, accountNumber);
    my_acct.deposit(balance);

    owner = "";
    accountNumber = "";
    balance = 0;

    System.out.print("\n");

    System.out.print("두 번째 고객의 정보를 입력하세요.\n");
    System.out.print("예금주: ");
    owner = io_scanner.next();
    System.out.print("계좌 번호: ");
    accountNumber = io_scanner.next();
    System.out.print("초기 금액: ");
    balance = io_scanner.nextInt();

    BankAccount your_acct = new BankAccount(owner, accountNumber);
    your_acct.deposit(balance);

    balance = 0;

    System.out.print("\n");

    System.out.print("첫 번째 계좌에서 두 번쨰 계좌로 송금할 금액: ");
    balance = io_scanner.nextInt();
    if (my_acct.transfer(balance, your_acct)) {
      System.out.print("송금 완료\n");
    } else {
      System.out.print("잔액 부족\n");
    }

    System.out.print("\n");

    System.out.printf("첫 번째 계좌의 정보: %s\n", my_acct);
    System.out.printf("두 번째 계좌의 정보: %s", your_acct);

    io_scanner.close();
  }
}
