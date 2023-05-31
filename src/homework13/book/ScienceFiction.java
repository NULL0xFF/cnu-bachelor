package homework13.book;

public class ScienceFiction extends Book {

  /**
   * ScienceFiction 생성자
   *
   * @param title
   * @param author
   */
  public ScienceFiction(String title, String author) {
    super(title, author);
  }

  /**
   * 연체료 부과 메소드
   */
  int getLateFee(int lateDays) {
    return (600 * lateDays);
  }
}
