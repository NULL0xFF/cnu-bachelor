import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class w10_dijkstra {
	final static int INF = Integer.MAX_VALUE;

	private static class Result {
		HashMap<String, Integer> distances = new HashMap<>();
		HashMap<String, String> preNode = new HashMap<>();
	}

	private static Result dijkstra(HashMap<String, HashMap<String, Integer>> graph, String source) {
		HashMap<String, Integer> distances = new HashMap<>();
		HashMap<String, String> preNode = new HashMap<>();

		distances.put(source, 0);
		preNode.put(source, "");

		HashSet<String> Q = new HashSet<>();

		for (String key : graph.keySet()) {
			Q.add(key);
			if (!key.equals(source)) {
				distances.put(key, INF);
				preNode.put(key, "");
			}
		}

		while (!Q.isEmpty()) {
			String minNode = "";
			int minNodeDistance = INF;
			for (String node : Q) {
				if (distances.get(node) < minNodeDistance) {
					minNode = node;
					minNodeDistance = distances.get(node);
				}
			}
			Q.remove(minNode);

			HashMap<String, Integer> minNodeMap = graph.get(minNode);
			for (String key : minNodeMap.keySet()) {
				int distance = minNodeDistance + minNodeMap.get(key);
				if (distance < distances.get(key)) {
					distances.put(key, distance);
					preNode.put(key, minNode);
				}
			}
		}

		Result result = new Result();
		result.distances.putAll(distances);
		result.preNode.putAll(preNode);

		return result;
	}

	public static void main(String[] args) {
		// Initialize
		Scanner inputStream = new Scanner(System.in);

		// Create Graph
		HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();
		int n, m;
		n = inputStream.nextInt();
		m = inputStream.nextInt();
		for (int i = 0; i < n; i++)
			graph.put(inputStream.next(), new HashMap<>());
		String s1, s2;
		int k;
		for (int i = 0; i < m; i++) {
			s1 = inputStream.next();
			s2 = inputStream.next();
			k = inputStream.nextInt();
			if (graph.get(s1).containsKey(s2)) {
				if (k < graph.get(s1).get(s2))
					graph.get(s1).put(s2, k);
			} else
				graph.get(s1).put(s2, k);
		}

		// Input
		String nodeStart = inputStream.next();
		String nodeEnd = inputStream.next();

		/* InputTest */
		// Iterator<String> graphIterator = graph.keySet().iterator();
		// Iterator<String> graphIteratorInner;
		// while (graphIterator.hasNext()) {
		// s1 = graphIterator.next();
		// System.out.printf("%s: ", s1);
		// graphIteratorInner = graph.get(s1).keySet().iterator();
		// while (graphIteratorInner.hasNext()) {
		// s2 = graphIteratorInner.next();
		// System.out.printf("(%s %d) ", s2, graph.get(s1).get(s2));
		// }
		// System.out.printf("\n");
		// }
		// System.out.printf("start: %s\nend: %s", nodeStart, nodeEnd);

		// Dijkstra Algorithm
		Result result = dijkstra(graph, nodeStart);

		// Distance Stop Check
		int distance = result.distances.get(nodeEnd);
		ArrayList<String> stops = new ArrayList<>();
		String curNode = nodeEnd;
		stops.add(nodeEnd);
		while (!result.preNode.get(curNode).isEmpty()) {
			curNode = result.preNode.get(curNode);
			stops.add(curNode);
		}

		// Output
		for (int i = stops.size() - 1; i >= 0; i--)
			if (i != 0)
				System.out.printf("%s ", stops.get(i));
			else
				System.out.printf("%s", stops.get(i));
		System.out.printf("\n%d", distance);

		// Finalize
		inputStream.close();
		return;
	}
}