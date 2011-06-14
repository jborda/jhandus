package br.com.objective.jeecourse.core;

public class SimpleCalculatorFactory implements CalculatorFactory {
	
	@Override
	public Calculator newCalculator() {
		return new CalculatorImpl();
	}
	
}
