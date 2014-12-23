/**
 * 
 */
package me.microdog.patterns.observer;

import java.util.ArrayList;

/**
 * @author Microdog <dlangu0393@gmail.com>
 *
 */
public class Subject {

	public interface OnChangeListener {
		/**
		 * Invoked on value updated.
		 * 
		 * @param value
		 */
		void update(int value);
	}

	private int value;

	private ArrayList<OnChangeListener> listeners;

	/**
	 * 
	 */
	public Subject() {
		super();

		listeners = new ArrayList<Subject.OnChangeListener>();
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = value;
		onChange();
	}

	/**
	 * Invoked on value changed.
	 */
	private void onChange() {
		for (OnChangeListener listener : listeners) {
			listener.update(value);
		}
	}

	/**
	 * Add a listener.
	 * 
	 * @param listener
	 */
	public void addOnChangeListener(OnChangeListener listener) {
		listeners.add(listener);
	}

	/**
	 * Remove a listener.
	 * 
	 * @param listener
	 */
	public void removeOnChangeListener(OnChangeListener listener) {
		listeners.remove(listener);
	}
}
