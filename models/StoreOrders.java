package com.example.scarlettpizza.models;

/**
 * StoreOrders class implements Customizable interface and includes the store pizza orders
 * @author Selin Altiparmak, Libby Birenboim
 */

import java.util.ArrayList;

public class StoreOrders implements Customizable<Order>{
	private ArrayList<Order> orderList = new ArrayList<Order>();

	/**
	 * add method adds a pizza order to the store orders
	 * @param obj Object
	 * @return true if successfully added pizza order and false otherwise
	 */
	@Override
	public boolean add(Object obj) {
		if (!(obj instanceof Order)) {
			return false;
		}
		Order order= (Order)obj;
		if (orderList.contains(order)) {
			return false;
		}
		
		orderList.add(order);
		return true;
	}

	/**
	 * remove method removes a pizza order from the store orders
	 * @param obj Object
	 * @return true if successfully removed pizza order and false otherwise
	 */
	@Override
	public boolean remove(Object obj) {
		if (!(obj instanceof Order)) {
			return false;
		}
		Order order= (Order )obj;
		if (!orderList.contains(order)) {
			return false;
		}
		orderList.remove(order);
		return true;
	}

	/**
	 * getOrderList method returns the list of store orders
	 * @return ArrayList<Order> of store orders
	 */
	public ArrayList<Order> getOrderList() {
		return orderList;
	}

	/**
	 * getOrder method returns the pizza order, given the order number (or null if order doesn't exist)
	 * @param orderNumber integer
	 * @return Order of pizza
	 */
	public Order getOrder(int orderNumber) {
		for (Order order: orderList) {
			if (order.getOrderNumber() == orderNumber) {
				return order;
			}
		}
		return null;
	}
}
