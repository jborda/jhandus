package br.com.objective.jeecourse.core;

public class CalculatorFactory {
	
	public Calculator newCalculator() {
		return new CalculatorImpl();
	}
	
}
