package homework12;

public class Customer {

  // 필드 선언
  private final String firstName;
  private final String lastName;
  private final BankAccount[] accounts;
  private int numberOfAccounts;

  /**
   * Customer 생성자
   *
   * @param firstName
   * @param lastName
   */
  public Customer(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.numberOfAccounts = 0;
    this.accounts = new BankAccount[5];
  }

  /**
   * getFirstName 접근자
   *
   * @return
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * getLastName 접근자
   *
   * @return
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * addAccount 메소드
   *
   * @param acc
   */
  public void addAccount(BankAccount acc) {
    if (this.numberOfAccounts < 6) {
      this.accounts[this.numberOfAccounts] = acc;
      this.numberOfAccounts++;
    }
  }

  /**
   * getAccount 접근자
   *
   * @param index
   * @return
   */
  public BankAccount getAccount(int index) {
    return this.accounts[index - 1];
  }

  /**
   * getNumOfAccounts 접근자
   *
   * @return
   */
  public int getNumOfAccounts() {
    return this.numberOfAccounts;
  }

  /**
   * toString 오버라이드 메소드
   */
  @Override
  public String toString() {
    return String.format("이름: %s %s, 계좌의 개수: %d", this.firstName, this.lastName,
        this.numberOfAccounts);
  }
}
