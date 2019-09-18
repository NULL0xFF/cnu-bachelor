package hw04;

import java.util.Scanner;
public class Cylinder {
	private static Scanner input = new Scanner (System.in);
	public static void main(String[] args) {
		// Declaration
		double radius = 0.0;
		double height = 0.0;
		// Input
		System.out.printf("원기둥 밑면의 반지름을 입력하세요(cm) : ");
		radius = input.nextDouble();
		System.out.printf("원기둥의 높이를 입력하세요(cm) : ");
		height = input.nextDouble();
		// Output
		System.out.printf("밑면의 넓이는 %fcm^2 이고, 원기둥의 부피는 %fcm^3 입니다", base_area(radius), cylinder_volume(radius, height));
	}
	private static double base_area (double radius) {
		// Declaration
		double area = 0.0;
		// Calculation
		area = Math.pow(radius, 2) * Math.PI;
		// Output
		return area;
	}
	private static double cylinder_volume (double radius, double height) {
		// Declaration
		double area = base_area(radius);
		double volume = 0.0;
		// Calculation
		volume = area * height;
		// Output		
		return volume;
	}
}