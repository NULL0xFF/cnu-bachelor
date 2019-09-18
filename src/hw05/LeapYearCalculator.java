package hw05;

import java.util.Scanner;

/**
 * 입력 연도가 윤년인지 아닌지 확인하는 프로그램 작성
 * 
 * 조건: 윤년은 4의 배수이어야 한다 (LeapYear == 4의 배수)
 * 
 * 윤년은 100의 배수가 아니어야 한다 (LeapYear != 100의 배수)
 * 
 * 400의 배수는 "무조건" 윤년이 된다 (LeapYear == 400의 배수)
 */
public class LeapYearCalculator {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		// Declaration
		int inputYearValue = 0; // 입력 값 변수 초기화
		int fourMultiplier_int; // 4의 배수
		int oneHundredMultiplier_int; // 100의 배수
		int fourHundredMultiplier_int; // 400의 배수
		// Input
		System.out.printf("연도를 입력하세요: ");
		inputYearValue = input.nextInt();
		// Calculation
		fourMultiplier_int = inputYearValue % 4; // 4의 배수를 나머지로 판단
		oneHundredMultiplier_int = inputYearValue % 100; // 100의 배수를 나머지로 판단
		fourHundredMultiplier_int = inputYearValue % 400; // 400의 배수를 나머지로 판단
		// Output
		if (fourHundredMultiplier_int == 0) {
			System.out.printf("%d는 윤년인가요?: %b", inputYearValue, true); // 400의 배수일 경우 출력
		} else if (fourMultiplier_int == 0 && oneHundredMultiplier_int != 0) {
			System.out.printf("%d는 윤년인가요?: %b", inputYearValue, true); // 4의 배수이지만 100의 배수가 아닐 경우 출력
		} else {
			System.out.printf("%d는 윤년인가요?: %b", inputYearValue, false); // 그 이외의 값일 경우 출력
		}
	}
}