package com.example.scarlettpizza.models;

/**
 * BuildYourOwn class extends Pizza and is the class for the build your own pizza type
 * @author Selin Altiparmak, Libby Birenboim
 */
public class BuildYourOwn extends Pizza{
	private String style;

	/**
	 * BuildYourOwn method is the constructor for the build your own pizza
	 * @param style String style of pizza
	 */
	public BuildYourOwn  (String style) {
		this.style = style;
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
			Double price = 8.99 + getToppingCount()*1.59; 
			return price;
		} else if (this.getSize() == Size.MEDIUM) {
			Double price = 10.99 + getToppingCount()*1.59; 
			return price;
		} else {
			Double price = 12.99 + getToppingCount()*1.59; 
			return price;
		}
 	}

	/**
	 * toString method returns the string value of the build your own pizza
	 * @return String value of pizza
	 */
	public String toString() {
		String s = "Build your own {" + this.style +" Style - " + this.getCrust().toString() + "},";
		for (Topping t:this.getToppings()) {
			s += t.toString() +", ";
		}
		s+= this.getSize().toString() + ", $" + String.format("%.2f", this.price()); 
		return s;
	}
}
