import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class w04_kakao {

	public static void main(String[] args) {
		// Initialize
		Scanner inputStream = new Scanner(System.in);
		String s = new String();
		ArrayList<String> scoreToken;

		// Input
		s = inputStream.next();

		// Tokenizer
		scoreToken = scoreTokenizer(s);

		// Output
		System.out.printf("%d\n", dartGame(scoreToken));

		// Finalize
		inputStream.close();
	}

	public static int dartGame(ArrayList<String> scoreToken) {
		// Initialize
		Iterator<String> tokenIterator = scoreToken.iterator();
		String currentToken;
		int currentScore, totalScore = 0;
		int mult = 1, pow = 1;
		char checkOpt = '\0';
		char scorePow, scoreMult;

		// Algorithm
		while (true) {
			currentToken = tokenIterator.next();
			checkOpt = currentToken.charAt(currentToken.length() - 1);
			if (checkOpt == '*' || checkOpt == '#') {
				currentScore = Integer.parseInt(currentToken.substring(0, currentToken.length() - 2));
				scorePow = currentToken.charAt(currentToken.length() - 2);
				scoreMult = currentToken.charAt(currentToken.length() - 1);
			} else {
				currentScore = Integer.parseInt(currentToken.substring(0, currentToken.length() - 1));
				scorePow = currentToken.charAt(currentToken.length() - 1);
				scoreMult = '\0';
			}

			switch (scorePow) {
			case 'S':
				pow = 1;
				break;
			case 'D':
				pow = 2;
				break;
			case 'T':
				pow = 3;
			}
			switch (scoreMult) {
			case '*':
				currentScore = (int) Math.pow(currentScore, pow) * 2 * mult;
				mult = 2;
				break;
			case '#':
				currentScore = (int) Math.pow(currentScore, pow) * -1 * mult;
				mult = 1;
				break;
			case '\0':
				currentScore = (int) Math.pow(currentScore, pow) * mult;
				mult = 1;
			}
			totalScore = totalScore + currentScore;
			// Escape
			if (!tokenIterator.hasNext())
				break;
		}

		// Return
		return totalScore;

	}

	/**
	 * Split String into String Array using Regular Expression
	 * 
	 * @param str
	 * @return scoreToken
	 */
	public static ArrayList<String> scoreTokenizer(String str) {
		// Regular Expression
		Pattern p = Pattern.compile("(\\d)+[SDT][*#]?");
		Matcher m = p.matcher(str);

		// Initialize
		ArrayList<String> scoreToken = new ArrayList<>();

		// Tokenize
		while (true)
			if (m.find())
				scoreToken.add(m.group());
			else
				break;

		return scoreToken;
	}

}
