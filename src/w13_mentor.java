import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class w13_mentor {

	private static int NUMBER_OF_MENTOR = 3;
	public static void main(String[] args) {
		// Initialize
		Scanner inputStreamScanner = new Scanner(System.in);

		int numberOfNode = inputStreamScanner.nextInt();

		HashMap<String, HashMap<String, Integer>> graph = new HashMap<String, HashMap<String, Integer>>();
		HashMap<String, HashMap<String, Integer>> flowMap = new HashMap<String, HashMap<String, Integer>>();
		HashMap<String, Integer> recordMap = new HashMap<String, Integer>();

		String inputString;
		int year;
		for (int i = 0; i < numberOfNode; i++) {
			inputString = inputStreamScanner.next();
			year = inputStreamScanner.nextInt();
			recordMap.put(inputString, year);
			graph.put(inputString, new HashMap<String, Integer>());
			flowMap.put(inputString, new HashMap<String, Integer>());
		}

		String startNode = "START", endNode = "END";
		graph.put(startNode, new HashMap<String, Integer>());
		flowMap.put(startNode, new HashMap<String, Integer>());
		graph.put(endNode, new HashMap<String, Integer>());
		flowMap.put(endNode, new HashMap<String, Integer>());

		for (String firstNode : recordMap.keySet()) {
			for (String secondNode : recordMap.keySet()) {
				if (firstNode == secondNode)
					continue;
				else {
					if (recordMap.get(firstNode) > recordMap.get(secondNode)) {
						if (!graph.containsKey(secondNode + "-"))
							graph.put(secondNode + "-", new HashMap<String, Integer>());
						if (!flowMap.containsKey(secondNode + "-"))
							flowMap.put(secondNode + "-", new HashMap<String, Integer>());
						graph.get(firstNode).put(secondNode + "-", 1);
						// graph.get(secondNode + "-").put(firstNode, 1);
						flowMap.get(firstNode).put(secondNode + "-", 0);
						// flowMap.get(secondNode + "-").put(firstNode, 0);
						// END
						graph.get(secondNode + "-").put(endNode, NUMBER_OF_MENTOR);
						// graph.get(endNode).put(secondNode + "-", 3);
						flowMap.get(secondNode + "-").put(endNode, 0);
						// flowMap.get(endNode).put(secondNode + "-", 0);
					}
				}
			}
			// START
			graph.get(startNode).put(firstNode, NUMBER_OF_MENTOR);
			// graph.get(firstNode).put(startNode, 3);
			flowMap.get(startNode).put(firstNode, 0);
			// flowMap.get(firstNode).put(startNode, 0);
		}

		HashMap<String, String> parentMap = new HashMap<>();
		String nodeU, nodeV;
		int maxFlow = 0;
		int currentFlow;
		while (bfs(graph, flowMap, startNode, endNode, parentMap)) {
			currentFlow = Integer.MAX_VALUE;
			nodeV = endNode;
			while (true) {
				nodeU = parentMap.get(nodeV);
				if (nodeU == null) {
					if (nodeV.equals(startNode))
						break;
					inputStreamScanner.close();
					throw new RuntimeException("start node not found");
				} else if (nodeV.equals(startNode)) {
					break;
				}
				currentFlow = Math.min(currentFlow, graph.get(nodeU).get(nodeV) - flowMap.get(nodeU).get(nodeV));
				nodeV = nodeU;
			}
			nodeV = endNode;
			while (true) {
				nodeU = parentMap.get(nodeV);
				if (nodeU == null) {
					if (nodeV.equals(startNode))
						break;
					inputStreamScanner.close();
					throw new RuntimeException("start node not found");
				} else if (nodeV.equals(startNode)) {
					break;
				}
				flowMap.get(nodeU).replace(nodeV, flowMap.get(nodeU).get(nodeV) + currentFlow);
				// flowMap.get(nodeV).replace(nodeU, flowMap.get(nodeV).get(nodeU) - currentFlow);
				nodeV = nodeU;
			}
			if (currentFlow == Integer.MAX_VALUE) {
				inputStreamScanner.close();
				throw new RuntimeException("flow calculation failed");
			}
//			flowMap.forEach((K, V) ->{
//				System.out.printf(K + ": ");
//				V.forEach((K2, V2)->{
//					System.out.printf("( %s, %d ) ", K2, V2);
//				});
//				System.out.printf("\n");
//			});
			maxFlow = maxFlow + currentFlow;
		}

		// Output
		System.out.println(numberOfNode * NUMBER_OF_MENTOR - maxFlow);
//		System.out.printf("%d\n", totalData % maxFlow == 0 ? totalData / maxFlow : (totalData / maxFlow) + 1);

		// Finalize
		inputStreamScanner.close();
		return;
	}

	private static boolean bfs(HashMap<String, HashMap<String, Integer>> graph,
			HashMap<String, HashMap<String, Integer>> flowMap, String startNode, String endNode,
			HashMap<String, String> parentMap) {
		// Initialize
		parentMap.clear();

		ArrayList<String> visited = new ArrayList<String>();
		ArrayList<String> queue = new ArrayList<String>();

		String currentNode;
		queue.add(startNode);
		parentMap.put(startNode, null);
		while (!queue.isEmpty()) {
			currentNode = queue.remove(0);
			if (!visited.contains(currentNode)) {
				visited.add(currentNode);
				for (String nextNode : graph.get(currentNode).keySet()) {
					if (!visited.contains(nextNode)) {
						if (graph.get(currentNode).get(nextNode) - flowMap.get(currentNode).get(nextNode) > 0) {
							if (nextNode.equals(endNode)) {
								parentMap.put(endNode, currentNode);
								break;
							}
							parentMap.put(nextNode, currentNode);
							queue.add(nextNode);
						}
					}
				}
			}
		}
		if (parentMap.get(endNode) != null) {
			return true;
		}
		return false;
	}

}
