package Practice_01;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion_practice {

	@Test(retryAnalyzer = Generic_utility.retryanalizer.class)
	public void hardassert()
	{
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
		
		Assert.assertEquals(2, 2);
		
		System.out.println("4");
		System.out.println("5");
		System.out.println("6");
	}
	
	@Test
	public void softassert()
	{
		SoftAssert s = new SoftAssert();
		
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
		
		s.assertEquals(2, 2);
		
		System.out.println("4");
		System.out.println("5");
		System.out.println("6");
		
		s.assertAll();//log
	}
	
	
	
	
	
	
	
	
}
