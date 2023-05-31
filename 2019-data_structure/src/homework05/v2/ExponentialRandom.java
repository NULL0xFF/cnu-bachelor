package homework05.v2;

import java.util.Random;

public class ExponentialRandom extends Random {

  private static final long serialVersionUID = 1L;
  private final double mean;

  public ExponentialRandom(double mean) {
    super(System.currentTimeMillis());
    this.mean = mean;
  }

  @Override
  public double nextDouble() {
    return (-mean * Math.log(1.0 - super.nextDouble()));
  }

  @Override
  public int nextInt() {
    return ((int) Math.ceil(nextDouble()));
  }
}
