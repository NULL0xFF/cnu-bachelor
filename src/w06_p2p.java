import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class w06_p2p {

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
		System.out.printf("%d", longestLength(graph, nodeStart));

		// Finalize
		inputStream.close();
	}

	private static int longestLength(HashMap<String, ArrayList<String>> graph, String nodeStart) {
		class Cache {
			String value;
			int index;

			Cache(String V, int I) {
				this.value = V;
				this.index = I;
			}
		}
		// Exception
		if (!graph.containsKey(nodeStart))
			return -1;

		// Initialize
		int longestPath = 0;

		// BFS
		HashMap<String, Integer> visited = new HashMap<String, Integer>();
		List<Cache> queue = new ArrayList<Cache>();
		Cache node;
		queue.add(new Cache(nodeStart, 0));
		while (!queue.isEmpty()) {
			node = queue.remove(0);
			if (!visited.containsKey(node.value))
				visited.put(node.value, node.index);
			else if (node.index >= visited.get(node.value))
				continue;

			for (int i = 0; i < graph.get(node.value).size(); i++)
				queue.add(new Cache(graph.get(node.value).get(i), node.index + 1));

		}

		ArrayList<Integer> pathList = new ArrayList<Integer>(visited.values());
		Iterator<Integer> pathListIterator = pathList.iterator();
		int searchedPath;
		while (pathListIterator.hasNext()) {
			searchedPath = pathListIterator.next();
			if (longestPath < searchedPath)
				longestPath = searchedPath;
		}

		// Return
		return longestPath;
	}
}
