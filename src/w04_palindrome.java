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

		// Test case
		// s = "abaabc";

		// Output
		System.out.printf("%d\n", palindrome(s));
		// System.out.printf("%d\n", longestPalindrome(s));

		// Finalize
		inputStream.close();
	}

	public static int longestPalindrome(String s) {
		int sl = s.length();
		int lp = 0;
		boolean[][] boolTable = new boolean[sl][sl];

		debugPrint(s, boolTable, 0, 0);
		System.out.printf("\n");
		for (int i = 0; i < sl; i++) {
			for (int j = 0; j < sl - i; j++) {
				if (i < 2) {
					System.out.printf("i\tj\ts[%d]\ts[%d]\tb[%d][%d]\n", j, i + j, j, i + j);
					System.out.printf("%d\t%d\t%c\t%c\t", i, j, s.charAt(j), s.charAt(i + j));
					if (s.charAt(j) == s.charAt(i + j)) {
						boolTable[j][i + j] = true;
						lp = i + 1;
					} else
						boolTable[j][i + j] = false;
					System.out.printf("%b\n\n", boolTable[j][i + j]);
					debugPrint(s, boolTable, i, j);
					System.out.printf("\n\n");
				} else {
					System.out.printf("i\tj\ts[%d]\ts[%d]\tb[%d][%d]\tb[%d][%d]\n", j, i + j, j + 1, i + j - 1, j,
							i + j);
					System.out.printf("%d\t%d\t%c\t%c\t%b\t", i, j, s.charAt(j), s.charAt(i + j),
							boolTable[j + 1][i + j - 1]);
					if (s.charAt(j) == s.charAt(i + j) && boolTable[j + 1][i + j - 1]) {
						boolTable[j][i + j] = true;
						lp = i + 1;
					} else
						boolTable[j][i + j] = false;
					System.out.printf("%b\n\n", boolTable[j][i + j]);
					debugPrint(s, boolTable, i, j);
					System.out.printf("\n\n");
				}
			}
		}

		return lp;
	}

	public static void debugPrint(String s, boolean[][] table, int hi, int hj) {

		for (int i = 0; i <= s.length(); i++)
			System.out.printf("########");
		System.out.printf("\n");

		StringBuilder builder = new StringBuilder("\t");

		for (int i = 0; i < s.length(); i++)
			builder.append(String.format("%c (%d)\t", s.charAt(i), i));
		builder.append("\n");

		for (int i = 0; i < s.length(); i++) {
			builder.append(String.format("%c (%d)\t", s.charAt(i), i));
			for (int j = 0; j < s.length(); j++) {
				if (i == hi && j == hj)
					builder.append(String.format("%b ←\t", table[i][j]));
				else
					builder.append(String.format("%b\t", table[i][j]));
			}
			builder.append("\n");
		}
		System.out.printf(builder.toString());
		for (int i = 0; i <= s.length(); i++)
			System.out.printf("########");
		System.out.printf("\n");
	}

	public static int palindrome(String s) {
		// Preparation
		s = s.replace(" ", "");
		s = s.toLowerCase();

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
