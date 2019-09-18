package hw13.book;

public class Novel extends Book {

	/**
	 * Novel 생성자
	 * 
	 * @param title
	 * @param author
	 */
	public Novel(String title, String author) {
		super(title, author);
	}

	/**
	 * 연체료 부과 메소드
	 */
	int getLateFee(int lateDays) {
		return (300 * lateDays);
	}

}
