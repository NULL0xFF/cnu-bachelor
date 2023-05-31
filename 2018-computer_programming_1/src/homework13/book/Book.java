package homework13.book;

public abstract class Book {

  // 필드 선언
  private static int noOfBooks = 0;
  private final int number;
  private String title;
  private String author;

  /**
   * Book 생성자
   *
   * @param title
   * @param author
   */
  public Book(String title, String author) {
    this.number = ++Book.noOfBooks;
    this.title = title;
    this.author = author;
  }

  /**
   * number 접근자
   *
   * @return
   */
  public int getNumber() {
    return this.number;
  }

  /**
   * title 접근자
   *
   * @return
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * title 설정자
   *
   * @param title
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * author 접근자
   *
   * @return
   */
  public String getAuthor() {
    return this.author;
  }

  /**
   * author 설정자
   *
   * @param author
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * 연체료 추상 메소드
   *
   * @param lateDays
   * @return
   */
  abstract int getLateFee(int lateDays);

  /**
   * 비교 메소드
   */
  @Override
  public boolean equals(Object obj) {
    Book bookObject = (Book) obj;
    return this.title == bookObject.title && this.author == bookObject.title;
  }

  /**
   * toString 출력 메소드
   */
  @Override
  public String toString() {
    return String.format("제목: %s, 작가: %s", this.title, this.author);
  }
}
