package com.example.scarlettpizza.models;

/**
 * the Order class implements Customizable and is in charge of the pizza orders
 * @author Selin Altiparmak, Libby Birenboim
 */

import java.util.ArrayList;

public class Order implements Customizable {
	
	private static int orderSerial = 1;
	
	private int orderNumber;
	private ArrayList<Pizza> pizzaList;

	/**
	 * Order is the constructor for this class and it initializes the pizza orders
	 */
	public Order() {
		pizzaList = new ArrayList<Pizza> ();
		orderNumber = orderSerial ;
		orderSerial++;
	}

	/**
	 * getOrderNumber method returns the order number
	 * @return integer order number
	 */
	public int getOrderNumber() {
		return orderNumber;
	}

	/**
	 * getPizzaList method returns the pizza list of the order
	 * @return ArrayList<Pizza>
	 */
	public ArrayList<Pizza> getPizzaList() {
		return pizzaList;
	}

	/**
	 * add method adds a pizza ot the order if it is the instance of a pizza object
	 * @param obj Object
	 * @return true if obj is instance of pizza and added successfully, and false otherwise
	 */
	@Override
	public boolean add(Object obj) {
		if (!(obj instanceof Pizza)) {
			return false;
		}
		Pizza pizza= (Pizza )obj;
		if (pizzaList.contains(pizza)) {
			return false;
		}
		pizzaList.add(pizza);
		return true;
	}

	/**
	 * remove method removes the pizza from the order if it is the instance of a pizza object
	 * @param obj Object
	 * @return true if obj is an instance of pizza and removed successfully, false otherwise
	 */
	@Override
	public boolean remove(Object obj) {
		if (!(obj instanceof Pizza)) {
			return false;
		}
		Pizza pizza= (Pizza )obj;
		if (!pizzaList.contains(pizza)) {
			return false;
		}
		pizzaList.remove(pizza);
		return true;
	}

	/**
	 * clearOrder method clears all the pizza orders
	 */
	public void clearOrder() {
		pizzaList.clear();
	}

	/**
	 * getSalesTotal method returns the sales total value of the order
	 * @return double sales total
	 */
	public double getSalesTotal() {
		double total = 0;
		for (Pizza p:pizzaList) {
			total += p.price();
		}
		return total;
	}

	/**
	 * getSalesTax method returns the sales tax value of the order
	 * @return double sales tax
	 */
	public double getSalesTax() {
		
		return getSalesTotal() * 0.06625;
	}

	/**
	 * getTotal method returns the total price of the order including sales total and sales tax added
	 * @return double total price of order
	 */
	public double getTotal() {
		return getSalesTotal() + getSalesTax();
	}
}
