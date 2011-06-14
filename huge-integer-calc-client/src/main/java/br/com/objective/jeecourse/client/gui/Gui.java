package br.com.objective.jeecourse.client.gui;

import br.com.objective.jeecourse.core.Calculator;
import br.com.objective.jeecourse.core.CalculatorFactory;
import br.com.objective.jeecourse.proxy.ProxyCalculatorFactory;

public class Gui {

	public static void main(String[] args) {
		new Gui();
	}

	private Gui() {
		CalculatorFactory factory = new ProxyCalculatorFactory();
		Calculator calculator = factory.newCalculator();
		View view = new View();
		
		new Controller(calculator, view);
	}
}
