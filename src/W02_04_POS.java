import java.util.Scanner;

class POS {
	public int change(int[] coins, int cost) {
		// Escape
		if (cost == 0)
			return 0;

		// Initialize
		int[] template = { 1, 10, 50, 100, 500 };
		int count = 0, output = 0;

		// Recursive Algorithm
		for (int l = coins.length - 1; l >= 0; l--) {
			count = cost / template[l];
			if (count != 0) {
				if (coins[l] >= count) {
					coins[l] = coins[l] - count;
					cost = cost - (template[l] * count);
					output = change(coins, cost);
					if (output != -1)
						return count + change(coins, cost);
				} else if (coins[l] > 0) {
					count = coins[l];
					coins[l] = 0;
					cost = cost - (count * template[l]);
					output = change(coins, cost);
					if (output != -1)
						return count + change(coins, cost);
				}
			}
		}
		return -1;
	}

}

public class W02_04_POS {

	public static void main(String[] args) {
		// Initialize
		Scanner inputStream = new Scanner(System.in);
		int count = 0, cost = 0;
		int[] coins;

		// Input Value
		count = inputStream.nextInt();
		coins = new int[count];
		for (int i = count - 1; i >= 0; i--)
			coins[i] = inputStream.nextInt();
		cost = inputStream.nextInt();

		// Output Value
		System.out.printf("%d", new POS().change(coins, cost));

		// Finalize
		inputStream.close();
	}

}
