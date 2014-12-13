/**
 * 
 */
package me.microdog.patterns.strategy;

/**
 * Promotion interface.
 * 
 * @author Microdog <dlangu0393@gmail.com>
 *
 */
public abstract class Promotion {

	private Order order;

	/**
	 * Create a promotion strategy.
	 * 
	 * @param order
	 *            Order instance attached to
	 */
	public Promotion(Order order) {
		this.order = order;
	}

	/**
	 * Get promotion's name.
	 * 
	 * @return promotion name
	 */
	public abstract String getName();

	/**
	 * Update price.
	 * 
	 * @return price delta
	 */
	public abstract double updatePrice();

	/**
	 * Get order.
	 * 
	 * @return order attached to
	 */
	protected Order getOrder() {
		return order;
	}

}
