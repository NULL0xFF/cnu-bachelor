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

		int totalLength = s1.length();
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		
		ArrayList<Character> charList = new ArrayList<Character>();
		for (int i = 0; i < totalLength; i++)
			charList.add(s2.charAt(i));

		int index = 0;
		char c = '\0';
		for (int i = 0; i < totalLength; i++) {
			c = s1.charAt(i);
			index = charList.indexOf(c);
			if (index == -1)
				return "False";
			charList.remove(index);
		}
			
		return "True";
	}

}
