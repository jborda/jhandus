package jhandus;

import java.util.Arrays;


public class HugeInteger {
	
	private String value;
	private int[] valueArray;
	private boolean negative;

	public HugeInteger(String value) {
		this.value = value;
		
		initializeFromString();
	}
	
	public HugeInteger(int[] valueArray, boolean negative) {
		this.valueArray = valueArray;
		this.negative = negative;
		
		initializeFromArrayAndNegativeFlag();
	}

	private void initializeFromArrayAndNegativeFlag() {
		StringBuilder valueBuilder = new StringBuilder();
		
		if (negative)
			valueBuilder.append("-");
		
		for (int i = valueArray.length - 1; i >= 0; i--)
			valueBuilder.append(valueArray[i]);

		value = valueBuilder.toString();
	}

	private void initializeFromString() {
		negative = value.startsWith("-");
		valueArray = new int[negative ? value.length() - 1 : value.length()];

		char[] charArray = value.toCharArray();
		int reverseIndex = valueArray.length - 1;
		
		for (int i = (negative ? 1 : 0); i < charArray.length; i++)
			valueArray[reverseIndex--] = Integer.valueOf(String.valueOf(charArray[i]));
	}

	public HugeInteger add(HugeInteger other) {
		int maxSize = Math.max(size(), other.size());
		int[] resultArray = new int[maxSize];

		int rest = 0;
		
		for (int i = 0; i < maxSize; i++) {
			int result = getValueAt(i) + other.getValueAt(i) + rest;
			
			if (result > 9) {
				rest = result / 10;
				result = result - (rest * 10);
			} else {
				rest = 0;
			}
			
			resultArray[i] = result;
		}
		
		if (rest > 0) {
			resultArray = Arrays.copyOf(resultArray, resultArray.length + 1);
			resultArray[resultArray.length - 1] = rest;
		}

		return new HugeInteger(resultArray, false);
	}
	
	public HugeInteger subtract(HugeInteger other) {
		int maxSize = Math.max(size(), other.size());
		int[] resultArray = new int[maxSize];

		int rest = 0;
		boolean negative = false;
		
		for (int i = 0; i < maxSize; i++) {
			boolean last = i == maxSize - 1;
			int result = getValueAt(i) - other.getValueAt(i) - rest;
			
			if (result < 0) {
				if (last) {
					negative = true;
					result = Math.abs(result);
				} else {
					rest = 1;
					result = 10 + result;
				}
			} else {
				rest = 0;
			}
			
			resultArray[i] = result;
		}

		return new HugeInteger(resultArray, negative);
	}

	@Override
	public String toString() {
		return value;
	}
	
	public int size() {
		return valueArray.length;
	}
	
	public int getValueAt(int index) {
		return (size() > index) ? valueArray[index] : 0;
	}
	
	public boolean isNegative() {
		return negative;
	}
	
}
