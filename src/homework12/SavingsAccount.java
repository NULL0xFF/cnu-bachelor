package homework12;

public class SavingsAccount extends BankAccount {

  // 필드 선언
  private final double interestRate;

  /**
   * SavingsAccount 생성자
   *
   * @param balance
   * @param interestRate
   */
  public SavingsAccount(int balance, double interestRate) {
    super(balance);
    this.interestRate = interestRate;
  }

  /**
   * updateBalance 메소드
   *
   * @param period
   */
  public void updateBalance(int period) {
    // 단리 원리금 = [원금*이율*기간] + 원금
    this.balance = (int) ((this.balance * this.interestRate * period) + this.balance);
  }
}
