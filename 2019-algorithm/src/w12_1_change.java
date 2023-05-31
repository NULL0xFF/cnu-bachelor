import java.util.HashMap;
import java.util.Scanner;

public class w12_1_change {

	private static final HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

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

	public static int pos(int[] coins, int count, int change) {
		// Escape
		if (change == 0)
			return 0;

		// Cache Check
		if (cache.containsKey(change))
			return cache.get(change);

		// Initialize
		int minimum = Integer.MAX_VALUE;

		// Algorithm
		for (int index = 0; index < count; index++)
			if (coins[index] <= change) {
				int subMinimum = pos(coins, count, change - coins[index]);
				subMinimum++;
				if (subMinimum < minimum)
					minimum = subMinimum;
			}

		// Save Cache
		cache.put(change, minimum);

		// Return
		return minimum;
	}

}