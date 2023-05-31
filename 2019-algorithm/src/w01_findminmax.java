import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class w01_findminmax {

	public static void main(String[] args) {

		// Initialize Variables
		int[] nki;
		String inputString;
		String[] parseString;
		ArrayList<Integer> inputArray;
		Scanner inputStream = new Scanner(System.in);

		// Input n, k, i
		inputString = inputStream.nextLine();
		parseString = inputString.split(" ");
		if (parseString.length != 3) {
			inputStream.close();
			throw new IllegalArgumentException("input(1) n k i error");
		}
		nki = new int[3];
		for (int loop = 0; loop < 3; loop++)
			nki[loop] = Integer.parseInt(parseString[loop]);

		// Input Numbers
		inputString = inputStream.nextLine();
		parseString = inputString.split(" ");
		if (parseString.length != nki[0]) {
			inputStream.close();
			throw new IllegalArgumentException("input(2) size error");
		}
		inputArray = new ArrayList<Integer>();
		for (int loop = 0; loop < nki[0]; loop++) {
			inputArray.add(Integer.parseInt(parseString[loop]));
		}

		// Sort Array
		Collections.sort(inputArray);

		// Get Result
		System.out.printf("%d\n", inputArray.get(inputArray.size() - nki[2]) - inputArray.get(nki[1] - 1));

		// Finalize
		inputStream.close();
	}

}
