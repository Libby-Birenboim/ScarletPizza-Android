package com.example.scarlettpizza;

/**
 * the ScarletPizzaController is the controller of the scarletPizza app view
 * @author Selin Altiparmak, Libby Birenboim
 */

import com.example.scarlettpizza.models.Order;
import com.example.scarlettpizza.models.Pizza;
import com.example.scarlettpizza.models.StoreOrders;

import java.io.IOException;

public class ScarletPizzaController {

	private static ScarletPizzaController instance = new ScarletPizzaController();
	private StoreOrders storeOrder ;
	private  Order currentOrder ;
	private  Pizza pizza ;

	/**
	 * getCurrentOrder method returns the current order
	 * @return currentOrder
	 */
	public   Order getCurrentOrder() {
		return currentOrder;
	}

	/**
	 * getPizza method returns the type of pizza
	 * @return pizza
	 */
	public Pizza getPizza() {
		return pizza;
	}

	/**
	 * getStoreOrders method returns the store orders
	 * @return storeOrder
	 */
	public   StoreOrders getStoreOrders() {
		return storeOrder;
	}

	/**
	 * setPizza method receives a pizza and sets the pizza to be that style of pizza
	 * @param pizza Pizza
	 */
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	/**
	 * createNewOrder method creates a new pizza order
	 */
	public   void createNewOrder() {
		currentOrder = new Order();
	}

	/**
	 * addToOrder method adds a pizza to the current order
	 * @param p Pizza
	 */
	public  void addToOrder(Pizza p) {
		currentOrder.add(p);
	}

	/**
	 * removeFromOrder removes a certain pizza from the current order
	 * @param p Pizza
	 */
	public  void removeFromOrder(Pizza p) {
		currentOrder.remove(p);
	}

	/**
	 * ScarletPizzaController is the constructor for this controller class and sets the store orders and current orders
	 */
	private ScarletPizzaController(){
		storeOrder = new StoreOrders();
		currentOrder = new Order();
	}

	/**
	 * getInstance method returns the instance of the object in the ScarletPizza app
	 * @return instance of object
	 */
	public static ScarletPizzaController getInstance(){
		return instance;
	}
}
