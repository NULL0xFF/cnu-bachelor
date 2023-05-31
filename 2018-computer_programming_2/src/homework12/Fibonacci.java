package homework12;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Fibonacci {

  public static void main(String[] args) throws InterruptedException {
    Scanner systemInputStream = new Scanner(System.in);
    System.out.printf("Fibonacci n th number\n");
    int n = -1;
    while (n < 0) {
      try {
        System.out.printf(">> ");
        n = systemInputStream.nextInt();
      } catch (InputMismatchException e) {
        systemInputStream = new Scanner(System.in);
      }
    }

    long loop_start = System.nanoTime();
    long loop_n = loopFibonacci(n);
    long loop_stop = System.nanoTime();
    double loop_time = (double) (loop_stop - loop_start) / 1_000_000_000.0;
    System.out.printf("loop: %d\nTime taken: %f\n", loop_n, loop_time);

    long recursive_start = System.nanoTime();
    long recursive_n = recursiveFibonacci(n);
    long recursive_stop = System.nanoTime();
    double recursive_time = (double) (recursive_stop - recursive_start) / 1_000_000_000.0;
    System.out.printf("recursive: %d\nTime taken: %f\n", recursive_n, recursive_time);

    systemInputStream.close();
  }

  public static long loopFibonacci(int n) {
    if (n <= 1) {
      return n;
    } else {
      int n_2 = 0;
      int n_1 = 1;
      int n_output = 0;
      for (int loop = 2; loop <= n; loop++) {
        n_output = n_1 + n_2;
        n_2 = n_1;
        n_1 = n_output;
      }
      return n_output;
    }
  }

  public static long recursiveFibonacci(int n) {
    if (n <= 1) {
      return n;
    } else {
      return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }
  }
}
