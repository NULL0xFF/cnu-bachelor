import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class w10_a_star_string {

	private static class Node {
		String id, parent, E;

		double f, g, h;

		Node(String id, String E) {
			this.id = id;
			this.E = E;
			this.parent = null;
			this.f = 0;
			this.g = 0;
			this.h = 0;
		}

		Node(String id, String E, String parent, int mult) {
			this.id = id;
			this.E = E;
			this.parent = parent;
			this.heuristic(mult);
		}

		void heuristic(int mult) {
			int x1, y1, x2, y2;
			String[] parseStringArray = id.split("-");
			x1 = Integer.parseInt(parseStringArray[0]);
			y1 = Integer.parseInt(parseStringArray[1]);
			parseStringArray = parent.split("-");
			x2 = Integer.parseInt(parseStringArray[0]);
			y2 = Integer.parseInt(parseStringArray[1]);
			this.g = mult * distance(x1, y1, x2, y2);
			parseStringArray = E.split("-");
			x2 = Integer.parseInt(parseStringArray[0]);
			y2 = Integer.parseInt(parseStringArray[1]);
			this.h = distance(x1, y1, x2, y2);
			this.f = this.g + this.h;
		}

		private double distance(double x1, double y1, double x2, double y2) {
			return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
		}
	}

	private static ArrayList<Node> adjacentNodeList(HashMap<String, Character> map, String E, Node node) {
		ArrayList<Node> resultList = new ArrayList<Node>();
		int x1, y1, x2, y2, x3, y3;
		char c;
		String[] parseStringArray = node.id.split("-");
		x1 = Integer.parseInt(parseStringArray[0]);
		y1 = Integer.parseInt(parseStringArray[1]);
		if (node.parent != null) {
			parseStringArray = node.parent.split("-");
			x2 = Integer.parseInt(parseStringArray[0]);
			y2 = Integer.parseInt(parseStringArray[1]);
		} else {
			x2 = -1;
			y2 = -1;
		}
		// North
		x3 = x1 - 1;
		y3 = y1;
		if (x3 != x2 && y3 != y2) {
			c = map.get(String.format("%d-%d", x3, y3));
			switch (c) {
			case 'W':
				break;
			case 'E':
			case 'R':
				resultList.add(new Node(String.format("%d-%d", x3, y3), E, node.id, 1));
				break;
			case 'B':
				resultList.add(new Node(String.format("%d-%d", x3, y3), E, node.id, 3));
				break;
			}
		}
		// South
		x3 = x1 + 1;
		y3 = y1;
		if (x3 != x2 && y3 != y2) {
			c = map.get(String.format("%d-%d", x3, y3));
			switch (c) {
			case 'W':
				break;
			case 'E':
			case 'R':
				resultList.add(new Node(String.format("%d-%d", x3, y3), E, node.id, 1));
				break;
			case 'B':
				resultList.add(new Node(String.format("%d-%d", x3, y3), E, node.id, 3));
				break;
			}
		}
		// East
		x3 = x1;
		y3 = y1 + 1;
		if (x3 != x2 && y3 != y2) {
			c = map.get(String.format("%d-%d", x3, y3));
			switch (c) {
			case 'W':
				break;
			case 'E':
			case 'R':
				resultList.add(new Node(String.format("%d-%d", x3, y3), E, node.id, 1));
				break;
			case 'B':
				resultList.add(new Node(String.format("%d-%d", x3, y3), E, node.id, 3));
				break;
			}
		}
		// West
		x3 = x1;
		y3 = y1 - 1;
		if (x3 != x2 && y3 != y2) {
			c = map.get(String.format("%d-%d", x3, y3));
			switch (c) {
			case 'W':
				break;
			case 'E':
			case 'R':
				resultList.add(new Node(String.format("%d-%d", x3, y3), E, node.id, 1));
				break;
			case 'B':
				resultList.add(new Node(String.format("%d-%d", x3, y3), E, node.id, 3));
				break;
			}
		}
		return resultList;
	}

	private static ArrayList<Node> mergeNodeList(ArrayList<Node> targetList, ArrayList<Node> dataList) {
		ArrayList<Node> resultList = new ArrayList<Node>();
		for (Node data : dataList) {
			for (Node target : targetList) {
				if (data.id.equals(target.id)) {
					if (data.g < target.g) {
						resultList.add(data);
					} else {
						resultList.add(target);
					}
				} else {
					resultList.add(target);
				}
			}
		}
		return resultList;
	}

	public static void main(String[] args) {
		/* Start of Program */

		// Variable Initialization
		Scanner inputStreamScanner = new Scanner(System.in);
		HashMap<String, Character> map = new HashMap<>();

		int n = inputStreamScanner.nextInt();
		int m = inputStreamScanner.nextInt();
		String inputLine = inputStreamScanner.nextLine(); // '\n' buffer deletion for next input

		// Create Map
		String S = null;
		String E = null;
		String parseString = null;
		for (int i = 0; i < n; i++) {
			inputLine = inputStreamScanner.nextLine();
			for (int j = 0; j < m; j++) {
				parseString = String.format("%d-%d", i, j);
				if (inputLine.charAt(j) == 'S') {
					S = parseString;
				} else if (inputLine.charAt(j) == 'E') {
					E = parseString;
				}
				map.put(parseString, inputLine.charAt(j));
			}
		}

		/* Start of Algorithm */
		ArrayList<Node> openList = new ArrayList<>();
		ArrayList<Node> closeList = new ArrayList<>();
		String lastNode = null;
		Node currentNode = null;
		Node minNode = null;
		String[] parseStringArray = null;
		closeList.add(new Node(S, E));
		int x, y;

		// Main Loop
		while (true) {
			currentNode = closeList.get(closeList.size() - 1);
			parseStringArray = currentNode.id.split("-");
			x = Integer.parseInt(parseStringArray[0]);
			y = Integer.parseInt(parseStringArray[1]);
			if (currentNode.id.equals(E)) { // End if node is E
				break;
			}
			openList = mergeNodeList(openList, adjacentNodeList(map, E, currentNode));
			minNode = openList.get(0);
			for (Node node : openList) {
				if (node.f < minNode.f) {
					minNode = node;
				}
			}
			openList.remove(minNode);
			closeList.add(minNode);
		}
		// Path Finding

		/* End of Algorithm */

		// Output Map
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				parseString = String.format("%d-%d", i, j);
				stringBuilder.append(map.get(parseString));
			}
			if ((i + 1) != n)
				stringBuilder.append('\n');
		}
		System.out.printf("%s\n", stringBuilder.toString());

		// Clean-Up
		inputStreamScanner.close();
		return;
		/* End of Program */
	}

}
