import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class w06_bitcoin {

	public static void main(String[] args) {

		// Initialize Variable
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

		graph.forEach((k, v) -> Collections.sort(v));

		// Input StartNode
		String nodeStart = inputStream.next();

		// Output Total Time
		System.out.printf("%d", bfsTime(graph, nodeStart));

		// Finalize
		inputStream.close();
		return;

	}

	private static int bfsTime(HashMap<String, ArrayList<String>> graph, String nodeStart) {
		// Initialize Start Node as ArrayList
		ArrayList<String> nodeStartList = graph.get(nodeStart);

		// Initialize Variable
		List<ArrayList<String>> visited = new ArrayList<ArrayList<String>>();
		List<ArrayList<String>> queue = new ArrayList<ArrayList<String>>();

		// Add Start Node List to Queue
		queue.add(nodeStartList);

		// BFS
		ArrayList<String> nodeList;
		while (!queue.isEmpty()) {
			nodeList = queue.remove(0);
			if (!visited.contains(nodeList)) {
				visited.add(nodeList);
				for (int i = 0; i < nodeList.size(); i++) {
					queue.add(graph.get(nodeList.get(i)));
				}
			} else {
			}
		}
		return visited.size();
	}
}
