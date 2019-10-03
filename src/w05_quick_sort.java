import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class w05_quick_sort {

	private static int count = 0;

	public static ArrayList<Character> quickSort(ArrayList<Character> charList, int low, int high, char flag) {
		if (count == 0)
			return charList;
		if (low < high) {
			int partitionIndex = partition(charList, low, high, flag);
			if (count == 0)
				return charList;
			quickSort(charList, low, partitionIndex - 1, flag);
			quickSort(charList, partitionIndex + 1, high, flag);
		}
		return charList;
	}

	public static int partition(ArrayList<Character> charList, int low, int high, char flag) {
		char tempChar = '\0';
		char pivotChar = charList.get(high);
		int i = (low - 1);
		for (int index = low; index <= (high - 1); index++) {
			switch (flag) {
			case 'A':
				if (charList.get(index) <= pivotChar) {
					i++;
					tempChar = charList.get(index);
					charList.set(index, charList.get(i));
					charList.set(i, tempChar);
				}
				break;
			case 'D':
				if (charList.get(index) >= pivotChar) {
					i++;
					tempChar = charList.get(index);
					charList.set(index, charList.get(i));
					charList.set(i, tempChar);
				}

			}
		}
		tempChar = charList.get(i + 1);
		charList.set(i + 1, charList.get(high));
		charList.set(high, tempChar);

		count--;
		return (i + 1);
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
		charList = quickSort(charList, 0, numberOfInput - 1, flag);

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
