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

	public interface OnValueChangedListener {
		/**
		 * Invoked on value updated.
		 * 
		 * @param value
		 */
		void update(int value);
	}

	private int value;

	private ArrayList<OnValueChangedListener> listeners;

	/**
	 * 
	 */
	public Subject() {
		super();

		listeners = new ArrayList<Subject.OnValueChangedListener>();
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
		onValueChanged();
	}

	/**
	 * Invoked on value changed.
	 */
	private void onValueChanged() {
		for (OnValueChangedListener listener : listeners) {
			listener.update(value);
		}
	}

	/**
	 * Add a listener.
	 * 
	 * @param listener
	 */
	public void addOnChangeListener(OnValueChangedListener listener) {
		listeners.add(listener);
	}

	/**
	 * Remove a listener.
	 * 
	 * @param listener
	 */
	public void removeOnChangeListener(OnValueChangedListener listener) {
		listeners.remove(listener);
	}
}
