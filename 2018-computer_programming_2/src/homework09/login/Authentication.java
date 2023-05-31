package homework09.login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Authentication {

  private static Scanner sc = new Scanner(System.in);

  public static void Login() {
    Identification userDB = null;
    String userName;
    String userPW;
    byte FLAG = 0;
    do {
      try {
        System.out.print("ID를 입력하세요. (1. 처음으로  2. 종료)\n>> ");
        userName = sc.next();
        if (userName.equals("1")) {
          return;
        } else if (userName.equals("2")) {
          System.out.println("종료");
          System.exit(0);
        }
        userDB = (Identification) DatabaseIO.Input(userName);
        System.out.print("비밀번호를 입력하세요\n>> ");
        userPW = SHA256.encrypt(sc.next());
        if (!(userPW).equals(userDB.getUserPW())) {
          FLAG = 5;
          System.out.println("잘못된 비밀번호입니다.");
        } else {
          FLAG = 0;
          System.out.println("로그인 되었습니다.");
          do {
            System.out.print("1. 비밀번호 수정  2. 종료\n>> ");
            String inputFLAG = sc.next();
            if (inputFLAG.equals("1")) {
              do {
                System.out.print("본인의 ID를 한번 더 입력하세요\n>> ");
                if (!userDB.getUserName().equals(sc.next())) {
                  FLAG = 6;
                  System.out.println("ID가 일치하지 않습니다.");
                } else {
                  System.out.print("비밀번호를 입력하세요\n>> ");
                  if (!userDB.getUserPW().equals(SHA256.encrypt(sc.next()))) {
                    FLAG = 7;
                    System.out.println("잘못된 비밀번호입니다.");
                  } else {
                    FLAG = 0;
                  }
                }
              } while (FLAG != 0);
              Identification.ChangePW(userDB);
            } else if (inputFLAG.equals("2")) {
              System.out.println("종료");
              System.exit(0);
            }
          } while (FLAG != 0);
        }
      } catch (FileNotFoundException e) {
        FLAG = 1;
        System.out.println("존재하지 않는 아이디 입니다.");
      } catch (ClassNotFoundException e) {
        FLAG = 2;
        System.out.println(e.getMessage());
      } catch (NullPointerException e) {
        FLAG = 3;
        System.out.println(e.getMessage());
      } catch (IOException e) {
        FLAG = 4;
        System.out.println(e.getMessage());
      }
    } while (FLAG != 0);
  }

  public static void Register() {
    Identification newUser;
    @SuppressWarnings("unused")
    Identification userDB;
    String newName;
    String newPW;
    byte FLAG = 0;
    do {
      System.out.print("새로운 ID를 입력하세요\n>> ");
      newName = sc.next();
      try {
        userDB = (Identification) DatabaseIO.Input(newName);
        System.out.println("존재하는 ID입니다.");
        FLAG = 4;
      } catch (FileNotFoundException e) {
        FLAG = 0;
      } catch (ClassNotFoundException e) {
        FLAG = 1;
        e.printStackTrace();
      } catch (NullPointerException e) {
        FLAG = 2;
        e.printStackTrace();
      } catch (IOException e) {
        FLAG = 3;
        e.printStackTrace();
      }
    } while (FLAG != 0);
    System.out.print("비밀번호를 입력하세요\n>> ");
    newPW = SHA256.encrypt(sc.next());
    newUser = new Identification(newName, newPW);
    try {
      DatabaseIO.Output((Object) newUser, newName);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
