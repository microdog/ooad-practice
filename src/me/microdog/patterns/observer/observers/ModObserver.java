/**
 * 
 */
package me.microdog.patterns.observer.observers;

import me.microdog.patterns.observer.Subject.OnValueChangedListener;

/**
 * @author Microdog <dlangu0393@gmail.com>
 *
 */
public class ModObserver implements OnValueChangedListener {

	private int mod;

	/**
	 * @param mod
	 */
	public ModObserver(int mod) {
		super();
		this.mod = mod;
	}

	@Override
	public void update(int value) {
		System.out.printf("%d mod %d is %d\n", value, mod, value % mod);
	}

}
