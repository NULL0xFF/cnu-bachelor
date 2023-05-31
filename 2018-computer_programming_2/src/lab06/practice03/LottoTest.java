package lab06.practice03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LottoTest {

  public static void main(String[] args) {
    Lotto myLotto = new Lotto();
    System.out.println("당첨 번호: " + myLotto.getPrize());
  }
}

class Lotto {

  private List<Integer> lottoBalls;
  private List<Integer> prizeNumber;

  public Lotto() {
    lottoBalls = new LinkedList<>();
    prizeNumber = new ArrayList<>(6);
    for (int i = 1; i <= 45; i++) {
      lottoBalls.add(i);
    }
    Collections.shuffle(lottoBalls);
    for (int i = 0; i < 6; i++) {
      prizeNumber.add(lottoBalls.get(i));
    }
  }

  @SuppressWarnings("rawtypes")
  public List getPrize() {
    Collections.sort(this.prizeNumber);
    return this.prizeNumber;
  }
}