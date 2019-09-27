import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class w04_palindrome {

	public static void main(String[] args) {
		// Initialize
		Scanner inputStream = new Scanner(System.in);
		String s1 = new String();

		// Input
		s1 = inputStream.next();

		// Pre-process
		s1 = s1.replace(" ", "");
		s1 = s1.toLowerCase();

		// Output
		System.out.printf("%d\n", palindrome(s1));

		// Finalize
		inputStream.close();
	}

	public static int palindrome(String s) {

		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				list.add(s.substring(i, j));
			}
		}

		Iterator<String> listIterator = list.iterator();
		String si = listIterator.next();
		int p = 0, q = 0, lp = 1, t = 0, f = 0;
		while (true) {
			p = t = f = 0;
			q = si.length() - 1;

			if (si.length() % 2 == 0) {
				while (true) {
					if (si.charAt(p) != si.charAt(q)) {
						f = 1;
						break;
					}
					t++;
					t++;
					if (q == (p + 1))
						break;
					p++;
					q--;

				}
			} else {
				while (true) {
					if (si.charAt(p) != si.charAt(q)) {
						f = 1;
						break;
					}
					if (p == q) {
						t++;
						break;
					}
					t++;
					t++;
					p++;
					q--;
				}
			}

			if (f == 0)
				if (t > lp)
					lp = t;
			// Break
			if (!listIterator.hasNext())
				break;
			else
				si = listIterator.next();
		}
		return lp;
	}

}
