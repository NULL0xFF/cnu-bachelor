import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class w06_p2p {

	public static void main(String[] args) {
		Graph graph = new Graph();
		System.out.printf("%s", graph);
	}

}

class Graph {

	private Set<Node> nodeSet;

	public Graph() {
		this.init();
	}

	private void init() {
		// Initialize Variable
		Scanner inputStream = new Scanner(System.in);
		this.nodeSet = new TreeSet<Node>();

		// Input
		int n = inputStream.nextInt();
		int m = inputStream.nextInt();
		String edgeStart, edgeEnd;
		for (int i = 0; i < n; i++)
			this.nodeSet.add(new Node(inputStream.next()));
		for (int i = 0; i < m; i++) {
			edgeStart = inputStream.next();
			edgeEnd = inputStream.next();
			if (!findNode(edgeStart).getEdge().contains(findNode(edgeEnd))) {
				findNode(edgeStart).getEdge().add(findNode(edgeEnd));
				findNode(edgeEnd).getEdge().add(findNode(edgeStart));
			}
		}

		// Finalize
		inputStream.close();
	}

	public Node findNode(Object value) {
		Iterator<Node> nodeIterator = this.nodeSet.iterator();
		Node nodePointer;
		while (nodeIterator.hasNext()) {
			nodePointer = nodeIterator.next();
			if (nodePointer.getValue() == value)
				return nodePointer;
		}
		return null;
	}

}

class Node implements Comparable<Node> {
	private Object value;
	private Set<Node> edge;

	public Node(Object value) {
		this.value = value;
		this.edge = new HashSet<Node>();
	}

	public Object getValue() {
		return this.value;
	}

	public Set<Node> getEdge() {
		return this.edge;
	}

	@Override
	public int compareTo(Node o) {
		return ((String) this.getValue()).compareTo((String) o.getValue());
	}
}