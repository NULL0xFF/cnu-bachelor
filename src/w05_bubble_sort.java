import java.util.Scanner;

public class w05_bubble_sort {

	public static void main(String[] args) {
		// Initialize
		Scanner inputStream = new Scanner(System.in);

		// Input
		int n = inputStream.nextInt();
		int m = inputStream.nextInt();
		char flag = inputStream.next().charAt(0);
		char[] array = new char[n];
		for (int l = 0; l < n; l++)
			array[l] = inputStream.next().charAt(0);

		// Algorithm
		char c1, c2;
		switch (flag) {
		case 'A':
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < (array.length - (i + 1)); j++) {
					c1 = array[j];
					c2 = array[j + 1];
					if (c1 > c2) {
						array[j] = c2;
						array[j + 1] = c1;
					}
				}
			}
			break;
		case 'D':
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < (array.length - (i + 1)); j++) {
					c1 = array[j];
					c2 = array[j + 1];
					if (c1 < c2) {
						array[j] = c2;
						array[j + 1] = c1;
					}
				}
			}
			break;
		}

		// Output
		for (int i = 0; i < array.length; i++)
			System.out.printf("%c ", array[i]);

		// Finalize
		inputStream.close();
	}

}
