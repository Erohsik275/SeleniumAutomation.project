package Practice_01;

import org.testng.annotations.DataProvider;
//import org.testng.Assert;
import org.testng.annotations.Test;

public class Testng_practise {

	/*
	 * invocation is for times of execution & priority is for fixing the place for execution
	 */
	@Test(invocationCount = 2, priority = 2)
	public void sample()
	{
		//Assert.fail();  //forcefully fails to run
		System.out.println("Kishore");
		
	}
	
	@Test(enabled = false)
	public void sample1()
	{
		System.out.println("Kishore R");
		
	}
	
	@Test(dependsOnMethods = "sample")// skip
	public void sample2()
	{
		System.out.println("Erohsik");
		
	}
	
	@Test(dataProvider = "storedata")
	public void sample3(int id , String name)
	{
		System.out.println("The ID is : "+id+"\nThe name is : "+name);
		
	}
	
	@DataProvider
	public Object[][] storedata()
	{
		Object [][] datas = new Object[2][2];
		
		//1st Data
		datas[0][0] = 12;
		datas[0][1] = "Kishore";
		
		//1st Data
		datas[1][0] = 15;
		datas[1][1] = "Erohsik";
		
		return datas;
	}
}
