import java.util.Scanner;

class Euclid {
	public int gcd(int n1, int n2) {
		if (n2 == 0)
			return n1;
		return gcd(n2, n1 % n2);
	}
}

public class W02_02_Euclid {
	public static void main(String[] args) {
		// Initialize
		Scanner inputStream = new Scanner(System.in);
		int n1 = 0, n2 = 0;

		// Input Value
		n1 = inputStream.nextInt();
		n2 = inputStream.nextInt();

		// Output Value
		System.out.printf("%d\n", new Euclid().gcd(n1, n2));

		// Finalize
		inputStream.close();
	}
}
