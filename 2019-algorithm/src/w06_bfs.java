import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class w06_bfs {

	public static void main(String[] args) {
		// Initialize
		Scanner inputStream = new Scanner(System.in);

		// Create Graph
		HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
		int n, m;
		n = inputStream.nextInt();
		m = inputStream.nextInt();
		for (int i = 0; i < n; i++)
			graph.put(inputStream.next(), new ArrayList<String>());
		String edgeStart, edgeEnd;
		for (int i = 0; i < m; i++) {
			edgeStart = inputStream.next();
			edgeEnd = inputStream.next();
			if (!graph.get(edgeStart).contains(edgeEnd))
				graph.get(edgeStart).add(edgeEnd);
			if (!graph.get(edgeEnd).contains(edgeStart))
				graph.get(edgeEnd).add(edgeStart);
		}

		// Input
		String nodeStart = inputStream.next();

		// Output
		List<String> visitedBFS = bfs(graph, nodeStart);
		StringBuilder builder = new StringBuilder();
		while (!visitedBFS.isEmpty()) {
			builder.append(visitedBFS.remove(0));
			if (!visitedBFS.isEmpty())
				builder.append(" ");
		}
		System.out.printf("%s", builder);

		// Finalize
		inputStream.close();

  }

	private static List<String> bfs(HashMap<String, ArrayList<String>> graph, String nodeStart) {
		List<String> visited = new ArrayList<String>();
		List<String> queue = new ArrayList<String>();
		String nodeString;
		queue.add(nodeStart);
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
		return visited;
	}
}
