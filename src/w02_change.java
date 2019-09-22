import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class w02_change {

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
		System.out.printf("%d", change(coins, charge));

		// Finalize
		inputStream.close();
	}

	public static int change(List<Integer> coins, int charge) {
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
				preview = change(list, charge - (coins.get(i) * j));
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

		// Return
		return minimum;
	}
}
