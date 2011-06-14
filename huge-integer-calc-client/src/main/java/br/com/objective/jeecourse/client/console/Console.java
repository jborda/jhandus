package br.com.objective.jeecourse.client.console;

import java.io.IOException;

import br.com.objective.jeecourse.client.proxy.ProxyCalculatorFactory;
import br.com.objective.jeecourse.core.Calculator;

public class Console {
	
	Calculator calculator = new ProxyCalculatorFactory().newCalculator();
	OPTION option;
	String result;
	
	enum OPTION {
		A("add"),
		S("subtract"),
		C("compare"),
		X("sair");
		
		String operationName;
		
		public String getOperationName() {
			return operationName;
		}
		
		OPTION(String operation) {
			this.operationName = operation;
		}
	}

	public static void main(String[] args) {
		new Console().start();
	}

	private void start() {
		mostraOperacoes();
		buscaOperacao();
		
		if (option == OPTION.X)
			System.exit(0);
		
		String left = buscaNumero();
		String right = buscaNumero();
		executaOperacao(left, right);
		mostraResultado();
		start();
	}

	private void mostraResultado() {
		System.out.println("Result:" + result);
	}

	private String buscaNumero() {
		return getInUser("Informe um número");
	}
	
	private void executaOperacao(String left, String right) {
		switch (option) {
		case A:
			result = calculator.add(left, right);
			break;
		case S:
			result = calculator.subtract(left, right);
			break;
		case C:
			result = String.valueOf(calculator.compare(left, right));
			break;
		}
	}

	private String getInUser(String message) {
		System.out.print(message);
		byte[] awnser = new byte[1024];
		try {
			System.in.read(awnser);
		} catch (IOException e) {
			System.out.println("Erro ao obter resposta. Tente novamente!");
		}
		
		return new String(awnser).trim();
	}

	private void buscaOperacao() {
		
		String in = getInUser("Operação desejada... ");
		
		try {
			setOption(in);
		} catch (IllegalArgumentException iae) {
			mostraErroOpcaoInvalida();
			start();
		}
	}

	private void mostraErroOpcaoInvalida() {
		System.out.println("\nOpção inválida. Tente novamente!\n");
	}

	private void mostraOperacoes() {
		System.out.println("Operações válidas:");
		for (OPTION option : OPTION.values())
			System.out.println(
					"[" + 
					option.name().toLowerCase() + 
					"]" + 
					option.getOperationName()
			);
	}
	
	public void setOption(String option) {
		OPTION newOption = OPTION.valueOf(option.toUpperCase());
		this.option = newOption;
	}
}
