import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class w05_anagram_sort {

	public static void main(String[] args) {
		// Initialize
		Scanner inputStream = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		HashMap<Integer, ArrayList<String>> anagramMap = new HashMap<Integer, ArrayList<String>>();

		// Input
		String inputString = inputStream.nextLine();
		String[] inputStringArray = inputString.split(" ");

		// Processing
    Collections.addAll(list, inputStringArray);
		Collections.sort(list);

		// Algorithm
		Iterator<String> listIterator = list.iterator();
		ArrayList<String> tempList = new ArrayList<String>();
		tempList.add(listIterator.next());
		anagramMap.put(0, tempList);
		String iteratedString = listIterator.next();
		boolean flag = false;
		int i = 0;
		while (true) {
			flag = false;
			for (i = 0; i < anagramMap.size(); i++) {
				if ((anagram(anagramMap.get(i).get(0), iteratedString))) {
					anagramMap.get(i).add(iteratedString);
					flag = true;
					break;
				}
			}
			if (!flag) {
				tempList = new ArrayList<String>();
				tempList.add(iteratedString);
				anagramMap.put(i, tempList);
			}
			if (!listIterator.hasNext())
				break;
			iteratedString = listIterator.next();
		}

		// Output
		StringBuilder stringBuilder = new StringBuilder();
		for (i = 0; i < anagramMap.size(); i++) {
			tempList = anagramMap.get(i);
			for (int j = 0; j < tempList.size(); j++) {
				stringBuilder.append(String.format("%s ", tempList.get(j)));
			}
			stringBuilder.append("\n");
		}
		System.out.printf("%s\n", stringBuilder);

		// Finalize
		inputStream.close();
	}

	public static boolean anagram(String s1, String s2) {
		// Exception
		if (s1.length() != s2.length())
			return false;

		// Initialize
		int totalLength = s1.length();
		int index = 0;
		char c = '\0';

		// Convert String to LowerCase
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();

		// Register Characters from s2
		ArrayList<Character> charList = new ArrayList<Character>();
		for (int i = 0; i < totalLength; i++)
			charList.add(s2.charAt(i));

		// Delete Character from list
		for (int i = 0; i < totalLength; i++) {
			c = s1.charAt(i);
			index = charList.indexOf(c);
			if (index == -1)
				return false;
			charList.remove(index);
		}

		// Return
		return true;
	}

}
