import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

class Stair {

	private HashMap<String, BigInteger> cache = new HashMap<String, BigInteger>();

	public BigInteger Jump(int n, int m) {
		// Escape
		if (n < 0)
			throw new IllegalArgumentException();
		if (n == 0)
			return BigInteger.ZERO;

		// Check Cache
		BigInteger cachedNumber = cache.get(String.format("%d-%d", n, m));
		if (cachedNumber != null) {
			// System.out.printf("GET: %d-%d, %s\n", n, m, cachedNumber.toString());
			return cachedNumber;
		} else {
			// System.out.printf("GET: %d-%d, not found\n", n, m);
		}
		// Initialize
		BigInteger preview = BigInteger.valueOf(-1);
		BigInteger count = BigInteger.ZERO;

		// Algorithm
		for (int i = 1; (i <= m) && (i <= n); i++) {
			// System.out.printf("CALL: %d-%d\n", n - i, m);
			preview = this.Jump(n - i, m);
			if (preview.compareTo(BigInteger.ZERO) == 0)
				count = count.add(BigInteger.ONE);
			else
				count = count.add(preview);
		}

		// Save Cache
		// System.out.printf("PUT: %d-%d, %s\n", n, m, count.toString());
		cache.put(String.format("%d-%d", n, m), count);

		// Return
		return count;
	}
}

public class w02_stair {

	public static void main(String[] args) {
		// Initialize
		Scanner inputStream = new Scanner(System.in);
		int n = 0, m = 0;

		n = inputStream.nextInt();
		m = inputStream.nextInt();

		System.out.printf("%s\n", new Stair().Jump(n, m).toString());

		inputStream.close();
	}

}
