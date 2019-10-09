public class p06_flood_fill {

	public static void main(String[] args) {
		int width = 5, height = 5;
		int[][] map = { { 1, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 0 }, { 0, 0, 0, 1, 0 } };
		System.out.printf("%s\n", new IslandMap(map, 5, 5));
		return;
	}

}

class IslandMap {
	private int[][] map;
	private int width, height;

	public IslandMap(int[][] map, int width, int height) {
		this.map = map;
		this.width = width;
		this.height = height;
		return;
	}

	public int totalIsland_BFS() {
		int[][] clonedMap = this.map.clone();
		int numberOfIsland = 0;
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				if (clonedMap[i][j] == 1) {
					deleteLand(clonedMap, i, j);
					numberOfIsland++;
				}
			}
		}
		return -1;
	}

	private void deleteLand(int[][] map, int i, int j) {
		if ((i > 0 && i < this.height - 1) && (j > 0 && j < this.width)) {
			for (int a = i - 1; a <= i + 1; a++) {
				for (int b = j - 1; b <= j + 1; b++) {
					if (a == i && b == j)
						continue;
					if (map[a][b] == 1)
						deleteLand(map, a, b);
				}
			}
		} else if (i == 0 && j == 0) {
			for (int a = i; a <= i + 1; a++) {
				for (int b = j; b <= j + 1; b++) {
					if (a == i && b == j)
						continue;
					if (map[a][b] == 1)
						deleteLand(map, a, b);
				}
			}
		} else if (i == 0 && j < this.width) {
			for (int a = i; a <= i + 1; a++) {
				for (int b = j - 1; b <= j + 1; b++) {
					if (a == i && b == j)
						continue;
					if (map[a][b] == 1)
						deleteLand(map, a, b);
				}
			}
		} else if (i == 0 && j == this.width - 1) {
			for (int a = i; a <= i + 1; a++) {
				for (int b = j - 1; b <= j; b++) {
					if (a == i && b == j)
						continue;
					if (map[a][b] == 1)
						deleteLand(map, a, b);
				}
			}
		} else if (i == this.height - 1 && j == 0) {
			for (int a = i - 1; a <= i; a++) {
				for (int b = j; b <= j + 1; b++) {
					if (a == i && b == j)
						continue;
					if (map[a][b] == 1)
						deleteLand(map, a, b);
				}
			}
		} else if (i == this.height - 1 && j == 0) {
			for (int a = i - 1; a <= i; a++) {
				for (int b = j; b <= j + 1; b++) {
					if (a == i && b == j)
						continue;
					if (map[a][b] == 1)
						deleteLand(map, a, b);
				}
			}
		} else if (i == this.height - 1 && j == this.width - 1) {
			for (int a = i - 1; a <= i; a++) {
				for (int b = j - 1; b <= j; b++) {
					if (a == i && b == j)
						continue;
					if (map[a][b] == 1)
						deleteLand(map, a, b);
				}
			}
		}
		map[i][j] = 0;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < this.width; i++) {
			for (int j = 0; j < this.height; j++) {
				builder.append(String.format("%d", map[i][j]));
				if (j + 1 != this.height)
					builder.append(" ");
			}
			if (i + 1 != this.width)
				builder.append("\n");
		}
		return builder.toString();
	}

	private class Coordinate {
		private int x;
		private int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
			return;
		}

		public int getX() {
			return this.x;
		}

		public int getY() {
			return this.y;
		}
	}

}