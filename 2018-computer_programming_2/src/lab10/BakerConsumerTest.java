package lab10;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BakerConsumerTest {

  public static void main(String[] args) {
    Table table = new Table();
    (new Thread(new Baker(table))).start();
    (new Thread(new Consumer(table))).start();
  }

}

class Table {

  private ReentrantLock block = new ReentrantLock();
  private Condition blockCondi;
  private int cake;
  private boolean empty = true;

  public Table() {
    blockCondi = block.newCondition();
  }

  public int get() throws InterruptedException {
    block.lock();
    try {
      while (empty) {
        blockCondi.await();
      }
      empty = true;
      blockCondi.signal();
      return cake;
    } finally {
      block.unlock();
    }
  }

  public void put(int cake) throws InterruptedException {
    block.lock();
    try {
      while (!empty) {
        blockCondi.await();
      }
      this.cake = cake;
      empty = false;
      blockCondi.signal();
    } finally {
      block.unlock();
    }
  }
}

class Baker implements Runnable {

  private Table table;

  public Baker(Table table) {
    this.table = table;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      try {
        table.put(i);
        System.out.println("제빵사: " + i + "번 케익을 생산하였습니다.");
        Thread.sleep((int) (Math.random() * 1000.0));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class Consumer implements Runnable {

  private Table table;

  public Consumer(Table drop) {
    this.table = drop;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      try {
        int cake = table.get();
        System.out.println("소비자: " + cake + "번 케익을 소비하였습니다.");
        Thread.sleep((int) (Math.random() * 1000.0));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
