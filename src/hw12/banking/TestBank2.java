package hw12.banking;

public class TestBank2 {
	public static void main(String[] args) {

		Bank bank = new Bank();
		Customer customer1 = new Customer("Tony", "Stark");
		SavingsAccount tonySacc = new SavingsAccount(2000, 0.01);
		CheckingAccount tonyCacc = new CheckingAccount(3000, tonySacc);
		customer1.addAccount(tonySacc);
		customer1.addAccount(tonyCacc);

		Customer customer2 = new Customer("Peter", "Parker");
		CheckingAccount peterCacc = new CheckingAccount(2000);
		customer2.addAccount(peterCacc);

		Customer customer3 = new Customer("Steve", "Rogers");
		SavingsAccount steveSacc = new SavingsAccount(2000, 0.03);
		CheckingAccount steveCacc = new CheckingAccount(1000, steveSacc);
		customer3.addAccount(steveSacc);
		customer3.addAccount(steveCacc);

		bank.addCustomer(customer1);
		bank.addCustomer(customer2);
		bank.addCustomer(customer3);

		System.out.println("Steve의 SavingsAccount " + steveSacc);
		System.out.println("Steve의 CheckingAccount " + steveCacc);

		System.out.println("\n새로운 withdraw 메소드 실험(1400원 인출)");
		steveCacc.withdraw(1400);
		System.out.println("Steve의 SavingsAccount " + steveSacc);
		System.out.println("Steve의 CheckingAccount " + steveCacc);

		System.out.print("\n");

		for (int cus_index = 1; cus_index <= bank.getNumberOfCustomers(); cus_index++) {
			System.out.println(bank.getCustomer(cus_index));
			for (int acc_index = 1; acc_index <= bank.getCustomer(cus_index).getNumOfAccounts(); acc_index++) {
				if (bank.getCustomer(cus_index).getAccount(acc_index) instanceof CheckingAccount)
					System.out.print("계좌 종류: CheckingAccount, ");

				if (bank.getCustomer(cus_index).getAccount(acc_index) instanceof SavingsAccount)
					System.out.print("계좌 종류: SavingsAccount, ");
				System.out.println(bank.getCustomer(cus_index).getAccount(acc_index));
			}

			System.out.print("\n");
		}

		System.out.println("10개월 후 잔액");

		for (int cus_index = 1; cus_index <= bank.getNumberOfCustomers(); cus_index++) {
			System.out.println(bank.getCustomer(cus_index));
			for (int acc_index = 1; acc_index <= bank.getCustomer(cus_index).getNumOfAccounts(); acc_index++) {
				if (bank.getCustomer(cus_index).getAccount(acc_index) instanceof CheckingAccount)
					System.out.print("계좌 종류: CheckingAccount, ");

				if (bank.getCustomer(cus_index).getAccount(acc_index) instanceof SavingsAccount) {
					SavingsAccount sa = (SavingsAccount) bank.getCustomer(cus_index).getAccount(acc_index);
					sa.updateBalance(10);
					System.out.print("계좌 종류: SavingsAccount, ");
				}

				System.out.println(bank.getCustomer(cus_index).getAccount(acc_index));

			}
			System.out.print("\n");
		}
	}
}