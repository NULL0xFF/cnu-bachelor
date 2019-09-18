package hw06;

import java.util.Scanner;

/**
 * RockPaperScissors Game
 * 
 * 가위바위보 게임
 * 
 * 두 사람이 하는 가위바위보 게임을 만들어보자. 두 사람의 이름은 ‘철수’와 ‘영희’이다. 철수와 영희가 입력받은 문자열을 입력받은 후 누가
 * 이겼는지 판별하여 승자를 출력해보자.
 * 
 * @author 201802162지명하
 * @version 1.0
 */
public class RSP {
	// Global Declaration
	private static String cheolsu = "";
	private static String yeonghui = "";
	private static String result = "";
	private static Scanner input = new Scanner(System.in);

	// Custom Methods
	private static void rps_calculation() {
		// Declaration
		byte cheolsu_byte = 0;
		byte yeonghui_byte = 0;
		// Call Byte Translation Method
		cheolsu_byte = rps_byte_translation(cheolsu);
		yeonghui_byte = rps_byte_translation(yeonghui);
		// Calculation
		if (cheolsu_byte == 0 || yeonghui_byte == 0) {
			result = "판단 불가";
		} else if (cheolsu_byte == yeonghui_byte) {
			result = "무승부";
		} else if (cheolsu_byte == 1 && yeonghui_byte == 2) {
			result = "영희";
		} else if (cheolsu_byte == 1 && yeonghui_byte == 3) {
			result = "철수";
		} else if (cheolsu_byte == 2 && yeonghui_byte == 1) {
			result = "철수";
		} else if (cheolsu_byte == 2 && yeonghui_byte == 3) {
			result = "영희";
		} else if (cheolsu_byte == 3 && yeonghui_byte == 1) {
			result = "영희";
		} else if (cheolsu_byte == 3 && yeonghui_byte == 2) {
			result = "철수";
		}
		return;
	}

	private static byte rps_byte_translation(String input_string) {
		switch (input_string) {
		case "가위":
			return 1;
		case "바위":
			return 2;
		case "보":
			return 3;
		default:
			return 0;
		}
	}

	// Main Method
	public static void main(String[] args) {
		// Introduce Game
		System.out.println("가위바위보 게임입니다. 가위, 바위, 보 중에서 입력하세요.");
		// Input
		System.out.print("철수 >> ");
		cheolsu = input.next();
		System.out.print("영희 >> ");
		yeonghui = input.next();
		// Call Method
		rps_calculation();
		// Output
		System.out.printf("Winner? %s", result);
	}

}
