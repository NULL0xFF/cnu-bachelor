import java.util.ArrayList;
import java.util.Scanner;

public class w04_anagram {

	public static void main(String[] args) {
		// Initialize
		Scanner inputStream = new Scanner(System.in);
		String s1 = new String();
		String s2 = new String();

		// Input
		s1 = inputStream.next();
		s2 = inputStream.next();

		// Output
		System.out.printf("%s\n", anagram(s1, s2));

		// Finalize
		inputStream.close();
	}

	public static String anagram(String s1, String s2) {
		// Exception
		if (s1.length() != s2.length())
			return "False";

		// Initialize
		int totalLength = s1.length();
		int index = 0;
		char c = '\0';

		// Convert String
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
				return "False";
			charList.remove(index);
		}

		// Return
		return "True";
	}

}
