package br.com.objective.jeecourse.core;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.objective.jeecourse.core.HugeInteger;

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
		
//		TODO resolver soma de negativos
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
		
//		TODO: resolver subtracao de negativos
//		assertSubtract("-17", "-25", "-8");
//		assertSubtract("31", "23", "-8");
	}

	@Test
	public void testValueAt() {
		HugeInteger number = new HugeInteger("783");
		assertEquals(3, number.getValueAt(0));
		assertEquals(8, number.getValueAt(1));
		assertEquals(7, number.getValueAt(2));
	}
	
	@Test
	public void testComparation() {
		assertCompare(0, "0", "0");
		assertCompare(0, "1", "1");
		assertCompare(0, "987123404", "987123404");
		assertCompare(0, "-0", "-0");
		assertCompare(0, "-1", "-1");
		assertCompare(0, "-987123404", "-987123404");
		
		assertCompare(1, "1", "0");
		assertCompare(1, "2", "1");
		assertCompare(1, "2", "-1");
		assertCompare(1, "-1", "-2");
		assertCompare(1, "785", "0");
		assertCompare(1, "98101", "321");
		assertCompare(1, "98101", "1");
		assertCompare(1, "98101", "98100");
		assertCompare(1, "70654", "-1");
		assertCompare(1, "70654", "-654");
		assertCompare(1, "70654", "-90000000");
		assertCompare(1, "-70654", "-70655");
		assertCompare(1, "-70654", "-90000000");
		
		assertCompare(-1, "0", "1");
		assertCompare(-1, "1", "2");
		assertCompare(-1, "-1", "2");
		assertCompare(-1, "-2", "-1");
		assertCompare(-1, "0", "785");
		assertCompare(-1, "321", "98101");
		assertCompare(-1, "1", "98101");
		assertCompare(-1, "98100", "98101");
		assertCompare(-1, "-1", "70654");
		assertCompare(-1, "-654", "70654");
		assertCompare(-1, "-90000000", "70654");
		assertCompare(-1, "-70655", "-70654");
		assertCompare(-1, "-90000000", "-70654");
		
	}
	
	private void assertAdd(String expectedResult, String first, String second) {
		assertEquals(expectedResult, new HugeInteger(first).add(new HugeInteger(second)).toString());
	}
	
	private void assertSubtract(String expectedResult, String first, String second) {
		assertEquals(expectedResult, new HugeInteger(first).subtract(new HugeInteger(second)).toString());
	}
	
	private void assertCompare(int expected, String first, String second) {
		assertEquals(expected, new HugeInteger(first).compareTo(new HugeInteger(second)));
	}
}
