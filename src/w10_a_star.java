import java.util.ArrayList;
import java.util.Scanner;

public class w10_a_star {

	private static class P {
		int x;
		int y;

		P() {

		}

		P(int _x, int _y) {
			this.x = _x;
			this.y = _y;
		}
	}

	private static class Node {
		P id, parent;
		double f, g, h;

		Node(P id, P parent, double g, double h) {
			this.id = id;
			this.parent = parent;
			this.f = g + h;
			this.g = g;
			this.h = h;
		}
	}

	private static double heuristic(P S, P E) {
		return Math.sqrt(Math.pow(S.x - E.x, 2) + Math.pow(S.y - E.y, 2));
	}

	private static ArrayList<Node> adjacentNode(char[][] map, Node currentNode, P E) {
		ArrayList<Node> resultList = new ArrayList<Node>();
		P parent = currentNode.id;
		P id;
		char c;
		// North
		c = map[parent.x - 1][parent.y];
		switch (c) {
		case 'W':
			break;
		case 'B':
			id = new P(parent.x - 1, parent.y);
			resultList.add(new Node(id, parent, currentNode.g + 3, heuristic(id, E)));
			break;
		case 'E':
			System.out.printf("Found E\n");
		case 'R':
			id = new P(parent.x - 1, parent.y);
			resultList.add(new Node(id, parent, currentNode.g + 1, heuristic(id, E)));
			break;
		}
		// East
		c = map[parent.x][parent.y + 1];
		switch (c) {
		case 'W':
			break;
		case 'B':
			id = new P(parent.x, parent.y + 1);
			resultList.add(new Node(id, parent, currentNode.g + 3, heuristic(id, E)));
			break;
		case 'E':
			System.out.printf("Found E\n");
		case 'R':
			id = new P(parent.x, parent.y + 1);
			resultList.add(new Node(id, parent, currentNode.g + 1, heuristic(id, E)));
			break;
		}
		// South
		c = map[parent.x + 1][parent.y];
		switch (c) {
		case 'W':
			break;
		case 'B':
			id = new P(parent.x + 1, parent.y);
			resultList.add(new Node(id, parent, currentNode.g + 3, heuristic(id, E)));
			break;
		case 'E':
			System.out.printf("Found E\n");
		case 'R':
			id = new P(parent.x + 1, parent.y);
			resultList.add(new Node(id, parent, currentNode.g + 1, heuristic(id, E)));
			break;
		}
		// West
		c = map[parent.x][parent.y - 1];
		switch (c) {
		case 'W':
			break;
		case 'B':
			id = new P(parent.x, parent.y - 1);
			resultList.add(new Node(id, parent, currentNode.g + 3, heuristic(id, E)));
			break;
		case 'E':
			System.out.printf("Found E\n");
		case 'R':
			id = new P(parent.x, parent.y - 1);
			resultList.add(new Node(id, parent, currentNode.g + 1, heuristic(id, E)));
			break;
		}
		return resultList;
	}

	public static void main(String[] args) {
		////////////////////////////////
		/* Initialize of Variables */
		Scanner inputStreamScanner = new Scanner(System.in);
		String inputString;
		P S = new P();
		P E = new P();
		int n, m;
		char map[][];
		/* End of Initialization */
		////////////////////////////////
		/* Create Graph */
		n = inputStreamScanner.nextInt();
		m = inputStreamScanner.nextInt();
		map = new char[n][m];
		inputString = inputStreamScanner.nextLine(); // remove new line
		for (int i = 0; i < n; i++) {
			inputString = inputStreamScanner.nextLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = inputString.charAt(j);
				switch (map[i][j]) {
				case 'S':
					S.x = i;
					S.y = j;
					break;
				case 'E':
					E.x = i;
					E.y = j;
					break;
				}
			}
		}
		/* End of Creation */
		////////////////////////////////
		/* A_Star Algorithm */
		// Initialization
		ArrayList<Node> openList = new ArrayList<Node>();
		ArrayList<Node> closeList = new ArrayList<Node>();
		ArrayList<Node> tempList;
		Node currentNode, checkingNode = null;
		boolean flag;

		// Set-Up
		closeList.add(new Node(S, null, 0, 0));

		// Main Loop
		while (true) {
			// Node Iteration on closeList
			currentNode = closeList.get(closeList.size() - 1);

			// Add all adjacent to openList
			tempList = adjacentNode(map, currentNode, E);
			for (Node tempNode : tempList) {
				flag = true;
				for (Node openNode : openList) {
					// Check if openList has same id with tempNode
					if ((openNode.id.x == tempNode.id.x) && (openNode.id.y == tempNode.id.y)) {
						flag = false;
						checkingNode = openNode;
						break;
					}
				}
				if (flag) {
					openList.add(tempNode);
				} else {
					if (tempNode.g < checkingNode.g) {
						openList.remove(checkingNode);
						openList.add(tempNode);
					}
				}
			}

			// Get a node with least f from openList
			checkingNode = openList.get(0);
			for (Node openNode : openList) {
				if (openNode.f < checkingNode.f) {
					checkingNode = openNode;
				}
			}

			// Remove selected node from openList and add to closeList
			openList.remove(checkingNode);
			closeList.add(checkingNode);

			// Escape
			if (currentNode.id.x == E.x && currentNode.id.y == E.y) // Check if closeList's last element is E
				break;
		}
		/* End of Algorithm */
		////////////////////////////////
		/* Drawing Path */
		Node prevNode = currentNode; // Now currentNode is E
		int index = closeList.size() - 2;
		while (true) {
			// Set Node
			currentNode = closeList.get(index);

			// Escape
			if (currentNode.parent == null) { // escape when current node is S
				break;
			}

			// Avoid unnecessary path
			if (currentNode.id.x != prevNode.parent.x || currentNode.id.y != prevNode.parent.y) {
				index--;
				continue;
			}

			// Change path character as P
			map[currentNode.id.x][currentNode.id.y] = 'P';

			// Next Iteration
			prevNode = currentNode;
			index--;
		}
		/* Path Complete */
		////////////////////////////////
		/* Output Graph */
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				stringBuilder.append(map[i][j]);
			}
			if ((i + 1) != n)
				stringBuilder.append('\n');
		}
		System.out.printf("%s\n", stringBuilder.toString());
		System.out.printf("%c = (%d, %d)\n", 'S', S.x, S.y);
		System.out.printf("%c = (%d, %d)\n", 'E', E.x, E.y);
		/* End of Output */
		////////////////////////////////
		/* Finalize */
		inputStreamScanner.close();
		return;
		/* End of Finalize */
		////////////////////////////////
	}

}