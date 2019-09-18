import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class w03_POS {

	private HashMap<String, Integer> cache = new HashMap<String, Integer>();

	public int change(List<Integer> coins, int charge) {
		// Exception
		if (charge < 0)
			throw new IllegalArgumentException();

		// Escape
		if (charge == 0)
			return 0;
		if (coins.size() == 0)
			return -1;

		// Initialize
		ArrayList<Integer> list;
		int preview = 0;
		int minimum = -1;

		// Algorithm
		for (int i = 0; i < coins.size(); i++) {
			for (int j = 0; j <= charge / coins.get(i); j++) {
				list = new ArrayList<Integer>();
				list.addAll(coins);
				list.remove(i);
				// Check Cache
				System.out.printf("GET\t%s\n", list.toString());
				if (cache.get(String.format("%s-%d", list.toString(), charge)) != null) {
					// Cache Found
					System.out.printf("FOUND\t%s\n", String.format("%s-%d", list.toString(), charge));
					preview = cache.get(String.format("%s-%d", list.toString(), charge));
				} else {
					// Cache Not Found
					System.out.printf("NOT FOUND\t%s\n", String.format("%s-%d", list.toString(), charge));
					preview = change(list, charge - (coins.get(i) * j));
				}
				if (preview == 0) {
					if ((minimum == -1) || (minimum > j))
						minimum = j;
				} else if (preview != -1) {
					if ((minimum == -1) || (minimum > (preview + j))) {
						minimum = preview + j;
					}
				}
			}
		}

		// Save Cache
		cache.put(String.format("%s-%d", coins.toString(), charge), minimum);
		System.out.printf("PUT\t%s | %d\n", coins.toString(),
				cache.get(String.format("%s-%d", coins.toString(), charge)));

		// Return
		return minimum;
	}

}

public class w03_change {

	public static void main(String[] args) {
		// Initialize
		Scanner inputStream = new Scanner(System.in);
		List<Integer> coins = new ArrayList<Integer>();
		int count = 0, charge = 0;

		// Input Value
		count = inputStream.nextInt();
		for (int loop = 0; loop < count; loop++)
			coins.add(inputStream.nextInt());
		charge = inputStream.nextInt();

		// Output Value
		System.out.printf("%d", new w03_POS().change(coins, charge));

		// Finalize
		inputStream.close();
	}

}
