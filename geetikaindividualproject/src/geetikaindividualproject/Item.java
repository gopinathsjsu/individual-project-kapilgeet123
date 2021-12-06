package geetikaindividualproject;

public class Item {
	
	private String category;
	
	private String name;
	
	private double price;
	
	private int quantityStock;
	
	public Item( ) { }
	
	public Item(String category, String name, double price, int quantityStock) {
		
		this.category = category;
		this.name = name;
		this.price = price;
		this.quantityStock = quantityStock;
		
	}
	
	public Item(String name, int quantity) {
		
		this.name = name;
		this.quantityStock = quantity;
		
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantityStock() {
		return quantityStock;
	}

	public void setQuantityStock(int quantityStock) {
		this.quantityStock = quantityStock;
	}

	@Override
	public String toString() {
		return "Item [category=" + category + ", name=" + name + ", price=" + price + ", quantityStock=" + quantityStock
				+ "]";
	}

}
