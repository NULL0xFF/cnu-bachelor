package homework12;

public class BankAccount {

  // 필드 선언
  protected int balance;

  /**
   * BankAccount 생성자
   *
   * @param balance
   */
  public BankAccount(int balance) {
    this.balance = balance;
  }

  /**
   * deposit 메소드
   *
   * @param amount
   */
  public void deposit(int amount) {
    if (amount >= 0) {
      this.balance = this.balance + amount;
    }
  }

  /**
   * withdraw 메소드
   *
   * @param amount
   * @return
   */
  public boolean withdraw(int amount) {
    if (amount >= 0 && this.balance >= amount) {
      this.balance = this.balance - amount;
      return true;
    } else {
      return false;
    }
  }

  /**
   * getBalance 메소드
   *
   * @return
   */
  public int getBalance() {
    return this.balance;
  }

  /**
   * transfer 메소드
   *
   * @param amount
   * @param acc
   * @return
   */
  public boolean transfer(int amount, BankAccount acc) {
    if (amount >= 0 && this.balance >= amount) {
      this.balance = this.balance - amount;
      acc.balance = acc.balance + amount;
      return true;
    } else {
      return false;
    }
  }

  /**
   * toString 오버라이드 메소드
   */
  @Override
  public String toString() {
    return String.format("잔액: %d", this.balance);
  }
}
