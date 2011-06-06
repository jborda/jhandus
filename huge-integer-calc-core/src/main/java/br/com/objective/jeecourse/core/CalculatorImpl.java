package br.com.objective.jeecourse.core;

class CalculatorImpl implements Calculator {
	
	CalculatorImpl() {}

	@Override
	public String add(String left, String right) {
		return new HugeInteger(left).add(new HugeInteger(right)).toString();
	}

	@Override
	public String subtract(String left, String right) {
		return new HugeInteger(left).subtract(new HugeInteger(right)).toString();
	}

	@Override
	public int compare(String first, String second) {
		return new HugeInteger(first).compareTo(new HugeInteger(second));
	}

}
