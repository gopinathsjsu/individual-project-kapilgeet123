package geetikaindividualproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class StaticDB {
	private static StaticDB instance;

	private HashMap<String, Item> items = new HashMap<>();

	private HashSet<String> cards = new HashSet<>();

	private ArrayList<Order> orders = new ArrayList<>();

	private StaticDB( ) { }

	public static StaticDB getInstance() {

		if (instance == null) {

			instance = new StaticDB();

		}

		return instance;

	}

//database instance
	public HashMap<String, Item> getDBItems() {
		return items;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public HashSet<String> getCreditCards() {
		return cards;
	}
}
