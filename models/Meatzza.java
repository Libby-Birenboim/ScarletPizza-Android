package com.example.scarlettpizza.models;

/**
 * Meatzza class extends Pizza and creates the Meatzza type of pizza
 * @author Selin Altiparmak, Libby Birenboim
 */
public class Meatzza extends Pizza {
	private String style;

	/**
	 * Meatzza is the constructor for this class and initializes the meatzza type of pizza
	 * @param style String style of pizza
	 */
	public Meatzza  (String style) {
		this.style = style;
		add(Topping.SAUSAGE);
		add(Topping.PEPPERONI);
		add(Topping.BEEF);
		add(Topping.HAM);
	}

	/**
	 * getStyle method returns the style of the meatzza pizza
	 * @return String style of pizza
	 */
	public String getStyle() {
		return this.style;
	}

	/**
	 * price method returns the price of the pizza based on the size that the user chooses
	 * @return double price of pizza
	 */
	@Override
	public double price() {
		if (this.getSize() == Size.SMALL ) {
			return 15.99;
		} else if (this.getSize() == Size.MEDIUM) {
			return 17.99;
		} else {
			return 19.99;
		}
 	}

	/**
	 * toString method returns the String value of the meatzza
	 * @return String value of meatzza pizza
	 */
	public String toString() {
		String s = "Meatzza {" + this.style +" Style - " + this.getCrust().toString() + "},";
		for (Topping t:this.getToppings()) {
			s += t.toString() +", ";
		}
		s+= this.getSize().toString() + ", $" + String.format("%.2f", this.price()); 
		return s;
	}
}
