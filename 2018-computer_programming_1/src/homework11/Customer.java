package homework11;


public class Customer {

  private final String firstName;
  private final String lastName;
  private BankAccount account;

  /**
   * Customer 생성자
   *
   * @param firstName
   * @param lastName
   */
  public Customer(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * 이름 접근자
   *
   * @return
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * 성씨 접근자
   *
   * @return
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * 생성된 Customer의 account 접근자
   *
   * @return
   */
  public BankAccount getBankAccount() {
    return account;
  }

  /**
   * 생성된 Customer의 account 변경자
   *
   * @param account
   */
  public void setBankAccount(BankAccount account) {
    this.account = account;
  }

  public String toString() {
    return String.format("예금주: %s %s\n잔액: %,d", this.firstName, this.lastName,
        this.account.getBalance());
  }
}
