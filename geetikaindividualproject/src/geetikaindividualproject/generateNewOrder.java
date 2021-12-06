package geetikaindividualproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;



public class generateNewOrder {
	private StaticDB db = StaticDB.getInstance();

	private Order newOrder = new Order();

	private FileWriteOutput file;
	private FileWriteOutput file2;
	private FileWriteOutput file3;
	private ArrayList<String> outputMessage = new ArrayList<>();
	private ArrayList<String> outputMessage2 = new ArrayList<>();
	private ArrayList<OrderItem> items = new ArrayList<>();

	private HashSet<String> creditCards = new HashSet<String>();

	private double totalPrice = 0;

	public generateNewOrder(String filePath,String[] args) {

		file = new FileWriteOutput(filePath);
		file2 = new FileWriteOutput(args[1]);//card file
		file3 = new FileWriteOutput(args[2]);//output file
	}

	public boolean makeNewOrder() {

		try {

			file.readFile(true);

		} catch (Exception e) {

			return false;

		}

		getorderItems(file.getFileContent());

		return true;

	}

	public boolean validateOrder() {

		validateInpdata();

		return outputMessage.isEmpty();

	}

	public void calculateTotalPrice() {

		items.forEach((item) -> {

			totalPrice += item.getQuantity() * item.getPrice();

		});

		newOrder.setTotalPrice(totalPrice);

	}

	public double getTotalPrice() {

		return newOrder.getTotalPrice();

	}
    
	
	public void finalOrder() {

		db.getOrders().add(newOrder);

		for (OrderItem currentItem : items) {

			Item item = db.getDBItems().get(currentItem.getName());

			item.setQuantityStock(item.getQuantityStock() - currentItem.getQuantity());

		}

		for (String creditCard : creditCards) {

			if (!db.getCreditCards().contains(creditCard)) {

				db.getCreditCards().add(creditCard);

			}

		}
//Iterator
//		Iterator<String> i = db.getCreditCards().iterator();
//		while (i.hasNext())
//			System.out.println(i.next());
		ItemsIterator itr = new ItemsIterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		consoleOutputfile();
		
		

	}

	public void printMessage() {

		for (String line : outputMessage) {

			System.out.println(line);

		}

	}

	private void getorderItems(ArrayList<String> fileContent) {

		for (String line : fileContent) {

			String[] item = line.split(",");
			// checking
			if (db.getDBItems().containsKey(item[0])) {

				items.add(new OrderItem(item[0], Integer.parseInt(item[1]), item[2].replaceAll("\\s+", "")));
				// Milk,quantity,cardnumber
			} else {

				outputMessage.add("Item " + item[0] + " not found");

			}

		}

		if (!outputMessage.isEmpty()) {

			items.clear();

		}

	}

	private boolean validateInpdata() {
		int Luxury = 3, Essential = 5, Misc = 6;
		int l = 0, e = 0, m = 0;
		StringBuilder message = new StringBuilder();
		// currentItem : item to order
		// Item : item from db
		for (OrderItem currentItem : items) {
           
			// took the item form the db
			Item item = db.getDBItems().get(currentItem.getName());
            System.out.println(item.getCategory());
			if (item.getCategory().equals("Luxury")) {
			  l+= currentItem.getQuantity();
				
				
				if (l > Luxury) {
					
					message.append(currentItem.getName() + "(" + item.getQuantityStock() + ")" + "cap acceded Luxury");
				}
			} else if (item.getCategory().equals("Essential")) {
			  e +=  currentItem.getQuantity();
				
				if (e > Essential) {
					message.append(currentItem.getName() + "(" + item.getQuantityStock() + ")" + "cap acceded Essentials");
				}
			} else {
			  m+= currentItem.getQuantity();
				
				if (m > Misc) {
					message.append(currentItem.getName() + "(" + item.getQuantityStock() + ")" + "cap acceded Misc");
				}
			}

			if (item.getQuantityStock() < currentItem.getQuantity()) {

				if (message.length() > 0)

					message.append(", ");

				message.append(currentItem.getName() + "(" + item.getQuantityStock() + ")");

			} else {

				currentItem.setPrice(item.getPrice());

				if (!creditCards.contains(currentItem.getCreditCard()))

					creditCards.add(currentItem.getCreditCard());

			}

		}

		if (message.length() > 0) {

			outputMessage.add("Correct the quantities generated in the error log file.");

			outputMessage.add(message.toString());

		}

		return message.length() == 0;

	}

	public void consoleOutputfile() {

		if (outputMessage.isEmpty()) {

			outputMessage.add("Total Bill is ");

			outputMessage.add(Double.toString(newOrder.getTotalPrice()));

			// geetika
			outputMessage2.add("Cards");
			for (String card : db.getCreditCards()) {
				System.out.println(card);
				outputMessage2.add(card);
			}
			// geetika
			try {
//generate file outputs for card and final output file
				file3.outputfilewrite(outputMessage, false);
				file2.outputfilewrite(outputMessage2, false);

			} catch (IOException e) {

				e.printStackTrace();

			}

		} else {

			try {
//generate error log file
				file.outputfilewrite(outputMessage, true);

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

	}

}
