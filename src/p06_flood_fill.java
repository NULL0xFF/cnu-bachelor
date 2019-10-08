import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

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

	public int totalIsland() {
		LinkedList<Integer[]> queue = new LinkedList<Integer[]>();
		for (int i = 0; i < this.width; i++) {
			for (int j = 0; j < this.height; j++) {
				if (this.map[i][j] == 1)
					
					
			}
		}
		return -1;
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

}