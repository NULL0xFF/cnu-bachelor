package homework11;


public class TestBank {

  public static void main(String[] args) {

    // Bank 객체 생성
    Bank koreaBank = new Bank();

    // 3개의 Customer 객체 생성 후 Bank 객체에 연결
    // http://random-name-generator.info 에서 생성된 이름들
    Customer customer01 = new Customer("Nelson", "Harry");
    Customer customer02 = new Customer("Adams", "Louise");
    Customer customer03 = new Customer("Walker", "Justin");
    koreaBank.addCustomer(customer01);
    koreaBank.addCustomer(customer02);
    koreaBank.addCustomer(customer03);

    // 각 고객의 BankAccount 생성 후 Customer 객체들에게 연결
    BankAccount account01 = new BankAccount(75000);
    BankAccount account02 = new BankAccount(50000);
    BankAccount account03 = new BankAccount(100000);
    customer01.setBankAccount(account01);
    customer02.setBankAccount(account02);
    customer03.setBankAccount(account03);

    // 잔액이 가장 큰 Account와 작은 Account를 maxBalanceAccount와 minBalanceAccount에
    // BankAccount 형식으로 저장한다.
    BankAccount maxBalanceAccount = koreaBank.getCustomer(0).getBankAccount();
    BankAccount minBalanceAccount = koreaBank.getCustomer(0).getBankAccount();
    for (int i = 0; i < 3; i++) {
      if (maxBalanceAccount.getBalance() < koreaBank.getCustomer(i).getBankAccount().getBalance()) {
        maxBalanceAccount = koreaBank.getCustomer(i).getBankAccount();
      }
      if (minBalanceAccount.getBalance() > koreaBank.getCustomer(i).getBankAccount().getBalance()) {
        minBalanceAccount = koreaBank.getCustomer(i).getBankAccount();
      }
    }

    // 잔액이 가장 많은 Account의 잔액의 반을 가장 적은 Account로 계좌이체
    maxBalanceAccount.transfer(maxBalanceAccount.getBalance() / 2, minBalanceAccount);

    System.out.printf("%s\n", customer01);
    System.out.printf("%s\n", customer02);
    System.out.printf("%s\n", customer03);

    System.out.printf("총 계좌 수: %d", koreaBank.getNumberOfCustomers());
  }
}
