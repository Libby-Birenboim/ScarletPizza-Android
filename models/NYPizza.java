package com.example.scarlettpizza.models;

/**
 * NYPizza class implements PizzaFactory and is the class for the New York Style Pizza
 * @author Selin Altiparmak, Libby Birenboim
 */
public class NYPizza implements PizzaFactory {

	/**
	 * createDeluxe method creates the deluxe NY style pizza
	 * @return Pizza
	 */
	@Override
	public Pizza createDeluxe() {
		Deluxe pizza = new Deluxe("Newyork");
		pizza.setCrust(Crust.BROOKLYN);
		return pizza;
	}

	/**
	 * createMeatzza method creates the meatzza NY style pizza
	 * @return Pizza
	 */
	@Override
	public Pizza createMeatzza() {
		Meatzza pizza = new Meatzza("Newyork");
		pizza.setCrust(Crust.HAND_TOSSED);
		return pizza;
	}

	/**
	 * createBBQChicken method creates the bbq chicken NY style pizza
	 * @return Pizza
	 */
	@Override
	public Pizza createBBQChicken() {
		BbqChicken pizza = new BbqChicken("Newyork");
		pizza.setCrust(Crust.THIN);
		return pizza;
	}

	/**
	 * createBuildYourOwn method creates the build your own NY style pizza
	 * @return Pizza
	 */
	@Override
	public Pizza createBuildYourOwn() {
		BuildYourOwn pizza = new BuildYourOwn("Newyork");
		pizza.setCrust(Crust.HAND_TOSSED);
		return pizza;
	}
}
