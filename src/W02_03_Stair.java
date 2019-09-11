import java.util.Scanner;

class Stair {

	public int Jump(int n, int m) {
		if (n == 0)
			return 0;

		int count = 0;

		for (int i = 1; i <= m; i++) {
			if (n / i != 0) {
				if ((n - i) == 0)
					count++;
				count = count + Jump(n - i, m);
			}
		}

		return count;

	}
}

public class W02_03_Stair {

	public static void main(String[] args) {
		// Initialize
		Scanner inputStream = new Scanner(System.in);
		int n = 0, m = 0;

		n = inputStream.nextInt();
		m = inputStream.nextInt();

		System.out.printf("%d", new Stair().Jump(n, m));

		inputStream.close();
	}

}
