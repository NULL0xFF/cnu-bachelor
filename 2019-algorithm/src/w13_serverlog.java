import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TimeZone;

public class w13_serverlog {

	public static void main(String[] args) throws ParseException {
		// Initialize
		Scanner inputStreamScanner = new Scanner(System.in);
		ArrayList<String> userList = new ArrayList<String>();
		ArrayList<Date> recordList;
		HashMap<Date, String> recordMap = new HashMap<>();
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
		dateTimeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date criterionDate;
		String inputString, outputString;
		String[] userLogArray;
		int numberOfUsers, numberOfRecords;

		// Input start
		numberOfUsers = inputStreamScanner.nextInt();
		numberOfRecords = inputStreamScanner.nextInt();
		for (int userCount = 0; userCount < numberOfUsers; userCount++) {
			userList.add(inputStreamScanner.next());
		}
		inputString = inputStreamScanner.nextLine(); // Delete '\n' from input stream buffer
		for (int recordCount = 0; recordCount < numberOfRecords; recordCount++) {
			inputString = inputStreamScanner.nextLine();
			userLogArray = inputString.split(" ");
			recordMap.put(dateTimeFormat.parse(userLogArray[1]), userLogArray[0]);
		}
		criterionDate = dateTimeFormat.parse(inputStreamScanner.nextLine());

		// Input end
		inputStreamScanner.close();

		// Sort record
		recordList = new ArrayList<Date>(recordMap.keySet());
		Collections.sort(recordList);

		// Find case
		outputString = "Internal";
		for (int recordCount = 0; recordCount < recordList.size(); recordCount++) {
			if (recordList.get(recordCount).compareTo(criterionDate) > 0)
				break;
			outputString = recordMap.get(recordList.get(recordCount));
		}

		// Output result
		System.out.println(outputString);

		// End of program
  }

}
