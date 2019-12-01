import java.util.Scanner;

public class w12_1_knapsack {

	public static void main(String[] args) {
		Scanner inputStreamScanner = new Scanner(System.in);

		int capacity = inputStreamScanner.nextInt();
		int numberOfItems = inputStreamScanner.nextInt();

		int[] w = new int[numberOfItems + 1];
		int[] v = new int[numberOfItems + 1];

		for (int i = 1; i <= numberOfItems; i++) {
			w[i] = inputStreamScanner.nextInt();
		}
		for (int i = 1; i <= numberOfItems; i++) {
			v[i] = inputStreamScanner.nextInt();
		}

		int[][] m = new int[numberOfItems + 1][capacity + 1];
		for (int i = 0; i < capacity + 1; i++) {
			m[0][i] = 0;
		}
		for (int i = 1; i <= numberOfItems; i++) {
			for (int j = 0; j <= capacity; j++) {
				if (w[i] > j)
					m[i][j] = m[i - 1][j];
				else
					m[i][j] = Math.max(m[i - 1][j], m[i - 1][j - w[i]] + v[i]);
			}
		}
		
		System.out.println(m[numberOfItems][capacity]);

		inputStreamScanner.close();
	}

}
