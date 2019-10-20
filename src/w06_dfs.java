import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class w06_dfs {

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
		List<String> visitedDFS = dfs(graph, nodeStart);
		StringBuilder builder = new StringBuilder();
		while (!visitedDFS.isEmpty()) {
			builder.append(visitedDFS.remove(0));
			if (!visitedDFS.isEmpty())
				builder.append(" ");
		}
		System.out.printf("%s", builder.toString());

		// Finalize
		inputStream.close();
		return;

	}

	private static List<String> dfs(HashMap<String, ArrayList<String>> graph, String nodeStart) {
		List<String> visited = new ArrayList<String>();
		Deque<String> stack = new ArrayDeque<String>();
		String nodeString;
		stack.push(nodeStart);
		while (!stack.isEmpty()) {
			nodeString = stack.pop();
			if (!visited.contains(nodeString)) {
				visited.add(nodeString);
				Collections.sort(graph.get(nodeString));
				for (int i = graph.get(nodeString).size(); i > 0; i--) {
					if (!visited.contains(graph.get(nodeString).get(i - 1)))
						stack.push(graph.get(nodeString).get(i - 1));
				}
			}
		}
		return visited;
	}
}
