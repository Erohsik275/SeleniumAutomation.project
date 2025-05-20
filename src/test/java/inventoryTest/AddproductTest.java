package inventoryTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import Generic_utility.Baseclass;


public class AddproductTest extends Baseclass{

	@Test
	public void TC_01_Addproducttocarttest() throws Exception
	
	{
		// TODO Auto-generated method stub

				
				//Select the product
				String ProductName = allutil.futil.propertyfile("productname");
				obj.ip.clickonproductname(driver, ProductName);
				
				//Add the product to cart
				driver.findElement(By.id("add-to-cart")).click();
				
				//go to cart
				driver.findElement(By.id("shopping_cart_container")).click();


	}

}
