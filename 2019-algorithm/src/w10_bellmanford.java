import java.util.HashMap;
import java.util.Scanner;

public class w10_bellmanford {

	public final static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// Initialize
		Scanner inputStream = new Scanner(System.in);
		HashMap<String, HashMap<String, Integer>> graph = new HashMap<String, HashMap<String, Integer>>();

		// Create Graph
		int n, m;
		n = inputStream.nextInt();
		m = inputStream.nextInt();
		String s1;
		for (int i = 0; i < n; i++) {
			s1 = inputStream.next();
			graph.put(s1, new HashMap<String, Integer>());
		}
		String s2;
		int d;
		for (int i = 0; i < m; i++) {
			s1 = inputStream.next();
			s2 = inputStream.next();
			d = inputStream.nextInt();
			if (!graph.get(s1).containsKey(s2)) {
				graph.get(s1).put(s2, d);
			} else if (d < graph.get(s1).get(s2)) {
				graph.get(s1).replace(s2, d);
			}
		}

		// Input Source and Destination
		String source = inputStream.next();
		String destination = inputStream.next();

		/* Bellman-Ford Algorithm */
		// Initialize
		HashMap<String, Integer> dist = new HashMap<String, Integer>();
		HashMap<String, String> prev = new HashMap<String, String>();

		// Step 1:
		for (String key : graph.keySet()) {
			if (key == source || key.equals(source)) {
				dist.put(key, 0);
			} else {
				dist.put(key, null);
			}
			prev.put(key, "");
		}

		// Step 2:
		for (int i = 1; i < graph.keySet().size(); i++) {
			for (String u : graph.keySet()) {
				for (String v : graph.get(u).keySet()) {
					if (dist.get(v) == null && dist.get(u) != null) {
						dist.put(v, dist.get(u) + graph.get(u).get(v));
						dist.replace(v, dist.get(u) + graph.get(u).get(v));
						prev.replace(v, u);
					} else if (dist.get(v) != null && dist.get(u) != null) {
						if (dist.get(v) > dist.get(u) + graph.get(u).get(v)) {
							dist.put(v, dist.get(u) + graph.get(u).get(v));
							dist.replace(v, dist.get(u) + graph.get(u).get(v));
							prev.replace(v, u);
						}
					}
				}
			}
		}

		// Step 3:
		for (String u : graph.keySet()) {
			for (String v : graph.get(u).keySet()) {
				if (dist.get(v) > dist.get(u) + graph.get(u).get(v)) {
					System.out.print("Negative Cycle!");
					inputStream.close();
					return;
				}
			}
		}
		/* End of Bellman-Ford Algorithm */

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
		System.out.printf("%d\n", dist.get(destination));

		// Finalize
		inputStream.close();

		// Return Main
  }

}
