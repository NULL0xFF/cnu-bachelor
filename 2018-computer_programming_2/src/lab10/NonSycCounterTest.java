package lab10;

public class NonSycCounterTest {

  public static void main(String[] args) throws InterruptedException {
    Counter c = new Counter();
    Runnable increment = new Runnable() {
      public void run() {
        for (int i = 0; i < 10000; i++) {
          c.increment();
        }
      }
    };
    Runnable decrement = new Runnable() {
      public void run() {
        for (int i = 0; i < 10000; i++) {
          c.decrement();
        }
      }
    };

    Thread t1 = new Thread(increment);
    Thread t2 = new Thread(decrement);
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println("value: " + c.getValue());
  }

}

class Counter {

  private int value = 0;

  public synchronized void increment() {
    value++;
  }

  public synchronized void decrement() {
    value--;
  }

  public int getValue() {
    return value;
  }
}
