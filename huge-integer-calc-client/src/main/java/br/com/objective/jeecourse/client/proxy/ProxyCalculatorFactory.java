package br.com.objective.jeecourse.client.proxy;

import br.com.objective.jeecourse.core.Calculator;
import br.com.objective.jeecourse.core.CalculatorFactory;

public class ProxyCalculatorFactory implements CalculatorFactory {
	
	private String host;
	private int port;

	public ProxyCalculatorFactory() {
		this("localhost", 1234);
	}
	
	public ProxyCalculatorFactory(String host, int port) {
		this.host = host;
		this.port = port;
	}

	@Override
	public Calculator newCalculator() {
		return new ProxyCalculator(host, port);
	}

}
