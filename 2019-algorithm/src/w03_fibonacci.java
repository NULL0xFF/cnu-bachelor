import java.math.BigInteger;
import java.util.Scanner;

public class w03_fibonacci {

	public static void main(String[] args) {
		// Initialize
		Scanner inputStream = new Scanner(System.in);
		int n = 0;

		// Input Value
		n = inputStream.nextInt();

		// Output Value
		System.out.printf("%s\n", fibonacci(n));

		// Finalize
		inputStream.close();
	}

	public static BigInteger fibonacci(int n) {
		// Escape
		if (n <= 0)
			return BigInteger.ZERO;
		if (n == 1)
			return BigInteger.ONE;

		// Initialize
		BigInteger fn_2 = BigInteger.ZERO;
		BigInteger fn_1 = BigInteger.ONE;
		BigInteger fn = BigInteger.ONE;

		for (int loop = 2; loop < n; loop++) {
			fn_2 = fn_1;
			fn_1 = fn;
			fn = fn_1.add(fn_2);
		}

		// Return
		return fn;
	}

}