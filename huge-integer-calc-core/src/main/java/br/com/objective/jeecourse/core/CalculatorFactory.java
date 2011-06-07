package br.com.objective.jeecourse.core;

public class CalculatorFactory {
	
	public static Calculator newCalculator() {
		return new CalculatorImpl();
	}
	
}
