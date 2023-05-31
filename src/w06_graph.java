import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class w06_graph {

	public static void main(String[] args) {
		// Initialize
		Scanner inputStream = new Scanner(System.in);

		// Graph Scale
		int n = inputStream.nextInt();
		int m = inputStream.nextInt();

		// Create Graph
		HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < n; i++) {
			graph.put(inputStream.next(), new ArrayList<String>());
		}
		String edgeStart, edgeEnd;
		for (int i = 0; i < m; i++) {
			edgeStart = inputStream.next();
			edgeEnd = inputStream.next();
			if (!graph.get(edgeStart).contains(edgeEnd)) {
				graph.get(edgeStart).add(edgeEnd);
			}
			if (!graph.get(edgeEnd).contains(edgeStart)) {
				graph.get(edgeEnd).add(edgeStart);
			}
		}

		// Output
		System.out.printf("%d", graph.get(inputStream.next()).size());

		// Finalize
		inputStream.close();
	}

}
