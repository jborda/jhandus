package jhandus;

public class CalculatorFactory {

	
	public Calculator newCalculator() {
		return new CalculatorImpl();
	}
	
}
