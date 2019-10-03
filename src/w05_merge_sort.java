import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * https://docs.google.com/presentation/d/17-K8qSlahKU4GLAuVT4ztNQZKtmAfG7S8PJXEu2j0GA/edit#slide=id.g64768c5060_0_36
 */
public class w05_merge_sort {

	public static ArrayList<String> mergeSort(ArrayList<String> stringList, char flag) {
		ArrayList<String> leftList = new ArrayList<>();
		ArrayList<String> rightList = new ArrayList<>();
		return merge(leftList, rightList);
	}

	public static ArrayList<String> merge(ArrayList<String> leftList, ArrayList<String> rightList) {
		ArrayList<String> mergedList = new ArrayList<>();
		return mergedList;
	}

	public static void main(String[] args) {
		// Initialize Variable
		Scanner inputStreamScanner = new Scanner(System.in);

		// Input
		int numberOfInput = inputStreamScanner.nextInt();
		char flag = inputStreamScanner.next().charAt(0);
		ArrayList<String> stringList = new ArrayList<>();
		for (int index = 0; index < numberOfInput; index++)
			stringList.add(inputStreamScanner.next());

		// Merge Sort
		stringList = mergeSort(stringList, flag);

		// Output
		Iterator<String> listIterator = stringList.iterator();
		StringBuilder stringBuilder = new StringBuilder(listIterator.next());
		while (listIterator.hasNext())
			stringBuilder.append(" " + listIterator.next());
		System.out.println(stringBuilder.toString());

		// Finalize
		inputStreamScanner.close();
	}

}
