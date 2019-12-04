import java.util.Scanner;

public class w12_1_mr_driller {

	public static void main(String[] args) {
		Scanner inputStreamScanner = new Scanner(System.in);

		ROW = inputStreamScanner.nextInt();
		COLUMN = inputStreamScanner.nextInt();

		int[][] map = new int[ROW][COLUMN];
		cache = new int[ROW][COLUMN];
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COLUMN; j++) {
				map[i][j] = inputStreamScanner.nextInt();
				cache[i][j] = -1;
			}
		}

		int k = -1;
		for (int i = 0; i < COLUMN; i++) {
			k = Math.max(k, drill(map, ROW - 1, i));
		}
		System.out.println(k);

		inputStreamScanner.close();
	}

	private static int[][] cache;
	private static int ROW, COLUMN;

	private static int drill(int[][] map, int _row, int _column) {
		// Escape
		if (_row == 0) {
			// Save cache
			cache[_row][_column] = map[_row][_column];
			return map[_row][_column];
		}

		// Initialize
		int max = -1;
		int drilling;

		// Algorithm
		for (int pointColumn = _column - 1; pointColumn < _column + 2; pointColumn++) {
			if (pointColumn < 0)
				// Out of boundary
				continue;
			if (pointColumn >= COLUMN)
				// Out of boundary
				continue;
			if (cache[_row - 1][pointColumn] == -1) {
				// Cache is not valid
				drilling = drill(map, _row - 1, pointColumn);
				drilling = drilling + map[_row][_column];
				max = Math.max(max, drilling);
			} else {
				// Cache is valid
				max = Math.max(max, cache[_row - 1][pointColumn] + map[_row][_column]);
			}
		}

		// Save cache
		cache[_row][_column] = max;
		return max;
	}

}
