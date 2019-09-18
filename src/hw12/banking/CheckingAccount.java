package hw12.banking;

public class CheckingAccount extends BankAccount {

	// 필드 선언
	SavingsAccount protectedBy;

	/**
	 * CheckingAccount 생성자
	 * 
	 * @param balance
	 */
	public CheckingAccount(int balance) {
		super(balance);
	}

	/**
	 * CheckingAccount 메소드
	 * 
	 * @param balance
	 * @param psa
	 */
	public CheckingAccount(int balance, SavingsAccount psa) {
		super(balance);
		protectedBy = psa;
	}

	/**
	 * withdraw 오버라이드 메소드
	 */
	@Override
	public boolean withdraw(int amount) {
		if (amount >= 0 && super.withdraw(amount) == false) {
			protectedBy.withdraw(amount);
			return true;
		} else {
			return false;
		}
	}

}
