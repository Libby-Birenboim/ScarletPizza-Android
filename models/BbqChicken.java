package com.example.scarlettpizza.models;

/**
 * BBqChicken class is the pizza class for BBQ chicken
 * @author Selin Altiparmak, Libby Birenboim
 */
public class BbqChicken extends Pizza {
	private String style;

	/**
	 * BBqChicken is the constructor class for the bbq chicken pizza. It initializes the pizza settings
	 * @param style String
	 */
	public BbqChicken (String style) {
		this.style = style;
		add(Topping.BBQ_CHICKEN);
		add(Topping.PROVOLONE);
		add(Topping.GREEN_PEPPER);
		add(Topping.CHEDDAR);
	}

	/**
	 * getStyle method returns the style of the pizza
	 * @return String style of pizza
	 */
	public String getStyle() {
		return this.style;
	}

	/**
	 * price method returns the price of the pizza based on the size chosen by the user
	 * @return double price of pizza
	 */
	@Override
	public double price() {
		if (this.getSize() == Size.SMALL ) {
			return 13.99;
		} else if (this.getSize() == Size.MEDIUM) {
			return 15.99;
		} else {
			return 17.99;
		}
 	}

	/**
	 * toString method returns the string value of the bbq chicken pizza
	 * @return String value of bbq chicken pizza
	 */
	public String toString() {
		String s = "BBQ Chicken {" + this.style +" Style - " + this.getCrust().toString() + "},";
		for (Topping t:this.getToppings()) {
			s += t.toString() +", ";
		}
		s+= this.getSize().toString() + ", $" + String.format("%.2f", this.price()); 
		return s;
	}
}

