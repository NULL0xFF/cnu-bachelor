package homework10;


public class BankAccount {

  private String owner = "";
  private String accountNumber = "";
  private int balance;

  /**
   * BankAccount 생성자
   *
   * @param owner
   * @param accountNumber
   */
  public BankAccount(String owner, String accountNumber) {
    this.owner = owner;
    this.accountNumber = accountNumber;
    this.balance = 0;
  }

  /**
   * 예금주, 계좌 번호, 잔액 리턴 메소드
   */
  public String toString() {
    return String.format("%s, %s, 잔액: %,d", this.getOwner(), this.getAccountNumber(),
        this.getBalance());
  }

  /**
   * 입력값 확인 후 생성된 오브젝트(this)의 잔고에 값 추가(+)
   *
   * @param amount
   */
  public void deposit(int amount) {
    if (amount >= 0) {
      balance = balance + amount;
    } else {
      System.out.print("입력 오류\n");
    }
  }

  /**
   * 입력값 확인 후 생성된 오브젝트(this)의 잔고가 충분할 경우 잔고에서 입력값 제거(-)후 true 리턴.
   * <p>
   * 잔고가 불충분할 경우 false 만 리턴
   *
   * @param amount
   * @return
   */
  public boolean withdraw(int amount) {
    if (amount >= 0) {
      if (balance - amount >= 0) {
        balance = balance - amount;
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  /**
   * 입력값(amount)확인 후 생성된 오브젝트(this)의 잔고가 충분할 경우 입력값을 특정 계좌(otherAccount)의 잔고에 값 이동 후 true 리턴
   * <p>
   * 잔고가 불충분할 경우 false 만 리턴
   *
   * @param amount
   * @param otherAccount
   */

  public boolean transfer(int amount, BankAccount otherAccount) {
    if (amount >= 0) {
      if (balance >= amount) {
        balance = balance - amount;
        otherAccount.balance = otherAccount.balance + amount;
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  /**
   * 생성된 오브젝트(this)의 예금주(owner) 접근 메소드
   *
   * @return
   */
  public String getOwner() {
    return owner;
  }

  /**
   * 생성된 오브젝트(this)의 계좌 번호(accountNumber) 접근 메소드
   *
   * @return
   */
  public String getAccountNumber() {
    return accountNumber;
  }

  /**
   * 생성된 오브젝트(this)의 잔고(balance) 접근 메소드
   *
   * @return
   */
  public int getBalance() {
    return balance;
  }
}
