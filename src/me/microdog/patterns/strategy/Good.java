/**
 * 
 */
package me.microdog.patterns.strategy;

/**
 * @author Microdog <dlangu0393@gmail.com>
 *
 */
public abstract class Good {

	protected String name;

	protected double price;

	/**
	 * @param name
	 * @param price
	 */
	public Good(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

}
