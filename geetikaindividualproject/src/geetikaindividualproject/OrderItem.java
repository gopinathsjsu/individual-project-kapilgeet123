package geetikaindividualproject;

public class OrderItem {
	
	private String name;
	
	private int quantity;
	
	private double price;
	
	private String creditCard;

	public OrderItem(String name, int quantity, String creditCard) {
		
		this.name = name;
		this.quantity = quantity;
		this.creditCard = creditCard;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	@Override
	public String toString() {
		return "OrderItem [name=" + name + ", quantity=" + quantity + ", creditCard=" + creditCard + "]";
	}
	
}
