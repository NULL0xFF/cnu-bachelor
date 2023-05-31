package lab09.practice01;

public class Log2 {

  public static void main(String[] args) {
    int i = 8;
    double r = Math.log(i);

    System.out.format("log(" + "%d" + ")은 " + "%+020.10f" + "입니다.%n", i, r);
  }
}
