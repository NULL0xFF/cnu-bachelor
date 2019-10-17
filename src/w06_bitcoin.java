import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class w06_bitcoin {

	private static Scanner inputStream;

	public static void main(String[] args) {
		// Initialize Input Stream Scanner
		initializeInput();

		// Create Graph
		HashMap<String, ArrayList<String>> graph = createGraph();

		// Sort Graph
		graph.forEach((k, v) -> Collections.sort(v));

		// Input StartNode
		String nodeStart = inputStream.next();

		// Output BFS
		List<String> bfsOutput = bfs(graph, nodeStart);
		StringBuilder builder = new StringBuilder();
		while (!bfsOutput.isEmpty()) {
			builder.append(bfsOutput.remove(0));
			if (!bfsOutput.isEmpty())
				builder.append(" ");
		}
		System.out.printf("%s", builder.toString());

		// Finalize
		finalizeInput();
		return;
	}

	private static void initializeInput() {
		inputStream = new Scanner(System.in);
		return;
	}

	private static void finalizeInput() {
		inputStream.close();
		return;
	}

	private static HashMap<String, ArrayList<String>> createGraph() {
		// Initialize
		HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
		int n, m;
		String edgeStart, edgeEnd;

		// Input Node Count
		n = inputStream.nextInt();
		// Input Edge Count
		m = inputStream.nextInt();

		// Input Node
		for (int loop = 0; loop < n; loop++)
			graph.put(inputStream.next(), new ArrayList<String>());
		// Input Edge
		for (int loop = 0; loop < m; loop++) {
			edgeStart = inputStream.next();
			edgeEnd = inputStream.next();
			if (!graph.get(edgeStart).contains(edgeEnd)) {
				graph.get(edgeStart).add(edgeEnd);
				graph.get(edgeEnd).add(edgeStart);
			}
		}

		// Finalize
		return graph;
	}

	private static List<String> bfs(HashMap<String, ArrayList<String>> graph, String nodeStart) {
		// Initialize Variable
		List<String> visited = new ArrayList<String>();
		List<String> queue = new ArrayList<String>();
		String nodeString;

		// Add First Node to Queue
		queue.add(nodeStart);

		// Run Breath-First Search
		while (!queue.isEmpty()) {
			nodeString = queue.remove(0);
			if (!visited.contains(nodeString)) {
				visited.add(nodeString);
				Collections.sort(graph.get(nodeString));
				for (int i = 0; i < graph.get(nodeString).size(); i++) {
					queue.add(graph.get(nodeString).get(i));
				}
			}
		}

		// Return
		return visited;
	}

}
