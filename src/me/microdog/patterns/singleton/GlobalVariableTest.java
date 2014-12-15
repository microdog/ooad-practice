/**
 * 
 */
package me.microdog.patterns.singleton;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Microdog <dlangu0393@gmail.com>
 *
 */
public class GlobalVariableTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSingleton() throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		Field singletonField = GlobalVariable.class
				.getDeclaredField("selfInstance");

		// Singleton instance should not be accessible
		assertFalse(singletonField.isAccessible());

		// Singleton instance should be null
		singletonField.setAccessible(true);
		assertNull(singletonField.get(null));
		singletonField.setAccessible(false);
		assertFalse(singletonField.isAccessible());

		assertEquals(GlobalVariable.getInstance(), GlobalVariable.getInstance());

		// Singleton instance should not be null now
		singletonField.setAccessible(true);
		assertNotNull(singletonField.get(null));
		singletonField.setAccessible(false);
		assertFalse(singletonField.isAccessible());
	}

	@Test
	public void testDefaultValue() {
		assertEquals(0, GlobalVariable.getInstance().getValue());
	}

	@Test
	public void testSetAndGet() {
		GlobalVariable.getInstance().setValue(5);
		assertEquals(5, GlobalVariable.getInstance().getValue());
	}

	public static void main(String[] args) {
		_("Get singleton instance: " + GlobalVariable.getInstance());
		_("Get singleton instance: " + GlobalVariable.getInstance());

		_("Default value:" + GlobalVariable.getInstance().getValue());

		int value = 5;

		_("Set value: " + value);
		GlobalVariable.getInstance().setValue(value);

		_("Get value: " + GlobalVariable.getInstance().getValue());
	}

	private static void _(String msg) {
		System.out.println(msg);
	}
}
