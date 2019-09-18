package hw11;


public class Bank {

	private Customer[] customers;
	private int numberOfCustomers;

	/**
	 * Bank 생성자
	 */
	public Bank() {
		numberOfCustomers = 0;
		customers = new Customer[10];
	}

	/**
	 * 생성된 Bank의 customers 배열에 Customer를 추가하는 메소드
	 * 
	 * @param customer
	 */
	public void addCustomer(Customer customer) {
		for (int i = 0; i < 10; i++) {
			if (customers[i] == null) {
				customers[i] = customer;
				numberOfCustomers++;
				break;
			}
		}
	}

	/**
	 * numberOfCustomers 접근자
	 * 
	 * @return
	 */
	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}

	/**
	 * customers의 입력된 index 번째 Customer의 접근자
	 * 
	 * @param index
	 * @return
	 */
	public Customer getCustomer(int index) {
		return customers[index];
	}

}
