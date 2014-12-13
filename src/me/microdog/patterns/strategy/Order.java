/**
 * 
 */
package me.microdog.patterns.strategy;

import java.util.ArrayList;

/**
 * @author Microdog <dlangu0393@gmail.com>
 *
 */
public class Order {

	/**
	 * Order items.
	 */
	private ArrayList<OrderItem> items;

	/**
	 * Promotions.
	 */
	private ArrayList<Promotion> promotions;

	public Order() {
		items = new ArrayList<OrderItem>();
		promotions = new ArrayList<Promotion>();
	}

	/**
	 * Add order item.
	 * 
	 * @param item
	 *            order item
	 */
	public void addItem(OrderItem item) {
		items.add(item);
	}

	/**
	 * Add promotion.
	 * 
	 * @param promotion
	 */
	public void addPromotion(Promotion promotion) {
		promotions.add(promotion);
	}

	/**
	 * Clear all promotions set.
	 */
	public void clearPromotions() {
		promotions.clear();
	}

	/**
	 * @return the items
	 */
	public ArrayList<OrderItem> getItems() {
		return items;
	}

	/**
	 * Get original price.
	 * 
	 * @return original price
	 */
	public double getOriginalPrice() {
		double price = 0;
		for (OrderItem orderItem : items) {
			price += orderItem.getOriginalPrice();
		}
		return price;
	}

	/**
	 * Get order price.
	 * 
	 * @return order price
	 */
	public double getPrice() {
		double priceDelta = 0;
		for (Promotion promotion : promotions) {
			priceDelta += promotion.updatePrice();
		}

		double price = 0;
		for (OrderItem orderItem : items) {
			price += orderItem.getPrice();

			// Reset calculated price
			orderItem.setPrice(orderItem.getOriginalPrice());
		}

		return price + priceDelta;
	}

	/**
	 * Print order.
	 */
	public void print() {
		System.out.println("==========Order==========");
		System.out.println("= Name = Amount = Price =");
		System.out.println("-------------------------");
		for (OrderItem orderItem : items) {
			System.out.printf("%s\t%s\t%.2f\n", orderItem.getName(),
					orderItem.getAmount(), orderItem.getOriginalPrice());
		}
		System.out.println("-------------------------");
		System.out.println("Promotions:");
		for (Promotion promotion : promotions) {
			System.out.println("\t" + promotion.getName());
		}
		System.out.println("-------------------------");
		System.out.printf("Original Price: $%.2f\n", getOriginalPrice());
		System.out.printf("Total Price: $%.2f\n", getPrice());
		System.out.println("=========================");
	}

}
