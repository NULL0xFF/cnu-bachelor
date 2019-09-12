import java.util.Scanner;

class Fibonacci {
	public int fibonacci(int n) {
		if (n <= 0)
			return 0;
		else if (n == 1)
			return 1;
		else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
}

public class w02_fibonacci {
	public static void main(String[] args) {
		// Initialize
		Scanner inputStream = new Scanner(System.in);
		int n = 0;

		// Input Value
		n = inputStream.nextInt();

		// Output Value
		System.out.printf("%d\n", new Fibonacci().fibonacci(n));

		// Finalize
		inputStream.close();
	}
}
