import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		Customer gilDong = new Customer("Hong Gil Dong", "99, Daehak-ro, Yuseong-gu, Daejeon, Republic of Korea");

		Item CPU = new Item(200, "Central Processing Unit");
		Item RAM = new Item(100, "Random Access Memory");

		Order PCBuildOrder = new Order("2019-10-01", "Shipped");

	}
}

class Customer {
	private String name;
	private String address;

	private ArrayList<Order> myOrder;

	public Customer(String name, String address) {
		this.name = name;
		this.address = address;
		this.myOrder = new ArrayList<Order>();
	}

	public void addOrder(Order order) {
		this.myOrder.add(order);
	}

}

class Order {
	private String date;
	private String status;
	private List<OrderDetail> itemList;

	public Order(String date, String status) {
		this.date = date;
		this.status = status;
	}

	public float calcSubTotal() {
		return 0.0f;
	}

	// Getter
	public String getDate() {
		return this.date;
	}

	// Getter
	public String getStatus() {
		return this.status;
	}
}

class OrderDetail {
	private List<Item> items;
}

class Item {

	private float shippingWeight;
	private String description;

	public Item(float shippingWeight, String description) {
		this.shippingWeight = shippingWeight;
		this.description = description;
	}

	public float getPriceForQuantity() {
		// TODO Implement Price Variable
		return 0.0f;
	}

	public float getTax() {
		// TODO Implement Tax Calculation
		return 0.0f;
	}

	public boolean inStock() {
		// TODO Implement Stock Management
		return false;
	}

	// Getter
	public float getShippingWeight() {
		return this.shippingWeight;
	}

	// Getter
	public String getDescription() {
		return this.description;
	}
}

class Payment {
	private float amount;

	public Payment(float amount) {
		this.amount = amount;
	}

	// Getter
	public float getAmount() {
		return this.amount;
	}
}

class Check extends Payment {
	private String name;
	private String bankID;

	public Check(float amount, String name, String bankID) {
		super(amount);
		this.name = name;
		this.bankID = bankID;
	}

	public boolean authorized() {
		// TODO Implement Authorization Method
		return false;
	}

	// Getter
	public String getName() {
		return this.name;
	}

	// Getter
	public String getBankID() {
		return this.bankID;
	}
}

class Cash extends Payment {
	private float cashTendered;

	public Cash(float amount, float cash) {
		super(amount);
		this.cashTendered = cash;
	}

	// Getter
	public float getCashTendered() {
		return this.cashTendered;
	}
}

class Credit extends Payment {
	private int number;
	private String type;
	private String expDate;

	public Credit(float amount, int number, String type, String expDate) {
		super(amount);
		this.number = number;
		this.type = type;
		this.expDate = expDate;
	}

	public boolean authorized() {
		// TODO Implement Authorization Method
		return false;
	}

	// Getter
	public int getNumber() {
		return this.number;
	}

	// Getter
	public String getType() {
		return this.type;
	}

	// Getter
	public String getExpDate() {
		return this.expDate;
	}
}
