package homework09.login;

import java.util.Scanner;

public class LoginTest {

  public static void main(String[] args) {

    Scanner sc = null;
    int FLAG = 0;
    while (true) {
      sc = new Scanner(System.in);
      System.out.print("로그인 하거나 ID가 없으면 회원가입하세요. (1. 로그인  2. 회원가입  3. 종료)\n>> ");
      FLAG = sc.nextInt();
      switch (FLAG) {
        case 1:
          Authentication.Login();
          break;
        case 2:
          Authentication.Register();
          break;
        case 3:
          System.out.println("종료");
          System.exit(0);
          break;
        default:
          System.out.println("잘못 입력하셨습니다.");
      }
      if (FLAG == 3) {
        break;
      }
    }
    sc.close();
  }
}
