package geetikaindividualproject;

import java.time.LocalDateTime;
import java.util.HashSet;

public class Order {
	
	private LocalDateTime dataOrder = LocalDateTime.now();
	
	private double totalPrice;
	
	private HashSet<Item> items = new HashSet<>();
	
	public Order( ) { }

	public LocalDateTime getDataOrder() {
		return dataOrder;
	}

	public void setDataOrder(LocalDateTime dataOrder) {
		this.dataOrder = dataOrder;
	}

	public HashSet<Item> getItems() {
		return items;
	}

	public void setItems(HashSet<Item> items) {
		this.items = items;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Order [dataOrder=" + dataOrder + ", totalPrice=" + totalPrice + ", items=" + items + "]";
	}

}