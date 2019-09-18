package hw10;


public class Car {

	private double speed;
	private final static double MAX_SPEED = 125.0;
	private String color = new String();

	/**
	 * Car 생성자
	 * 
	 * @param color
	 */
	public Car(String color) {
		this.speed = 0.0;
		this.color = color;
	}

	/**
	 * 속도(speed) 접근 메소드
	 * 
	 * @return
	 */
	public double getSpeed() {
		return mileToKilo(speed);
	}

	/**
	 * Car의 최고 속도(MAX_SPEED) 접근 정적 메소드
	 * 
	 * @return
	 */
	public static double getMaxSpeed() {
		return mileToKilo(MAX_SPEED);
	}

	/**
	 * 색상(color) 접근 메소드
	 * 
	 * @return
	 */
	public String getColor() {
		return color;
	}

	/**
	 * 입력된 속도(speed)의 유효성을 판단 후, 가능하다면 해당 오브젝트의 속도(this.speed)에 지역 변수인 입력된
	 * 속도(speed)를 추가한 수 true를 리턴한다.
	 * 
	 * 불가능 할 경우, false만 리턴한다.
	 * 
	 * @param speed
	 * @return
	 */
	public boolean speedUp(double speed) {
		speed = kiloToMile(speed);
		if (speed < 0 || speed > MAX_SPEED) {
			return false;
		} else {
			this.speed = this.speed + speed;
			return true;
		}
	}

	/**
	 * km2mile 단위 변환 메소드
	 * 
	 * @param distance
	 * @return
	 */
	private static double kiloToMile(double distance) {
		return distance * (1 / 1.6);
	}

	/**
	 * mile2km 단위 변환 메소드
	 * 
	 * @param distance
	 * @return
	 */
	private static double mileToKilo(double distance) {
		return distance * 1.6;
	}

}
