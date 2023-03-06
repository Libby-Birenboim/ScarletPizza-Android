package com.example.scarlettpizza;

import com.example.scarlettpizza.models.Pizza;
import com.example.scarlettpizza.models.Topping;

import java.io.Serializable;

/**
 * This class defines the data structure of an item to be displayed in the RecyclerView
 * @author Lily Chang
 */
public class Item implements Serializable {
	private Topping topping;
	private String itemName;
	private int image;
	private Pizza pizza;
	private String unitPrice; //for demo purpose, the unitPrice is of String type

	/**
	 * Parameterized constructor.
	 * @param itemName
	 * @param image
	 * @param unitPrice
	 */
	public Item(String itemName, int image, String unitPrice, Pizza pizza, Topping topping) {
		this.itemName = itemName;
		this.image = image;
		this.unitPrice = unitPrice;
		this.pizza = pizza;
		this.topping = topping;
	}

	/**
	 * Getter method that returns the item name of an item.
	 * @return the item name of an item.
	 */
	public String getItemName() {
		return itemName;
	}

	public Topping getTopping() {
		return topping;
	}

	/**
	 * Getter method that returns the image of an item.
	 * @return the image of an item.
	 */
	public int getImage() {
		return image;
	}

	/**
	 * Getter method that returns the unit price.
	 * @return the unit price of the item.
	 */
	public String getUnitPrice() {
		return unitPrice;
	}

	public Pizza getPizza() {
		return pizza;
	}
}
