package br.com.objective.jeecourse.core;

import static junit.framework.Assert.*;

import org.junit.Test;

import br.com.objective.jeecourse.core.Calculator;
import br.com.objective.jeecourse.core.CalculatorImpl;

public class CalculatorTest {

	private Calculator calculator = new CalculatorImpl();
	
	@Test
	public void testAdd() {
		assertEquals("0", calculator.add("0", "0"));
		assertEquals("4", calculator.add("2", "2"));
		assertEquals("19", calculator.add("9", "10"));
		assertEquals("789662782012054770885", calculator.add("654801901564991084", "789007980110489779801"));
	}
	
	@Test
	public void testSubtract() {
		assertEquals("0", calculator.subtract("0", "0"));
		assertEquals("2", calculator.subtract("4", "2"));
		assertEquals("320104809424207072", calculator.subtract("320104908126016891", "98701809819"));
		assertEquals("-2", calculator.subtract("2", "4"));
		assertEquals("-320104809424207072", calculator.subtract("98701809819", "320104908126016891"));
	}
	
	@Test
	public void testCompareTo() {
		assertEquals(0, calculator.compare("0", "0"));
		assertEquals(0, calculator.compare("1", "1"));
		assertEquals(0, calculator.compare("-1", "-1"));
		
		assertEquals(1, calculator.compare("1", "0"));
		assertEquals(1, calculator.compare("1", "-1"));
		assertEquals(1, calculator.compare("299", "-500"));
		assertEquals(1, calculator.compare("300", "299"));
		assertEquals(1, calculator.compare("98701809819", "98701809818"));
		
		assertEquals(-1, calculator.compare("0", "1"));
		assertEquals(-1, calculator.compare("-1", "1"));
		assertEquals(-1, calculator.compare("-500", "299"));
		assertEquals(-1, calculator.compare("299", "300"));
		assertEquals(-1, calculator.compare("98701809818", "98701809819"));
	}
}
