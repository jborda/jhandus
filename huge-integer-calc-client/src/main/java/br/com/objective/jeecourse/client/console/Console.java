package br.com.objective.jeecourse.client.console;

import java.util.Scanner;

public class Console {
	
//	Calculator calculator = CalculatorFactory.newCalculator();

	public static void main(String[] args) {
		new Console().start();
	}

	private void start() {
		mostraOperacoes();
		buscaOperacao();
	}

	private void buscaOperacao() {
		String resp = "";
		Scanner scanner = new Scanner(resp);
		System.out.println("=========================");
		System.out.println(resp);
	}

	private void mostraOperacoes() {
		System.out.println("Operações válidas:");
		System.out.println("[a]add");
		System.out.println("[s]substract");
		System.out.println("[c]compare");
		System.out.print("Operação desejada... ");
	}

}
