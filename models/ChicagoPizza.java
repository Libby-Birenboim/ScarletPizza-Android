package com.example.scarlettpizza.models;

/**
 * ChicagoPizza is the class for the Chicago Style pizza. It implements PizzaFactory.
 * @author Selin Altiparmak, Libby Birenboim
 */
public class ChicagoPizza implements PizzaFactory {

	/**
	 * createDeluxe method creates the Deluxe chicago style pizza
	 * @return Pizza deluxe
	 */
	@Override
	public Pizza createDeluxe() {
		Deluxe pizza = new Deluxe("Chicago");
		pizza.setCrust(Crust.DEEP_DISH);
		return pizza;
	}

	/**
	 * createMeatzza method creates the meatzaa chicago style pizza
	 * @return Pizza meatzza
	 */
	@Override
	public Pizza createMeatzza() {
		Meatzza pizza = new Meatzza("Chicago");
		pizza.setCrust(Crust.STUFFED);
		return pizza;
	}

	/**
	 * createBBQChicken method creates teh bbq chicken chicago style pizza
	 * @return Pizza bbq chicken
	 */
	@Override
	public Pizza createBBQChicken() {
		BbqChicken pizza = new BbqChicken("Chicago");
		pizza.setCrust(Crust.PAN);
		return pizza;
	}

	/**
	 * createBuildYourOwn method creates the build your own chicago style pizza
	 * @return Pizza build your own
	 */
	@Override
	public Pizza createBuildYourOwn() {
		BuildYourOwn pizza = new BuildYourOwn("Chicago");
		pizza.setCrust(Crust.PAN);
		return pizza;
	}
}
