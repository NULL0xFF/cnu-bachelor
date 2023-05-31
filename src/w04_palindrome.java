import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class w04_palindrome {

	public static void main(String[] args) {
		// Initialize
		Scanner inputStream = new Scanner(System.in);
		String s = new String();

		// Input
		s = inputStream.next();

		// Output
		System.out.printf("%d\n", palindrome(s));
		// System.out.printf("%d\n", longestPalindrome(s));

		// Finalize
		inputStream.close();
	}

	public static int palindrome(String s) {
		// Preparation
		s = s.replace(" ", "");
		s = s.toLowerCase();

		// Initialize List
		ArrayList<String> list = new ArrayList<String>();

		// Add all substring into list
		for (int i = 0; i < s.length(); i++)
			for (int j = i + 1; j <= s.length(); j++)
				list.add(s.substring(i, j));

		// Initialize Iterator
		Iterator<String> listIterator = list.iterator();
		String si = listIterator.next();

		// Initialize Variable
		int p, q; // p is front pointer, q is rear pointer
		int t, f; // t is current longest palindrome, f is flag
		int lp = 1; // longest palindrome

		// Algorithm
		while (true) {
			// Reset Variable
			p = t = f = 0;
			q = si.length() - 1;

			// Length is even
			if (si.length() % 2 == 0) {
				while (true) {
					if (si.charAt(p) != si.charAt(q)) {
						f = 1; // It is not palindrome, so flag is on
						break;
					}
					// It is palindrome, keep going
					t = t + 2;
					if (q == (p + 1)) // Escape when pointer p, q met
						break;
					p++;
					q--;
				}
			} else { // Length is odd
				while (true) {
					if (si.charAt(p) != si.charAt(q)) {
						f = 1; // It is not palindrome, so flag is on
						break;
					}
					if (p == q) {
						t++;
						break;
					}
					// It is palindrome, keep going
					t = t + 2;
					p++;
					q--;
				}
			}

			// Check Palindrom flag. 0 means it is palindrom, 1 means it isn't palindrome
			if (f == 0)
				if (t > lp) // Save longest palindrome
					lp = t;

			// Break loop when iterator finished
			if (!listIterator.hasNext())
				break;
			else
				si = listIterator.next();
		}

		// Return longest palindrome
		return lp;
	}

}
