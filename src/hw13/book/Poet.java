package hw13.book;

public class Poet extends Book {

	/**
	 * Poet 생성자
	 * 
	 * @param title
	 * @param author
	 */
	public Poet(String title, String author) {
		super(title, author);
	}

	/**
	 * 연체료 부과 메소드
	 */
	int getLateFee(int lateDays) {
		return (200 * lateDays);
	}

}
