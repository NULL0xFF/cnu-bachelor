import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class w10_maze {

	private static char[][] map;

	private static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (!(o instanceof Node))
				return false;
			Node other = (Node) o;
			if (this.x != other.x)
				return false;
			if (this.y != other.y)
				return false;
			return true;
		}
	}

	private static void reconstructPath(HashMap<Node, Node> cameFrom, Node current) {
		while (true) {
			current = cameFrom.get(current);
			if (current == null) {
				break;
			}
			if (cameFrom.get(current) == null)
				break;
			map[current.y][current.x] = 'P';
		}
	}

	private static int distance(Node start, Node end) {
		switch (map[end.y][end.x]) {
		case 'E':
		case 'R':
			return 1;
		case 'B':
			return 3;
		default:
			throw new RuntimeException("distance cannot be checked");
		}
	}

	private static double heuristicCostEstimate(Node start, Node end) {
		return Math
				.sqrt(Math.pow((double) start.x - (double) end.x, 2) + Math.pow((double) start.y - (double) end.y, 2));

	}

	private static void A_Star(Node start, Node goal) {
		// 이미 실행했던 노드들 '닫힌 목록'
		HashSet<Node> closedSet = new HashSet<>();
		// 아직 실행하지는 않았지만 이제 탐색할 노드들 '열린 목록'
		// 초기에는, 시작 노드만 들어있습니다.
		ArrayList<Node> openSet = new ArrayList<>();
		openSet.add(start);

		// 각 가장 효율적인 경로를(노드들을) 담습니다.
		HashMap<Node, Node> cameFrom = new HashMap<>();

		// 각 노드별 시작 노드로부터의 거리를 담습니다. (기본 비용은 Infinity, 최소비용을 찾는 것이므로)
		HashMap<Node, Integer> gScore = new HashMap<>(); // null == INF

		// 처음 노드는 시작 노드이므로 gScore는 0입니다.
		gScore.put(start, 0);

		// 시작 노드로부터의 비용, 목적 노드까지의 비용 두 가지가 합산된 비용입니다.
		HashMap<Node, Double> fScore = new HashMap<>(); // null == INF

		// 첫 번째 노드는 시작 노드로부터의 비용이 0이고, 목적 노드까지는 heuristic한 추정 비용입니다.
		// 그러므로, 첫 노드의 전체 비용은 추정값만 있을 뿐 입니다.
		fScore.put(start, heuristicCostEstimate(start, goal));

		// '열린 목록'이 비어있을 때까지 반복합니다.
		while (!openSet.isEmpty()) {
			// '열린 목록'에서 가장 적은 f값을 가지는 노드
			Node current = null;
			for (Node openNode : openSet) {
				if (fScore.containsKey(openNode)) {
					if (current == null)
						current = openNode;
					else {
						if (fScore.get(openNode) < fScore.get(current)) {
							current = openNode;
						}
					}
				}
			}
			// 목적 노드입니까?
			if (current.equals(goal)) {
				// 길 찾기를 완료하였으니 경로를 만듭니다.
				reconstructPath(cameFrom, current);
				return;
			}
			// 목적노드가 아니라면 '열린 목록'에서 삭제하고 '닫힌 목록'에 넣습니다.
			openSet.remove(current);
			closedSet.add(current);
			// 최소 비용으로 선택한 노드의 인접 노드들을 바라봅니다.
			ArrayList<Node> neighborhood = neighborList(current);

			boolean flag = true;
			while (flag) {
				flag = false;
				for (Node neighbor : neighborhood) {
					for (Node closedNode : closedSet) {
						if (neighbor.x == closedNode.x)
							if (neighbor.y == closedNode.y) {
								neighborhood.remove(neighbor);
								flag = true;
								break;
							}
					}
					if (flag == true)
						break;
				}
			}
			for (Node neighbor : neighborhood) {
				flag = true;
				for (Node openNode : openSet) {
					if (neighbor.x == openNode.x)
						if (neighbor.y == openNode.y)
							flag = false;
				}
				if (flag)
					openSet.add(neighbor);
			}
			for (Node neighbor : neighborhood) {
				int tentative_gScore = gScore.get(current) + distance(current, neighbor);
				if (gScore.containsKey(neighbor)) {
					if (tentative_gScore >= gScore.get(neighbor)) {
						continue;
					} else {
						cameFrom.put(neighbor, current);
						gScore.put(neighbor, tentative_gScore);
						fScore.put(neighbor, gScore.get(neighbor) + heuristicCostEstimate(neighbor, goal));
					}
				} else {
					cameFrom.put(neighbor, current);
					gScore.put(neighbor, tentative_gScore);
					fScore.put(neighbor, gScore.get(neighbor) + heuristicCostEstimate(neighbor, goal));
				}
			}
		}

		throw new RuntimeException("loop failure");
	}

	private static ArrayList<Node> neighborList(Node current) {
		ArrayList<Node> neighborhood = new ArrayList<Node>();
		// North
		if (map[current.y - 1][current.x] != 'W')
			neighborhood.add(new Node(current.x, current.y - 1));
		// South
		if (map[current.y + 1][current.x] != 'W')
			neighborhood.add(new Node(current.x, current.y + 1));
		// East
		if (map[current.y][current.x + 1] != 'W')
			neighborhood.add(new Node(current.x + 1, current.y));
		// West
		if (map[current.y][current.x - 1] != 'W')
			neighborhood.add(new Node(current.x - 1, current.y));
		return neighborhood;
	}

	public static void main(String[] args) {
		Scanner inputStreamScanner = new Scanner(System.in);
		String inputString;

		int height = inputStreamScanner.nextInt();
		int width = inputStreamScanner.nextInt();

		char[][] tempMap = new char[height][width];
		inputStreamScanner.nextLine(); // buffer out '\n'

		Node start = null, goal = null;
		char c;
		for (int y = 0; y < height; y++) {
			inputString = inputStreamScanner.nextLine();
			for (int x = 0; x < width; x++) {
				c = inputString.charAt(x);
				tempMap[y][x] = c;
				if (c == 'S')
					start = new Node(x, y);
				else if (c == 'E')
					goal = new Node(x, y);
			}
		}
		inputStreamScanner.close();

		map = tempMap;
		try {
			A_Star(start, goal);
		} catch (RuntimeException e) {
			StringBuilder stringBuilder = new StringBuilder();
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++)
					stringBuilder.append(map[y][x]);
				if ((y + 1) != height)
					stringBuilder.append('\n');
			}
			System.out.printf("%s\n", stringBuilder.toString());
			return;
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++)
				stringBuilder.append(map[y][x]);
			if ((y + 1) != height)
				stringBuilder.append('\n');
		}
		System.out.printf("%s\n", stringBuilder.toString());
	}

}
