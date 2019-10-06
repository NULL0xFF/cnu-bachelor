import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class w05_merge_sort {

	private static int count = 0;

	public static ArrayList<Character> mergeSort(ArrayList<Character> charList, char flag) {
		// Recursion Escape
		if (charList.size() <= 1)
			return charList;

		// Initialize Variable
		ArrayList<Character> leftList = new ArrayList<>();
		ArrayList<Character> rightList = new ArrayList<>();
		int m = charList.size() / 2;
		for (int index = 0; index < m; index++) {
			leftList.add(charList.get(index));
		}
		for (int index = m; index < charList.size(); index++) {
			rightList.add(charList.get(index));
		}

		// Recursion
		leftList = mergeSort(leftList, flag);
		rightList = mergeSort(rightList, flag);

		// Return
		return merge(leftList, rightList, flag);
	}

	public static ArrayList<Character> merge(ArrayList<Character> leftList, ArrayList<Character> rightList, char flag) {
		// Initialize Variable
		ArrayList<Character> mergedList = new ArrayList<>();

		// Escape
		if (count == 0) {
			leftList.forEach(e -> mergedList.add(e));
			rightList.forEach(e -> mergedList.add(e));
			return mergedList;
		}

		// Merge Two Lists
		switch (flag) {
		case 'A':
			while (!leftList.isEmpty() && !rightList.isEmpty()) {
				if (leftList.get(0) <= rightList.get(0)) {
					mergedList.add(leftList.remove(0));
				} else {
					mergedList.add(rightList.remove(0));
				}
			}
			while (!leftList.isEmpty()) {
				mergedList.add(leftList.remove(0));
			}
			while (!rightList.isEmpty()) {
				mergedList.add(rightList.remove(0));
			}
			break;
		case 'D':
			while (!leftList.isEmpty() && !rightList.isEmpty()) {
				if (leftList.get(0) >= rightList.get(0)) {
					mergedList.add(leftList.remove(0));
				} else {
					mergedList.add(rightList.remove(0));
				}
			}
			while (!rightList.isEmpty()) {
				mergedList.add(rightList.remove(0));
			}
			while (!leftList.isEmpty()) {
				mergedList.add(leftList.remove(0));
			}
			break;
		}

		// Count
		count--;

		// Return
		return mergedList;
	}

	public static void main(String[] args) {
		// Initialize Variable
		Scanner inputStreamScanner = new Scanner(System.in);

		// Input
		int numberOfInput = inputStreamScanner.nextInt();
		count = inputStreamScanner.nextInt();
		char flag = inputStreamScanner.next().charAt(0);
		ArrayList<Character> charList = new ArrayList<>();
		for (int index = 0; index < numberOfInput; index++)
			charList.add(inputStreamScanner.next().charAt(0));

		// Merge Sort
		charList = mergeSort(charList, flag);

		// Output
		Iterator<Character> listIterator = charList.iterator();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(listIterator.next());
		while (listIterator.hasNext())
			stringBuilder.append(" " + listIterator.next());
		System.out.println(stringBuilder.toString());

		// Finalize
		inputStreamScanner.close();
	}

}
