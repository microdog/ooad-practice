/**
 * 
 */
package me.microdog.patterns.observer.observers;

import me.microdog.patterns.observer.Subject.OnValueChangedListener;

/**
 * @author Microdog <dlangu0393@gmail.com>
 *
 */
public class DivObserver implements OnValueChangedListener {

	private int div;

	/**
	 * @param div
	 */
	public DivObserver(int div) {
		super();
		this.div = div;
	}

	@Override
	public void update(int value) {
		System.out.printf("%d div %d is %d\n", value, div, value / div);
	}

}
