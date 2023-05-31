package homework12;

public class Bank {

  // 필드 선언
  private final Customer[] customers;
  private int numberOfCustomers;

  /**
   * Bank 생성자
   */
  public Bank() {
    this.customers = new Customer[10];
    this.numberOfCustomers = 0;
  }

  /**
   * addCustomer 메소드
   *
   * @param customer
   */
  public void addCustomer(Customer customer) {
    if (this.numberOfCustomers < 11) {
      this.customers[this.numberOfCustomers] = customer;
      this.numberOfCustomers++;
    }
  }

  /**
   * getNumberOfCustomers 메소드
   *
   * @return
   */
  public int getNumberOfCustomers() {
    return this.numberOfCustomers;
  }

  /**
   * getCustomer 메소드
   *
   * @param index
   * @return
   */
  public Customer getCustomer(int index) {
    return this.customers[index - 1];
  }
}
