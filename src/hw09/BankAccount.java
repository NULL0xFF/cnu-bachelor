package hw09;

class BankAccount {

	private int balance;

	/**
	 * 입력값 확인 후 생성된 오브젝트(this)의 잔고에 값 추가(+)
	 * 
	 * @param input
	 */
	public void deposit(int input) {

		if (input >= 0) {
			balance = balance + input;
		} else {
			System.out.print("잘못 입력하셨습니다.\n");
		}
		return;

	}

	/**
	 * 입력값 확인 후 생성된 오브젝트(this)의 잔고가 충분할 경우 입력값 제거(-)
	 * 
	 * @param input
	 */
	public void withdraw(int input) {

		if (input >= 0) {
			if (balance - input >= 0) {
				balance = balance - input;
			} else {
				System.out.print("잔액이 부족합니다.\n");
			}
		} else {
			System.out.print("잘못 입력하셨습니다.\n");
		}
		return;

	}

	/**
	 * 입력값(amount)확인 후 생성된 오브젝트(this)의 잔고가 충분할 경우 입력값을 특정 계좌(otherAccount)의 잔고에 값 이동
	 * 
	 * @param amount
	 * @param otherAccount
	 */
	public void transfer(int amount, BankAccount otherAccount) {

		if (amount >= 0) {
			if (balance >= amount) {
				balance = balance - amount;
				otherAccount.balance = otherAccount.balance + amount;
			} else {
				System.out.print("잔액이 부족합니다.\n");
			}
		} else {
			System.out.print("잘못 입력하셨습니다.\n");
		}

	}

	/**
	 * 생성된 오브젝트(this)의 잔고 접근 메소드
	 * 
	 * @return
	 */
	public int getBalance() {

		return balance;

	}

}
