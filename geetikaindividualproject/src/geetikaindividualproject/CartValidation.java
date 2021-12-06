package geetikaindividualproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CartValidation {
	
	
	public static void main(String[] args) throws Exception {
        System.out.println(args[0]);
        System.out.println(args[1]);
        
		CartValidation validation = new CartValidation();
        
		validation.cartValidation(args);
		

	}
	

	public void cartValidation(String[] args) {

		if (args.length == 0) {
			// db passing
			System.out.println("Kindly add the path of the database file and credit card file path and final output file ");

			System.exit(0);

		}

		Inputdatabasemaker inpdb = new Inputdatabasemaker(args[0], args[1],args[2]);

		inpdb.inputFileScan();

		while (true) {

			String path = InputMenu();

			if (path.equals(""))
				break;

			makeOrder(path,args);

		}

		System.out.println("The Application for Cart Validation ended");

	}
	
	

	private String InputMenu() {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter the Input order sheet");

		String ans = "";

		try {

			ans = reader.readLine();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return ans;

	}

	private void makeOrder(String path,String[] args) {

		generateNewOrder newOrder = new generateNewOrder(path,args);

		if (newOrder.makeNewOrder()) {

			if (newOrder.validateOrder()) {

				newOrder.calculateTotalPrice();

				if (newOrder.getTotalPrice() > 0) {

					newOrder.finalOrder();

					System.out.println("The new order is made with a bill of " + newOrder.getTotalPrice());

				}

			} else {

				System.out.println("Something went wrong.Refer the generated error log file");

				newOrder.consoleOutputfile();

			}

		} else {

			System.out.println("Could not validate the path of the order file. Kindly check the order file path");

		}

	}

}
