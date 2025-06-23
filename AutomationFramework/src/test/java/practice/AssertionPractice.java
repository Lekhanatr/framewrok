package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	
	@Test
	public void sample() {
		System.out.println("sample 1");
		System.out.println("sample 2");
		System.out.println("sample 3");
		
		Assert.assertEquals(0, 1);
		System.out.println("sample 4");
		System.out.println("sample 5");
	}
	
	
	@Test
	public void sampleSoft() {
		SoftAssert sa = new SoftAssert();
		System.out.println("sample 1");
		System.out.println("sample 2");
		System.out.println("sample 3");
		
		sa.assertEquals(0, 1);
		
		System.out.println("sample 4");
		
		sa.assertEquals(0, 1);
		
		System.out.println("sample 5");
		
		sa.assertAll();
		
	}

}
