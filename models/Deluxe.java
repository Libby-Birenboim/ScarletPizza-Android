package com.example.scarlettpizza.models;

/**
 * Deluxe class extends pizza and creates the deluxe type of pizza
 * @author Selin Altiparmak, Libby Birenboim
 */
public class Deluxe extends Pizza {
	private String style;

	/**
	 * Deluxe is the constructor for this class and initializes the deluxe type of pizza
	 * @param style String style of pizza
	 */
	public Deluxe (String style) {
		this.style = style;
		add(Topping.SAUSAGE);
		add(Topping.PEPPERONI);
		add(Topping.GREEN_PEPPER);
		add(Topping.ONION);
		add(Topping.MUSHROOM);
	}

	/**
	 * getStyle method reurns the style of the deluxe pizza
	 * @return String style of deluxe pizza
	 */
	public String getStyle() {
		return this.style;
	}

	/**
	 * price method returns the price of the deluxe pizza based on the size that is chosen by the user
	 * @return double price of pizza
	 */
	@Override
	public double price() {
		if (this.getSize() == Size.SMALL ) {
			return 14.99;
		} else if (this.getSize() == Size.MEDIUM) {
			return 16.99;
		} else {
			return 18.99;
		}
 	}

	/**
	 * toString method returns the String value of the deluxe type of pizza
	 * @return String value of deluxe pizza
	 */
	public String toString() {
		String s = "Deluxe {" + this.style +" Style - " + this.getCrust().toString() + "},";
		for (Topping t:this.getToppings()) {
			s += t.toString() +", ";
		}
		s+= this.getSize().toString() + ", $" + String.format("%.2f", this.price()); 
		return s;
	}
}
