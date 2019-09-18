package hw11;


public class BankAccount {

	private int balance;

	/**
	 * BankAccount 생성자
	 * 
	 * @param balance
	 */
	public BankAccount(int amount) {
		this.balance = amount;
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
	 * 
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
	 * 생성된 오브젝트(this)의 잔고(balance) 접근 메소드
	 * 
	 * @return
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * 입력값(amount)확인 후 생성된 오브젝트(this)의 잔고가 충분할 경우 입력값을 특정 계좌(otherAccount)의 잔고에 값 이동
	 * 후 true 리턴
	 * 
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

}
