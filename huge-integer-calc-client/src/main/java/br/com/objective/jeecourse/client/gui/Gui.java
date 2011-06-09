package br.com.objective.jeecourse.client.gui;

import br.com.objective.jeecourse.core.Calculator;
import br.com.objective.jeecourse.core.CalculatorFactory;


public class Gui {

	public static void main(String[] args) {
		new Gui();
	}

	private Gui() {
		CalculatorFactory factory = new CalculatorFactory();
		Calculator calculator = factory.newCalculator();
		View view = new View();
		
		new Controller(calculator, view);
	}
}
