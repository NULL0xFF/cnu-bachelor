import java.math.BigInteger;
import java.util.Scanner;

public class w03_factorial {

	public static void main(String[] args) {
		// Initialize
		Scanner inputStream = new Scanner(System.in);
		int n = 0;

		// Input
		n = inputStream.nextInt();

		// Output)
		System.out.printf("%s", new w03_factorial().factorial(n));

		// Finalize
		inputStream.close();
	}

	public BigInteger factorial(int n) {
		// Escape
		if (n < 0)
			return new BigInteger("0");
		else if (n == 0)
			return BigInteger.ONE;

		// Initialize
		BigInteger result = new BigInteger("1");

		// Algorithm
		for (int loop = 1; loop <= n; loop++) {
			result = result.multiply(BigInteger.valueOf(loop));
		}

		// Return
		return result;
	}
}
