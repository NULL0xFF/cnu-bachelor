package hw03;

import java.util.Scanner;
public class TemperatureConverter {
	private static Scanner input = new Scanner (System.in);
	public static void main(String[] args) {
		// Declaration
		String s1 = "화씨 온도를 입력하세요 : ";
		String s2 = ("섭씨 온도는 %f °C 입니다");
		// I/O
		System.out.print(s1);
		System.out.printf(s2 + "\n", tempconv());
		// Scanner Close (End Phase)
		input.close();
	}
	private static float tempconv() {
		// Declaration
		float f1 = 0f;
		float f2 = 0f;
		// I/O
		f1 = input.nextFloat();
		f2 = (5f / 9f) * (f1 - 32);
		// Return Calculated Result
		return f2;
	}
}