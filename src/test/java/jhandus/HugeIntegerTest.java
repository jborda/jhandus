package jhandus;

import static org.junit.Assert.*;

import org.junit.Test;

public class HugeIntegerTest {

	@Test
	public void shouldAdd() {
		HugeInteger result = new HugeInteger("510").add(new HugeInteger("1490"));
		
		assertEquals("2000", result.toString());
	}
	
	@Test
	public void shouldPrintValueOnToString() {
		HugeInteger number = new HugeInteger("5");
		
		assertEquals("5", number.toString());
	}
	
	@Test
	public void testValueArray() {
		HugeInteger number = new HugeInteger("783");
		
		assertArrayEquals(new int[]{3, 8, 7}, number.getValueArray());
	}
}
