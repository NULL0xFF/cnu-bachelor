package homework03;

public class BigIntTest {

  public static void main(String[] args) {
    BigInt x = new BigInt(13579);
    System.out.printf("%s\n", x);
    BigInt y = new BigInt("75313579");
    System.out.printf("%s\n", y);
    System.out.printf("%s\n", x.compareMe(y));
    System.out.printf("%s\n", x.multiple(4));
  }
}
