import java.util.Scanner;

public class w01_stdin {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.printf("%s", scanner.nextLine());
		
		scanner.close();
	}

}
