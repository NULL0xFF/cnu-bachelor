import java.util.Scanner;

public class w10_mazerunner {

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		// Initialize
		Scanner inputStream = new Scanner(System.in);

		/* Map Creation */
		int n, m;
		n = inputStream.nextInt();
		m = inputStream.nextInt();
		char map[][] = new char[n][m];

		String s = inputStream.nextLine();
		Point source, destination;
		for (int i = 0; i < n; i++) {
			s = inputStream.nextLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
				switch (s.charAt(j)) {
				case 'S':
					source = new Point(i, j);
					break;
				case 'E':
					destination = new Point(i, j);
					break;
				// case 'W':
				// break;
				case 'R':
				case 'B':
					break;
				}
			}
		}
		/* End of Map Creation */

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