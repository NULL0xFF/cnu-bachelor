import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class w03_change {

	private static final HashMap<String, BigInteger> cache = new HashMap<String, BigInteger>();

	public static void main(String[] args) {
		// Initialize
		Scanner inputStream = new Scanner(System.in);
		int[] coins;
		int count = 0, change = 0;

		// Input Value
		count = inputStream.nextInt();
		coins = new int[count];
		for (int loop = 0; loop < count; loop++)
			coins[loop] = inputStream.nextInt();
		change = inputStream.nextInt();

		// Output Value
		System.out.printf("%s\n", pos(coins, count, change));

		// Finalize
		inputStream.close();
	}

	public static BigInteger pos(int[] coins, int count, int change) {
		// Escape
		if (change == 0)
			return BigInteger.ZERO;

		// Cache Check
		BigInteger cachedNumber = cache.get(String.format("%s | %d | %d", Arrays.toString(coins), count, change));
		if (cachedNumber != null)
			return cachedNumber;

		// Initialize
		BigInteger minimum = new BigInteger(Integer.toString(Integer.MAX_VALUE));

		// Algorithm
		for (int index = 0; index < count; index++)
			if (coins[index] <= change) {
				BigInteger subMinimum = pos(coins, count, change - coins[index]);
				subMinimum = subMinimum.add(BigInteger.ONE);
				if (subMinimum.compareTo(minimum) == -1)
					minimum = subMinimum;
			}

		// Save Cache
		cache.put(String.format("%s | %d | %d", Arrays.toString(coins), count, change), minimum);

		// Return
		return minimum;
	}

}