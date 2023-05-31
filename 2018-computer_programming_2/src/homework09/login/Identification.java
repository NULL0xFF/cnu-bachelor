package homework09.login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Identification implements Serializable {

  private static final long serialVersionUID = 1L;
  private static Scanner sc = new Scanner(System.in);
  private String userName;
  private String userPW;

  public Identification(String userName, String userPW) {
    this.userName = userName;
    this.userPW = userPW;
  }

  public static void ChangePW(Identification userID) {
    System.out.print("새로운 비밀번호를 입력하세요\n>> ");
    userID.setUserPW(SHA256.encrypt(sc.next()));
    try {
      DatabaseIO.Output((Object) userID, userID.getUserName());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String getUserName() {
    return this.userName;
  }

  public String getUserPW() {
    return this.userPW;
  }

  public void setUserPW(String newPW) {
    this.userPW = newPW;
  }
}
