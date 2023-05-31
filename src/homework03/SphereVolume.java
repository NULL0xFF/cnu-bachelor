package homework03;

import java.util.Scanner;

public class SphereVolume {

  private static final Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    // Declaration
    String s1 = ("구의 반지름을 입력하세요 : ");
    String s2 = ("구의 부피는 %f cm^3 입니다");
    // I/O
    System.out.print(s1);
    System.out.printf(s2 + "\n", spherevol());
    // Scanner Close (End Phase)
    input.close();
  }

  private static double spherevol() {
    // Declaration
    double d1 = 0.0;
    double d2 = 0.0;
    // I/O
    d1 = input.nextDouble();
    d2 = (4.0 / 3.0) * Math.PI * Math.pow(d1, 3);
    // Return Calculated Result
    return d2;
  }
}