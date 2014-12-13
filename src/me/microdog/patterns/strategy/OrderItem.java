/**
 * 
 */
package me.microdog.patterns.strategy;

/**
 * @author Microdog <dlangu0393@gmail.com>
 *
 */
public class OrderItem {

	/**
	 * The amount of good.
	 */
	private int amount;

	/**
	 * Item price.
	 */
	private double price;

	/**
	 * Related good.
	 */
	private Good good;

	/**
	 * @param amount
	 * @param good
	 */
	public OrderItem(int amount, Good good) {
		super();
		this.amount = amount;
		this.good = good;
		this.price = good.getPrice() * amount;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @return good name
	 */
	public String getName() {
		return good.getName();
	}

	/**
	 * @return original item price
	 */
	public double getOriginalPrice() {
		return good.getPrice() * amount;
	}

	/**
	 * @return the good
	 */
	public Good getGood() {
		return good;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
