package com.example.scarlettpizza.models;

/**
 * PizzaFactory interface includes the different types of pizzas
 * @author Selin Altiparmak, Libby Birenboim
 */
public interface PizzaFactory {
	Pizza createDeluxe();
	Pizza createMeatzza();
	Pizza createBBQChicken();
	Pizza createBuildYourOwn();
}