/**
 * 
 */
package me.microdog.patterns.strategy.promotions;

import java.util.HashMap;
import java.util.Map.Entry;

import me.microdog.patterns.strategy.Good;
import me.microdog.patterns.strategy.Order;
import me.microdog.patterns.strategy.OrderItem;
import me.microdog.patterns.strategy.Promotion;
import me.microdog.patterns.strategy.goods.Pen;

/**
 * @author Microdog <dlangu0393@gmail.com>
 *
 */
public class SecondPenHalf extends Promotion {

	public SecondPenHalf(Order order) {
		super(order);
	}

	@Override
	public String getName() {
		return "Get the second pen half price";
	}

	@Override
	public double updatePrice() {
		HashMap<Good, Integer> penMap = new HashMap<Good, Integer>();
		for (OrderItem orderItem : getOrder().getItems()) {
			Good good = orderItem.getGood();
			if (good instanceof Pen) {
				if (penMap.containsKey(good)) {
					penMap.put(good, penMap.get(good) + 1);
				} else {
					penMap.put(good, 1);
				}
			}
		}

		double priceDelta = 0;
		for (Entry<Good, Integer> entry : penMap.entrySet()) {
			priceDelta += (entry.getKey().getPrice() / entry.getValue())
					* (entry.getValue() / 2);
		}
		return -priceDelta;
	}

}
