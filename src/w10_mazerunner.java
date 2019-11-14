import java.util.Scanner;

public class w10_mazerunner {

	class Point {
		int x;
		int y;
	}

	public static void main(String[] args) {
		// Initialize
		Scanner inputStream = new Scanner(System.in);

		// Create Map
		int n, m;
		n = inputStream.nextInt();
		m = inputStream.nextInt();
		String s = inputStream.nextLine();
		char map[][] = new char[n][m];
		for (int i = 0; i < n; i++) {
			s = inputStream.nextLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		// Output Map
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				builder.append(map[i][j]);
			}
			builder.append("\n");
		}
		System.out.printf("\nOUTPUT\n%s", builder.toString());

		// Finalize
		inputStream.close();

		// Return Main
		return;
	}

}
