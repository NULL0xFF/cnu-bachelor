import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class w13_position {

	public static void main(String[] args) {
		Scanner inputStreamScanner = new Scanner(System.in);

		HashMap<String, ArrayList<String>> favoriteMap = new HashMap<>();

		ArrayList<String> listPointer;
		int numberOfPosition = inputStreamScanner.nextInt();
		for (int i = 0; i < numberOfPosition; i++) {
			listPointer = new ArrayList<String>();
			favoriteMap.put(inputStreamScanner.next(), listPointer);
			for (int j = 0; j < numberOfPosition; j++)
				listPointer.add(inputStreamScanner.next());
		}

		HashMap<String, ArrayList<String>> rankMap = new HashMap<>();
		for (int i = 0; i < numberOfPosition; i++) {
			listPointer = new ArrayList<String>();
			rankMap.put(inputStreamScanner.next(), listPointer);
			for (int j = 0; j < numberOfPosition; j++)
				listPointer.add(inputStreamScanner.next());
		}

		// favoriteMap.forEach((player, list) -> {
		// System.out.printf("%s: ", player);
		// list.forEach(position -> {
		// System.out.printf("%s ", position);
		// });
		// System.out.printf("\n");
		// });
		// rankMap.forEach((position, list) -> {
		// System.out.printf("%s: ", position);
		// list.forEach(player -> {
		// System.out.printf("%s ", player);
		// });
		// System.out.printf("\n");
		// });

		StableMarriageProblem(favoriteMap, rankMap, numberOfPosition);

		inputStreamScanner.close();
	}

	private static HashMap<String, String> StableMarriageProblem(HashMap<String, ArrayList<String>> ladies,
			HashMap<String, ArrayList<String>> gentlemen, int number) {

		HashMap<String, String> matchMap = new HashMap<String, String>();
		HashMap<String, ArrayList<String>> ladyQueueMap = new HashMap<>();

		boolean flag = true;

		while (true) {
			// Escape
			if (matchMap.size() == number)
				break;

			// Add gentlemen to ladies' queue
			for (String gentleman : gentlemen.keySet()) {
				if (!gentlemen.get(gentleman).isEmpty()) {
					if (!ladyQueueMap.containsKey(gentlemen.get(gentleman).get(0)))
						ladyQueueMap.put(gentlemen.get(gentleman).get(0), new ArrayList<>());
					ladyQueueMap.get(gentlemen.get(gentleman).get(0)).add(gentleman);
				}
			}

			flag = true;

			for (String lady : ladies.keySet()) {
				while (true) {
					if (!ladyQueueMap.containsKey(lady))
						break;
					if (ladyQueueMap.get(lady).isEmpty())
						break;
					if (ladies.get(lady).get(0).equals(ladyQueueMap.get(lady).get(0))) {
						matchMap.put(ladyQueueMap.get(lady).get(0), lady);
						break;
					} else {
						// Denied
						gentlemen.get(ladyQueueMap.get(lady).get(0)).remove(lady);
						ladyQueueMap.get(lady).remove(0);
						flag = false;
					}
				}
			}

			// No denial
			if (flag)
				break;

			// Denied

		}
		return matchMap;
	}

}
