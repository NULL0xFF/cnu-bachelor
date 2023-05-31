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

		HashMap<String, String> matchMap = StableMarriageProblem(favoriteMap, rankMap);
		System.out.println(matchMap.get(inputStreamScanner.next()));
		
		inputStreamScanner.close();
	}

	private static HashMap<String, String> StableMarriageProblem(HashMap<String, ArrayList<String>> gentlemen,
			HashMap<String, ArrayList<String>> ladies) {

		HashMap<String, String> matchMap = new HashMap<>();
		HashMap<String, ArrayList<String>> ladyQueueMap;
		ArrayList<String> unselectedList, selectedList;

		while (true) {
			// Escape
			if (matchMap.size() >= gentlemen.size() - 1)
				break;

			// Initialize
			ladyQueueMap = new HashMap<>();
			unselectedList = new ArrayList<>();
			selectedList = new ArrayList<>();

			// Initialize queue
			for (String lady : ladies.keySet())
				ladyQueueMap.put(lady, new ArrayList<String>());

			// Register queue
			for (String gentleman : gentlemen.keySet())
				ladyQueueMap.get(gentlemen.get(gentleman).get(0)).add(gentleman);


			// Check queue
			for (String lady : ladyQueueMap.keySet()) {
				while (!ladyQueueMap.get(lady).isEmpty()) {
					if (ladyQueueMap.get(lady).get(0).equals(ladies.get(lady).get(0))) {
						matchMap.put(ladyQueueMap.get(lady).get(0), lady);
						selectedList.add(ladyQueueMap.get(lady).remove(0));
					} else {
						unselectedList.add(ladyQueueMap.get(lady).remove(0));
					}
				}
			}
			
			for(String unselected : unselectedList) {
				gentlemen.get(unselected).remove(0);
			}
			
		}
		
		for(String lady : ladies.keySet()) {
			if(!matchMap.containsValue(lady)) {
				for(String gentleman : gentlemen.keySet()) {
					if(!matchMap.containsKey(gentleman)) {
						matchMap.put(gentleman, lady);
					}
				}
			}
		}
		return matchMap;
	}

}
