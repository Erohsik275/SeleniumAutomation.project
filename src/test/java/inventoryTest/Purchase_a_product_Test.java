package inventoryTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Generic_utility.Baseclass;

public class Purchase_a_product_Test extends Baseclass{

	@Test
	public void TC_02_Purchaseaproduct() throws Exception
	
	{
		
				
				//Select the product
				String ProductName = allutil.futil.propertyfile("productname");
				obj.ip.clickonproductname(driver, ProductName);
				
				//Add the product to cart
				driver.findElement(By.id("add-to-cart")).click();
				
				//go to cart
				obj.ip.clickoncarticon();
				
				//Checkout
				obj.cp.checkouttheproduct();
				
				//Fill the Address and checkout
				obj.cp.address();
				allutil.sutil.continuetocheckout(driver);
				driver.findElement(By.id("finish")).click();
				
				

	}

}
