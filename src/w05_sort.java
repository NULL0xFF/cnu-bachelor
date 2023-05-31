import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class w05_sort {

	public static void main(String[] args) {
		// Initialize
		ArrayList<String> list = new ArrayList<String>();
		Scanner inputStream = new Scanner(System.in);

		// Input
		int n = inputStream.nextInt();
		String flag = inputStream.next();
		for (int l = 0; l < n; l++)
			list.add(inputStream.next());

		Collections.sort(list);
		if (flag.equals("D"))
			Collections.reverse(list);

		// Output
		StringBuilder resultBuilder = new StringBuilder();
		Iterator<String> listIterator = list.iterator();
		String iteratedString = listIterator.next();
		while (true) {
			resultBuilder.append(String.format("%s ", iteratedString));
			if (!listIterator.hasNext())
				break;
			iteratedString = listIterator.next();
		}
		System.out.printf("%s\n", resultBuilder.toString());

		// Finalize
		inputStream.close();
	}

}
