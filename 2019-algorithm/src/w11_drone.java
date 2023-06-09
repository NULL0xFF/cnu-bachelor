import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class w11_drone {

	public final static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// Initialize
		Scanner inputStream = new Scanner(System.in);
		HashMap<String, HashMap<String, Integer>> graph = new HashMap<String, HashMap<String, Integer>>();
		HashMap<String, Integer> dict = new HashMap<>();

		// Create Graph
		int n, m;
		n = inputStream.nextInt();
		m = inputStream.nextInt();
		String s1;
		for (int i = 0; i < n; i++) {
			s1 = inputStream.next();
			graph.put(s1, new HashMap<String, Integer>());
		}
		int d;
		for (int i = 0; i < n; i++) {
			s1 = inputStream.next();
			d = inputStream.nextInt();
			dict.put(s1, d);
		}
		String s2;
		for (int i = 0; i < m; i++) {
			s1 = inputStream.next();
			s2 = inputStream.next();
			d = inputStream.nextInt();
			if (!graph.get(s1).containsKey(s2)) {
				graph.get(s1).put(s2, d);
				graph.get(s2).put(s1,d);
			} else if (d < graph.get(s1).get(s2)) {
				graph.get(s1).replace(s2, d);
				graph.get(s2).replace(s1, d);
			}
		}

		// Input Source and Destination
		String source = inputStream.next();
		String destination = inputStream.next();

		/* Dijkstra Algorithm */
		// Initialize
		HashMap<String, Integer> dist = new HashMap<String, Integer>();
		HashMap<String, String> prev = new HashMap<String, String>();
		HashSet<String> Q = new HashSet<String>();

		// Set-Up
		dist.put(source, 0); // Distance from source to source is set to 0
		prev.put(source, "");
		for (String key : graph.keySet()) {
			if (!key.equals(source)) {
				dist.put(key, INF); // Unknown distance function from source to each node set to infinity
				prev.put(key, "");
			}
			Q.add(key); // All nodes initially in Q
		}

		// Loop
		String minNode;
		int minNodeDistance;
		int altDistance;
		while (!Q.isEmpty()) {
			minNode = "";
			minNodeDistance = INF;
			for (String node : Q) { // In the first run-through, this vertex is the source node
				if (dist.get(node) < minNodeDistance) {
					minNode = node;
					minNodeDistance = dist.get(node);
				}
			}
			Q.remove(minNode);

			HashMap<String, Integer> minNodeMap = graph.get(minNode);
			for (String key : minNodeMap.keySet()) {
				if (Q.contains(key)) {
					altDistance = minNodeDistance + graph.get(minNode).get(key) + dict.get(minNode);
					if (altDistance < dist.get(key)) {
						dist.replace(key, altDistance);
						prev.put(key, minNode);
					}
				}
			}
		}
		/* End of Dijkstra Algorithm */

		// Previous Search
		StringBuilder builder = new StringBuilder();
		String node = destination;
		while (true) {
			builder.insert(0, node);
			if (prev.get(node).equals(source)) {
				builder.insert(0, " ");
				builder.insert(0, source);
				break;
			} else {
				node = prev.get(node);
				builder.insert(0, " ");
			}
		}

		// Output
		System.out.printf("%s\n", builder);
		System.out.printf("%d\n", dist.get(destination) - dict.get(source));

		// Finalize
		inputStream.close();

		// Return Main
  }

}
