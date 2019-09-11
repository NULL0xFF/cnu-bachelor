import java.util.Scanner;

public class w01_controlflow {

	public static void main(String[] args) {
		
		// Initialize Variables
		Scanner inputStream = new Scanner(System.in);
		int i = 0;

		// Input Value(Integer)
		i = inputStream.nextInt();
		
		// Value Check
		if (i <= 0) {
			inputStream.close();
			throw new IllegalArgumentException();
		}

		// Output
		if (i % 2 == 0)
			for (int loop = 0; loop < i; loop++)
				System.out.printf("Hello, Contest!\n");
		else
			for (int loop = 0; loop < i + 1; loop++)
				System.out.printf("Hello, Algorithm!\n");

		// Finalize
		inputStream.close();

	}

}
