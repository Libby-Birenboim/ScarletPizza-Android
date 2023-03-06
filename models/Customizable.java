package com.example.scarlettpizza.models;

/**
 * Customizable interface allows the pizzas to be customized by the user
 * @param <E>
 * @author Selin Altiparmak, Libby Birenboim
 */
public interface Customizable<E> {
	boolean add(Object obj);
	boolean remove(Object obj);
}