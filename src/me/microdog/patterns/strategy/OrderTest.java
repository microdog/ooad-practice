/**
 * 
 */
package me.microdog.patterns.strategy;

import me.microdog.patterns.strategy.goods.Pen;
import me.microdog.patterns.strategy.promotions.Discount;
import me.microdog.patterns.strategy.promotions.SecondPenHalf;

/**
 * @author Microdog <dlangu0393@gmail.com>
 *
 */
public class OrderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create a order
		Order order = new Order();
		_("Order created!");

		// Buy a pen
		order.addItem(new OrderItem(1, new Pen("SuperPen", 12.75)));
		_("Pen 'SuperPen' added to order.");

		// Buy another pen
		order.addItem(new OrderItem(3, new Pen("FountainPen", 99.99)));
		_("Two Pen 'FountainPen' added to order.");

		// Buy a book
		order.addItem(new OrderItem(1, new Pen(
				"Object-Oriented Analysis and Design", 50.0)));
		_("Book 'Object-Oriented Analysis and Design' added to order.");

		// Print current order
		_("Current order:");
		order.print();

		// Add discount promotion
		order.addPromotion(new Discount(order));
		_("Promotion '20% Discount' added to order.");

		// Print current order
		_("Current order:");
		order.print();

		// Add discount promotion
		order.addPromotion(new SecondPenHalf(order));
		_("Promotion 'Second Pen Half Price' added to order.");

		// Print current order
		_("Current order:");
		order.print();

		// Clear promotions
		order.clearPromotions();
		_("Promotions cleared");

		// Add discount promotion
		order.addPromotion(new SecondPenHalf(order));
		_("Promotion 'Second Pen Half Price' added to order.");

		// Add discount promotion
		order.addPromotion(new Discount(order));
		_("Promotion '20% Discount' added to order.");

		// Print current order
		_("Current order:");
		order.print();

		_("Print again:");
		order.print();
	}

	private static void _(String msg) {
		System.out.println("[TEST] - " + msg);
	}

}
