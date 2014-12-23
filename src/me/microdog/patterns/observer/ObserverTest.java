/**
 * 
 */
package me.microdog.patterns.observer;

import me.microdog.patterns.observer.observers.DivObserver;
import me.microdog.patterns.observer.observers.ModObserver;

/**
 * @author Microdog <dlangu0393@gmail.com>
 *
 */
public class ObserverTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Subject subject = new Subject();

		// Div observer
		DivObserver divObserver = new DivObserver(4);

		// Mod observer
		ModObserver modObserver = new ModObserver(3);

		// Register listeners
		subject.addOnChangeListener(divObserver);
		subject.addOnChangeListener(modObserver);

		// Update value
		subject.setValue(14);
	}

}
