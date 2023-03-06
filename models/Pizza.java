package com.example.scarlettpizza.models;

/**
 * Pizza class is an abstract class that holds all pizza types and styles
 * @author Selin Altiparmak, Libby Birenboim
 */

import java.util.ArrayList;

public abstract class Pizza implements Customizable {
	private ArrayList<Topping> toppings;
	private Crust crust;
	private Size size;

	/**
	 * Pizza is the constructor of the pizza class and initializes the list of toppings for the new pizza
	 */
	public Pizza() {
		toppings = new ArrayList<Topping> ();
	}

	/**
	 * add method adds a topping to the pizza if that topping exists
	 * @param obj Object
	 * @return true if topping added successfully, false otherwise
	 */
	public boolean add(Object obj) {
		if (!(obj instanceof Topping)) {
			return false;
		}
		Topping topping = (Topping )obj;
		if (toppings.contains(topping)) {
			return false;
		}
		
		if (toppings.size()>=7) {
			return false;
		}
		toppings.add(topping);
		return true;
	}

	/**
	 * remove method removes a topping from the pizza if that topping exists
	 * @param obj Object
	 * @return true if topping removed successfully, false otherwise
	 */
	public boolean remove(Object obj) {
		if (!(obj instanceof Topping)) {
			return false;
		}
		Topping topping = (Topping )obj;
		if (!toppings.contains(topping)) {
			return false;
		}
		toppings.remove(topping);
		return true;
	}

	/**
	 * getCrust method returns the crust type of the pizza
	 * @return Crust type of pizza
	 */
	public Crust getCrust() {
		return crust;
	}

	/**
	 * setCrust method sets the crust of the pizza to the chosen crust
	 * @param crust Crust
	 */
	public void setCrust(Crust crust) {
		this.crust = crust;
	}

	/**
	 * getSize method returns the size of the pizza
	 * @return Size of pizza
	 */
	public Size getSize() {
		return size;
	}

	/**
	 * setSize method sets the size of the pizza to a chosen size
	 * @param size Size
	 */
	public void setSize(Size size) {
		this.size = size;
	}

	/**
	 * getToppingCount method returns the number of toppings added to the pizza
	 * @return integer number of toppings added to the pizza
	 */
	public int getToppingCount() {
		return toppings.size();
	}

	/**
	 * getToppings returns the toppings list
	 * @return ArrayList<Topping> of toppings on pizza
	 */
	public ArrayList<Topping> getToppings() {
		return toppings;
	}

	/**
	 * price method is an abstract method that will reurn the price of the pizza based on its size
	 * @return double price of pizza
	 */
	public abstract double price();
}
