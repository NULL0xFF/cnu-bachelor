import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class w06_p2p {

	public static void main(String[] args) {
		// Initialize
		Scanner inputStream = new Scanner(System.in);
		// Create Graph
		Graph graph = new Graph();
		int n, m;
		n = inputStream.nextInt();
		m = inputStream.nextInt();
		for (int i = 0; i < n; i++)
			graph.addNode(inputStream.next());
		String edgeStart, edgeEnd;
		for (int i = 0; i < m; i++) {
			edgeStart = inputStream.next();
			edgeEnd = inputStream.next();
			graph.addEdge(edgeStart, edgeEnd);
		}

		// Sort Graph
		graph.sort();

		// Output
		System.out.printf("%s", graph);

		// Finalize
		inputStream.close();
	}

	private static class Graph {
		private HashMap<String, List<String>> graphMap;

		public Graph() {
			this.graphMap = new HashMap<String, List<String>>();
		}

		public boolean addNode(String node) {
			if (this.graphMap.containsKey(node))
				return false;
			this.graphMap.put(node, new ArrayList<String>());
			return true;
		}

		public boolean addEdge(String nodeFront, String nodeEnd) {
			this.addNode(nodeFront);
			this.addNode(nodeEnd);
			if (this.graphMap.get(nodeFront).contains(nodeEnd))
				return false;
			this.graphMap.get(nodeFront).add(nodeEnd);
			this.graphMap.get(nodeEnd).add(nodeFront);
			return true;
		}

		public void sort() {
			this.graphMap.forEach((k, v) -> {
				Collections.sort((List<String>) v);
			});
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			Set<String> cache = new HashSet<String>();
			this.graphMap.forEach((k, v) -> {
				cache.add(k);
				builder.append(String.format("%s: ", k));
				v.forEach(e -> {
					builder.append(String.format("%s", e));
					if (v.indexOf(e) < v.size() - 1)
						builder.append(", ");
				});
				if (graphMap.size() != cache.size())
					builder.append("\n");
			});
			return builder.toString();
		}

	}

}
