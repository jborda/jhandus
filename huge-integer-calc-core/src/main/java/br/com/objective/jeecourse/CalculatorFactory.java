package br.com.objective.jeecourse;

public class CalculatorFactory {

	
	public Calculator newCalculator() {
		return new CalculatorImpl();
	}
	
}
