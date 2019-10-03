import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class w05_merge_sort {

	private static int count;

	public static void main(String[] args) {
		// Initialize
		Scanner inputStream = new Scanner(System.in);

		// Input
		int n = inputStream.nextInt();
		count = inputStream.nextInt();
		char flag = inputStream.next().charAt(0);
		ArrayList<Character> array = new ArrayList<Character>();
		for (int l = 0; l < n; l++)
			array.add(inputStream.next().charAt(0));

		// Algorithm
		switch (flag) {
		case 'A':
			array = assendingMergeSort(array);
			break;
		case 'D':
			array = decendingMergeSort(array);
			break;
		}

		// Output
		for (int i = 0; i < n; i++)
			System.out.printf("%c ", array.get(i));

		// Finalize
		inputStream.close();
	}

	public static ArrayList<Character> assendingMergeSort(ArrayList<Character> list) {
		// Exception
		if (list.size() <= 1)
			return list;

		ArrayList<Character> left = new ArrayList<Character>();
		ArrayList<Character> right = new ArrayList<Character>();
		int middle;
		if (list.size() % 2 == 0)
			middle = list.size() / 2;
		else
			middle = list.size() / 2 + 1;
		for (int i = 0; i < middle; i++) {
			left.add(list.get(i));
		}
		for (int i = middle; i < list.size(); i++) {
			right.add(list.get(i));
		}
		left = assendingMergeSort(left);
		right = assendingMergeSort(right);
		return assendingMerge(left, right);
	}

	public static ArrayList<Character> decendingMergeSort(ArrayList<Character> list) {
		// Exception
		if (list.size() <= 1)
			return list;

		ArrayList<Character> left = new ArrayList<Character>();
		ArrayList<Character> right = new ArrayList<Character>();
		int middle;
		if (list.size() % 2 == 0)
			middle = list.size() / 2;
		else
			middle = list.size() / 2 + 1;
		for (int i = 0; i < middle; i++) {
			left.add(list.get(i));
		}
		for (int i = middle; i < list.size(); i++) {
			right.add(list.get(i));
		}
		left = decendingMergeSort(left);
		right = decendingMergeSort(right);
		return decendingMerge(left, right);
	}

	public static ArrayList<Character> assendingMerge(ArrayList<Character> left, ArrayList<Character> right) {
		ArrayList<Character> list = new ArrayList<Character>();
		Iterator<Character> leftIterator = left.iterator();
		Iterator<Character> rightIterator = right.iterator();
		char leftChar = leftIterator.next();
		char rightChar = rightIterator.next();
		if (count != 0)
			while (true) {
				if (leftChar <= rightChar) {
					list.add(leftChar);
					leftChar = '\0';
					if (leftIterator.hasNext())
						leftChar = leftIterator.next();
					else
						break;
				} else {
					list.add(rightChar);
					rightChar = '\0';
					if (rightIterator.hasNext())
						rightChar = rightIterator.next();
					else
						break;
				}
			}
		if (leftChar != '\0') {
			while (true) {
				list.add(leftChar);
				if (!leftIterator.hasNext())
					break;
				leftChar = leftIterator.next();
			}
		}
		if (rightChar != '\0') {
			while (true) {
				list.add(rightChar);
				if (!rightIterator.hasNext())
					break;
				rightChar = rightIterator.next();
			}
		}
		if (count != 0)
			count--;
		return list;
	}

	public static ArrayList<Character> decendingMerge(ArrayList<Character> left, ArrayList<Character> right) {
		ArrayList<Character> list = new ArrayList<Character>();
		Iterator<Character> leftIterator = left.iterator();
		Iterator<Character> rightIterator = right.iterator();
		char leftChar = leftIterator.next();
		char rightChar = rightIterator.next();
		if (count != 0)
			while (true) {
				if (rightChar <= leftChar) {
					list.add(leftChar);
					leftChar = '\0';
					if (leftIterator.hasNext())
						leftChar = leftIterator.next();
					else
						break;
				} else {
					list.add(rightChar);
					rightChar = '\0';
					if (rightIterator.hasNext())
						rightChar = rightIterator.next();
					else
						break;
				}
			}
		if (leftChar != '\0') {
			while (true) {
				list.add(leftChar);
				if (!leftIterator.hasNext())
					break;
				leftChar = leftIterator.next();
			}
		}
		if (rightChar != '\0') {
			while (true) {
				list.add(rightChar);
				if (!rightIterator.hasNext())
					break;
				rightChar = rightIterator.next();
			}
		}
		if (count != 0)
			count--;
		return list;
	}

}
