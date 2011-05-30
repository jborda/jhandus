package jhandus;

import org.junit.Assert;
import org.junit.Test;

public class NumeroGrandeTest {

	@Test
	public void mais() {
		NumeroGrande um = new NumeroGrande("9925");
		NumeroGrande dois = new NumeroGrande("118");
		
		NumeroGrande tres = um.mais(dois);
		Assert.assertEquals("10043", tres.getValue());
		
	}
	public static void main(String[] args) {
		System.out.println(9925 + 118);
		System.out.println("123".substring(2, 3));
	}
}
