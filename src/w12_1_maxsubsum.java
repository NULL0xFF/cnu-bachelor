import java.util.HashSet;
import java.util.Scanner;

public class w12_1_maxsubsum {

	public static void main(String[] args) {
		Scanner inputStreamScanner = new Scanner(System.in);

		int n = inputStreamScanner.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++)
			a[i] = inputStreamScanner.nextInt();

		HashSet<Integer> cache = new HashSet<>();

		int subSum = 0;
		for (int i = 0; i < n; i++) {
			subSum = a[i];
			cache.add(subSum);
			for (int j = i + 1; j < n; j++) {
				subSum = subSum + a[j];
				cache.add(subSum);
			}
		}
		int maxSubSum = Integer.MIN_VALUE;
		for (int i : cache) {
			maxSubSum = Math.max(maxSubSum, i);
		}

		System.out.println(maxSubSum);
		inputStreamScanner.close();
	}

}
