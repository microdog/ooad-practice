/**
 * 
 */
package me.microdog.patterns.strategy.promotions;

import me.microdog.patterns.strategy.Order;
import me.microdog.patterns.strategy.OrderItem;
import me.microdog.patterns.strategy.Promotion;

/**
 * @author Microdog <dlangu0393@gmail.com>
 *
 */
public class Discount extends Promotion {

	public Discount(Order order) {
		super(order);
	}

	@Override
	public String getName() {
		return "20% OFF";
	}

	@Override
	public double updatePrice() {
		for (OrderItem orderItem : getOrder().getItems()) {
			orderItem.setPrice(orderItem.getPrice() * 0.8);
		}

		// No delta needed
		return 0;
	}

}
