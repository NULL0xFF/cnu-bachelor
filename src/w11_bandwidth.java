import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class w11_bandwidth {

	private static boolean bfs(HashMap<String, HashMap<String, Integer>> graph, String startNode, String endNode,
			HashMap<String, String> parent) {
		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();

		// for (String node : graph.keySet())
		// visited.put(node, false);
		
		parent.clear();
		
		ArrayList<String> queue = new ArrayList<String>();
		String nodeString;
		queue.add(startNode);
		parent.put(startNode, null);
		while (!queue.isEmpty()) {
			nodeString = queue.remove(0);
			if (!visited.containsKey(nodeString)) {
				visited.put(nodeString, true);
				for (String node : graph.get(nodeString).keySet()) {
					queue.add(node);
					parent.put(node, nodeString);
				}
			}
		}

		if (visited.containsKey(endNode))
			if (visited.get(endNode) == true)
				return true;
		return false;
	}

	@SuppressWarnings("unused")
	private static boolean capacityCheck(HashMap<String, HashMap<String, Integer>> f) {
		for (String startNode : f.keySet()) {
			for (String endNode : f.get(startNode).keySet()) {
				if (f.get(startNode).get(endNode) == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private static int Ford_Fulkerson(HashMap<String, HashMap<String, Integer>> graph, String serverNode,
			String clientNode) {
		HashMap<String, HashMap<String, Integer>> f = new HashMap<String, HashMap<String, Integer>>();

		graph.forEach((startNode, edgeMap) -> {
			edgeMap.forEach((endNode, bandwidth) -> {
				if (!f.containsKey(startNode)) {
					HashMap<String, Integer> edgeMapPointer = new HashMap<String, Integer>();
					edgeMapPointer.put(endNode, bandwidth);
					f.put(startNode, edgeMapPointer);
				} else if (!f.get(startNode).containsKey(endNode)) {
					f.get(startNode).put(endNode, bandwidth);
				} else {

				}
				if (!f.containsKey(endNode)) {
					HashMap<String, Integer> edgeMapPointer = new HashMap<String, Integer>();
					edgeMapPointer.put(startNode, bandwidth);
					f.put(endNode, edgeMapPointer);
				} else if (!f.get(endNode).containsKey(startNode)) {
					f.get(endNode).put(startNode, bandwidth);
				} else {

				}
			});
		});

		HashMap<String, String> parentMap = new HashMap<String, String>(); // Used by BFS, store Path
		int max_flow = 0;
		String currentNode = null;
		String forwardNode = null;
		while (bfs(f, serverNode, clientNode, parentMap)) {
			int path_flow = Integer.MAX_VALUE;
			currentNode = serverNode;
			while (!currentNode.equals(clientNode)) {
				forwardNode = parentMap.get(currentNode);
				path_flow = Math.min(path_flow, graph.get(currentNode).get(forwardNode));
				currentNode = forwardNode;
			}
			System.out.printf("%d\n", path_flow);
		}
		return max_flow;
	}

	public static void main(String[] args) {
		Scanner inputStreamScanner = new Scanner(System.in);

		int numberOfNode = inputStreamScanner.nextInt();
		int numberOfEdge = inputStreamScanner.nextInt();
		int totalData = inputStreamScanner.nextInt();

		HashMap<String, HashMap<String, Integer>> graph = new HashMap<String, HashMap<String, Integer>>();
		for (int i = 0; i < numberOfNode; i++)
			graph.put(inputStreamScanner.next(), new HashMap<String, Integer>());

		String startNode, endNode;
		int bandwidth;
		for (int i = 0; i < numberOfEdge; i++) {
			startNode = inputStreamScanner.next();
			endNode = inputStreamScanner.next();
			bandwidth = inputStreamScanner.nextInt();
			if (graph.get(startNode).containsKey(endNode)) {
				graph.get(startNode).replace(endNode, graph.get(startNode).get(endNode) + bandwidth);
				graph.get(endNode).replace(startNode, graph.get(endNode).get(startNode) + bandwidth);
			} else {
				graph.get(startNode).put(endNode, bandwidth);
				graph.get(endNode).put(startNode, bandwidth);
			}
		}

		String serverNode = inputStreamScanner.next();
		String clientNode = inputStreamScanner.next();

		// Print Graph
		graph.forEach((startN, V) -> {
			System.out.printf("%s: ", startN);
			V.forEach((endN, bandInt) -> {
				System.out.printf("(%s, %d) ", endN, bandInt);
			});
			System.out.printf("\n");
		});

		System.out.printf("%.2f\n", (float) totalData / (float) Ford_Fulkerson(graph, serverNode, clientNode));

		// Finalize
		inputStreamScanner.close();
	}

}
