import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class w10_a_star02 {

	static class Point {
		int x, y;

		Point() {
		}

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Node {
		Point id, parent;
		double g, h, f;

		Node(Point a, Point b, double g, double h) {
			this.id = a;
			this.parent = b;
			this.g = g;
			this.h = h;
			this.f = g + h;
		}
	}

	public static void main(String[] args) {
		////////////////////////////////
		/* Initialize of Variables */
		Scanner inputStreamScanner = new Scanner(System.in);
		HashMap<Integer, HashMap<Integer, Character>> graph = new HashMap<>();
		HashMap<Integer, Character> graphPointer;
		StringBuilder stringBuilder;
		String inputString;
		Point S = new Point();
		Point E = new Point();
		int n, m;
		/* End of Initialization */
		////////////////////////////////
		/* Create Graph */
		n = inputStreamScanner.nextInt();
		m = inputStreamScanner.nextInt();
		inputString = inputStreamScanner.nextLine(); // remove new line
		for (int i = 0; i < n; i++) {
			inputString = inputStreamScanner.nextLine();
			graph.put(i, new HashMap<>());
			graphPointer = graph.get(i);
			for (int j = 0; j < m; j++) {
				graphPointer.put(j, inputString.charAt(j));
				switch (inputString.charAt(j)) {
				case 'S':
					S = new Point(i, j);
					break;
				case 'E':
					E = new Point(i, j);
					break;
				}
			}
		}
		/* End of Creation */
		////////////////////////////////
		/* A_Star Algorithm */
		ArrayList<Node> OpenList = new ArrayList<>(); // Queue
		ArrayList<Node> CloseList = new ArrayList<>();
		OpenList.add(new Node(S, null, 0, 0));
		Node nodePointer, iteratorPointer;
		boolean flag;
		while (!OpenList.isEmpty()) {
			flag = true;
			nodePointer = OpenList.get(0);
			OpenList.remove(0);
			if (nodePointer.id.x == E.x && nodePointer.id.y == E.y) {
				CloseList.add(nodePointer);
				break;
			}
			Iterator<Node> it = CloseList.iterator();
			while (it.hasNext()) {
				iteratorPointer = it.next();
				if ((iteratorPointer.id.x == nodePointer.id.x) && (iteratorPointer.id.y == nodePointer.id.y)) {
					// 존재하는 경우
					flag = false;
					if (nodePointer.g < iteratorPointer.g) {
						iteratorPointer.g = nodePointer.g;
						iteratorPointer.f = nodePointer.f;
						iteratorPointer.parent = nodePointer.parent;
						CloseList.add(iteratorPointer);
					}
					break;
				}
			}
			if (flag)
				CloseList.add(nodePointer);
			OpenList.addAll(adjacentNodeList(graph, CloseList, nodePointer, E));
		}
		/* End of Algorithm */
		////////////////////////////////
		/* Drawing Path */
		Node curNode = CloseList.get(CloseList.size() - 1);
		CloseList.remove(curNode);
		Point curPos;
		while (true) {
			curPos = curNode.parent;
			if (graph.get(curPos.x).get(curPos.y) == 'S')
				break;
			graph.get(curPos.x).replace(curPos.y, 'P');
			for(Node node : CloseList) {
				if(node.id.x == curPos.x && node.id.y == curPos.y) {
					curNode = node;
				}
			}
		}
		/* Path Complete */
		////////////////////////////////
		/* Output Graph */
		stringBuilder = new StringBuilder();
		for (int i = 0; i < n; i++) {
			graphPointer = graph.get(i);
			for (int j = 0; j < m; j++) {
				stringBuilder.append(graphPointer.get(j));
			}
			if ((i + 1) != n)
				stringBuilder.append('\n');
		}
		System.out.printf("%s\n", stringBuilder.toString());
		/* End of Output */
		////////////////////////////////
		/* Finalize */
		inputStreamScanner.close();
		return;
		/* End of Finalize */
		////////////////////////////////
	}

	private static ArrayList<Node> adjacentNodeList(HashMap<Integer, HashMap<Integer, Character>> graph,
			ArrayList<Node> closeList, Node nodePointer, Point E) {
		ArrayList<Node> resultList = new ArrayList<Node>();
		Point parentPoint = nodePointer.id;
		Point id;
		boolean flag = true;
		id = new Point(parentPoint.x - 1, parentPoint.y);
		for (Node closeNode : closeList) {
			if (closeNode.id.x == id.x && closeNode.id.y == id.y) {
				flag = false;
				break;
			}
		}
		if (flag)
			if (graph.get(parentPoint.x - 1).get(parentPoint.y) != 'W') {
				if (graph.get(parentPoint.x - 1).get(parentPoint.y) == 'B') {
					if (nodePointer.parent == null)
						resultList.add(new Node(id, parentPoint, 3 * heuristic(id, parentPoint), heuristic(id, E)));
					else if (!(id.x == nodePointer.parent.x && id.y == nodePointer.parent.y))
						resultList.add(new Node(id, parentPoint, 3 * heuristic(id, parentPoint), heuristic(id, E)));
				} else {
					if (nodePointer.parent == null)
						resultList.add(new Node(id, parentPoint, heuristic(id, parentPoint), heuristic(id, E)));
					else if (!(id.x == nodePointer.parent.x && id.y == nodePointer.parent.y))
						resultList.add(new Node(id, parentPoint, heuristic(id, parentPoint), heuristic(id, E)));
				}
			}
		flag = true;
		id = new Point(parentPoint.x, parentPoint.y + 1);
		for (Node closeNode : closeList) {
			if (closeNode.id.x == id.x && closeNode.id.y == id.y) {
				flag = false;
				break;
			}
		}
		if (flag)
			if (graph.get(parentPoint.x).get(parentPoint.y + 1) != 'W') {
				if (graph.get(parentPoint.x - 1).get(parentPoint.y) == 'B') {
					if (nodePointer.parent == null)
						resultList.add(new Node(id, parentPoint, 3 * heuristic(id, parentPoint), heuristic(id, E)));
					else if (!(id.x == nodePointer.parent.x && id.y == nodePointer.parent.y))
						resultList.add(new Node(id, parentPoint, 3 * heuristic(id, parentPoint), heuristic(id, E)));
				} else {
					if (nodePointer.parent == null)
						resultList.add(new Node(id, parentPoint, heuristic(id, parentPoint), heuristic(id, E)));
					else if (!(id.x == nodePointer.parent.x && id.y == nodePointer.parent.y))
						resultList.add(new Node(id, parentPoint, heuristic(id, parentPoint), heuristic(id, E)));
				}
			}
		flag = true;
		id = new Point(parentPoint.x + 1, parentPoint.y);
		for (Node closeNode : closeList) {
			if (closeNode.id.x == id.x && closeNode.id.y == id.y) {
				flag = false;
				break;
			}
		}
		if (flag)
			if (graph.get(parentPoint.x + 1).get(parentPoint.y) != 'W') {
				if (graph.get(parentPoint.x - 1).get(parentPoint.y) == 'B') {
					if (nodePointer.parent == null)
						resultList.add(new Node(id, parentPoint, 3 * heuristic(id, parentPoint), heuristic(id, E)));
					else if (!(id.x == nodePointer.parent.x && id.y == nodePointer.parent.y))
						resultList.add(new Node(id, parentPoint, 3 * heuristic(id, parentPoint), heuristic(id, E)));
				} else {
					if (nodePointer.parent == null)
						resultList.add(new Node(id, parentPoint, heuristic(id, parentPoint), heuristic(id, E)));
					else if (!(id.x == nodePointer.parent.x && id.y == nodePointer.parent.y))
						resultList.add(new Node(id, parentPoint, heuristic(id, parentPoint), heuristic(id, E)));
				}
			}
		flag = true;
		id = new Point(parentPoint.x, parentPoint.y - 1);
		for (Node closeNode : closeList) {
			if (closeNode.id.x == id.x && closeNode.id.y == id.y) {
				flag = false;
				break;
			}
		}
		if (flag)
			if (graph.get(parentPoint.x).get(parentPoint.y - 1) != 'W') {
				if (graph.get(parentPoint.x - 1).get(parentPoint.y) == 'B') {
					if (nodePointer.parent == null)
						resultList.add(new Node(id, parentPoint, 3 * heuristic(id, parentPoint), heuristic(id, E)));
					else if (!(id.x == nodePointer.parent.x && id.y == nodePointer.parent.y))
						resultList.add(new Node(id, parentPoint, 3 * heuristic(id, parentPoint), heuristic(id, E)));
				} else {
					if (nodePointer.parent == null)
						resultList.add(new Node(id, parentPoint, heuristic(id, parentPoint), heuristic(id, E)));
					else if (!(id.x == nodePointer.parent.x && id.y == nodePointer.parent.y))
						resultList.add(new Node(id, parentPoint, heuristic(id, parentPoint), heuristic(id, E)));
				}
			}
		return resultList;
	}

	private static double heuristic(Point a, Point b) {
		return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
	}

}
