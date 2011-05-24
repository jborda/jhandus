package jhandus;


public class HugeInteger {
	
	private final String value;
	private final int[] valueArray;

	public HugeInteger(String value) {
		this.value = value;
		this.valueArray = createArrayFromString(value);
	}
	
	public HugeInteger(int[] arrayValue) {
		this.value = createStringFromArray(arrayValue);
		this.valueArray = arrayValue;
	}

	private String createStringFromArray(int[] arrayValue) {
		
		StringBuilder valueBuilder = new StringBuilder();
		for (int index = arrayValue.length - 1; index >= 0; index--) {
			valueBuilder.append(arrayValue[index]);
		}
		
		return valueBuilder.toString();
	}

	private int[] createArrayFromString(String value) {
		
		int[] array = new int[value.length()];
		int reverseIndex = array.length -1;
		for (int index = 0; index < array.length; index++) {
			array[reverseIndex--] = Integer.valueOf(String.valueOf(value.charAt(index)));
		}
		
		return array;
	}

	public HugeInteger add(HugeInteger other) {
		
		int[] maxArray;
		int[] minArray;
		
		if (this.getValueArray().length >= other.getValueArray().length) {
			maxArray = this.getValueArray();
			minArray = other.getValueArray();
		} else {
			maxArray = other.getValueArray();
			minArray = this.getValueArray();
		}

		int[] resultArray = new int[maxArray.length + 1];
		int rest = 0;
		
		for (int index = maxArray.length; index > 0; index--) {
			int one = maxArray[index - 1];
			int two = (index > minArray.length) ? 0 : minArray[index - 1];
			int result = one + two + rest;
			if (result > 9) {
				result = result - 10;
				rest = 1;
			} else {
				rest = 0;
			}
			System.out.println(result);
			resultArray[index - 1] = result;
		}

		return new HugeInteger(resultArray);
	}

	@Override
	public String toString() {
		return value;
	}
	
	protected int[] getValueArray() {
		return valueArray;
	}
	
}
