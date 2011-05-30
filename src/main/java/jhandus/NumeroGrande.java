package jhandus;

public class NumeroGrande {

	private String value;
	private int[] array;
	
	public NumeroGrande(String value) {
		this.value = value;
		this.geraArrayFromValue();
	}

	private void geraArrayFromValue() {
		
		array = new int[value.length()];
		for (int x = 0; x < value.length(); x++)
			array[x] = Integer.valueOf(value.substring(x, x+1));
	}
	
	public NumeroGrande mais(NumeroGrande outro) {
		
		String valor = "";
		int resto = 0;
		int x = this.getArray().length -1, y = outro.getArray().length -1;
		for (; x >= 0  && y >= 0; x--, y--) {
			int um = this.getArray()[x];
			int dois = outro.getArray()[y];
			int tres = um + dois + resto;
			int quatro = 0;

			if (tres > 9) {
				String sei = String.valueOf(tres);
				quatro = Integer.valueOf(sei.substring(1, 2));
				resto = Integer.valueOf(sei.substring(0, 1));
			} else {
				resto = 0;
				quatro = tres;
			}
			valor = quatro + valor;
		}
		
		for (; x >= 0; x--) {
			int um = this.getArray()[x];
			int tres = um + resto;
			int quatro = 0;

			if (tres > 9) {
				String sei = String.valueOf(tres);
				quatro = Integer.valueOf(sei.substring(1, 2));
				resto = Integer.valueOf(sei.substring(0, 1));
			} else {
				resto = 0;
				quatro = tres;
			}

			valor = quatro + valor;
		}

		for (; y >= 0; y--) {
			int um = outro.getArray()[y];
			int tres = um + resto;
			int quatro = 0;

			if (tres > 9) {
				String sei = String.valueOf(tres);
				quatro = Integer.valueOf(sei.substring(1, 2));
				resto = Integer.valueOf(sei.substring(0, 1));
			} else {
				resto = 0;
				quatro = tres;
			}
			
			valor = quatro + valor;
		}

		if (resto > 0)
			valor = resto + valor;

		return new NumeroGrande(valor);
	}
	
	public String getValue() {
		return value;
	}
	
	protected int[] getArray() {
		return array;
	}
}