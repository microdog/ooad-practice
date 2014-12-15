/**
 * 
 */
package me.microdog.patterns.singleton;

/**
 * @author Microdog <dlangu0393@gmail.com>
 *
 */
public class GlobalVariable {

	private static GlobalVariable selfInstance = null;

	private int value;

	private GlobalVariable() {
		this.value = 0;
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
	}

	/**
	 * Get default instance.
	 * 
	 * @return instance of GlobalVariable
	 */
	public static GlobalVariable getInstance() {
		if (selfInstance == null) {
			selfInstance = new GlobalVariable();
		}
		return selfInstance;
	}

}
