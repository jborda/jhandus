package br.com.objective.jeecourse.core;

import java.util.Arrays;


class HugeInteger implements Comparable<HugeInteger> {
	
	private String stringValue;
	private int[] arrayValue;
	private boolean negative;

	HugeInteger(String value) {
		this.stringValue = value;
		
		initializeFromString();
	}
	
	HugeInteger(int[] arrayValue, boolean negative) {
		this.arrayValue = arrayValue;
		this.negative = negative;
		
		initializeFromArrayAndNegativeFlag();
	}

	private void initializeFromArrayAndNegativeFlag() {
		StringBuilder valueBuilder = new StringBuilder();
		
		if (negative)
			valueBuilder.append("-");
		
		for (int i = arrayValue.length - 1; i >= 0; i--)
			valueBuilder.append(arrayValue[i]);

		stringValue = valueBuilder.toString();
	}

	private void initializeFromString() {
		negative = stringValue.startsWith("-");
		arrayValue = new int[negative ? stringValue.length() - 1 : stringValue.length()];

		char[] charArray = stringValue.toCharArray();
		int reverseIndex = arrayValue.length - 1;
		
		for (int i = (negative ? 1 : 0); i < charArray.length; i++)
			arrayValue[reverseIndex--] = Integer.valueOf(String.valueOf(charArray[i]));
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
		if (compareTo(other) >= 0)
			return subtract(this, other, false);
		else
			return subtract(other, this, true);
	}

	private HugeInteger subtract(HugeInteger greatValue, HugeInteger lessValue, boolean negative) {
		int maxSize = Math.max(greatValue.size(), lessValue.size());
		int[] resultArray = new int[maxSize];
		int rest = 0;

		for (int i = 0; i < maxSize; i++) {
			int result = greatValue.getValueAt(i) - lessValue.getValueAt(i) - rest;

			if (result < 0) {
				rest = 1;
				result += 10;
			} else {
				rest = 0;
			}
			
			resultArray[i] = result;
		}

		return new HugeInteger(resultArray, negative);
	}
	
	@Override
	public String toString() {
		return stringValue;
	}
	
	public int size() {
		return arrayValue.length;
	}
	
	public int getValueAt(int index) {
		return (size() > index) ? arrayValue[index] : 0;
	}
	
	public boolean isNegative() {
		return negative;
	}

	@Override
	public int compareTo(HugeInteger other) {
		if (!isNegative() && other.isNegative())
			return 1;
		
		if (isNegative() && !other.isNegative())
			return -1;

		if (size() > other.size())
			return negative ? -1 : 1;

		if (size() < other.size())
			return negative ? 1 : -1;
		
		for (int i = size() -1; i >= 0; i--) {
			if (getValueAt(i) == other.getValueAt(i))
				continue;
			
			if (getValueAt(i) > other.getValueAt(i))
				return negative ? -1 : 1;
			
			return negative ? 1 : -1;
		}
		
		return 0;
	}
	
}
