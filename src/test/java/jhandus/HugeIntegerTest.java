package jhandus;

import static org.junit.Assert.*;

import org.junit.Test;

public class HugeIntegerTest {

	@Test
	public void testToString() {
		assertEquals("514", new HugeInteger("514").toString());
		assertEquals("-74", new HugeInteger("-74").toString());
	}
	
	@Test
	public void testIsNegative() {
		assertFalse(new HugeInteger("0").isNegative());
		assertFalse(new HugeInteger("1").isNegative());
		assertFalse(new HugeInteger("991").isNegative());
		
		assertTrue(new HugeInteger("-0").isNegative());
		assertTrue(new HugeInteger("-1").isNegative());
		assertTrue(new HugeInteger("-781").isNegative());
	}
	
	@Test
	public void testAdd() {
		assertAdd("0", "0", "0");
		assertAdd("1", "0", "1");
		assertAdd("4", "2", "2");
		assertAdd("18", "9", "9");
		assertAdd("198", "99", "99");
		assertAdd("2000", "510", "1490");
		assertAdd("11169942196900779", "9871201098490890", "1298741098409889");
	}
	
//	@Test
	public void testAddForPerformance() {
		for (int i = 0; i < 10000000; i++)
			new HugeInteger("9871201098490890").add(new HugeInteger("1298741098409889")).toString();
	}
	
	@Test
	public void testSubtract() {
		assertSubtract("0", "0", "0");
		assertSubtract("0", "2", "2");
		assertSubtract("-3", "5", "8");
		assertSubtract("4580934196", "4654984100", "74049904");
		assertSubtract("-4580934196", "74049904", "4654984100");
		assertSubtract("17", "25", "8");
	}

	@Test
	public void testValueAt() {
		HugeInteger number = new HugeInteger("783");
		assertEquals(3, number.getValueAt(0));
		assertEquals(8, number.getValueAt(1));
		assertEquals(7, number.getValueAt(2));
	}
	
	private void assertAdd(String expectedResult, String value1, String value2) {
		assertEquals(expectedResult, new HugeInteger(value1).add(new HugeInteger(value2)).toString());
	}
	
	private void assertSubtract(String expectedResult, String value1, String value2) {
		assertEquals(expectedResult, new HugeInteger(value1).subtract(new HugeInteger(value2)).toString());
	}
}
