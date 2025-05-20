package Practice_01;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class productremove {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		ChromeOptions pop = new ChromeOptions();
	     pop.addArguments("--disable-notifications");
	     pop.addArguments("--disable-popup-blocking");
		EdgeDriver a = new EdgeDriver();
		//Selenium_utility sutil = new Selenium_utility();
		
		//implicit wait
		a.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//open the URL 
		a.get("https://www.saucedemo.com/");
		a.manage().window().maximize();
	
		
		//Login
		a.findElement(By.id("user-name")).sendKeys("standard_user");
		a.findElement(By.id("password")).sendKeys("secret_sauce");
		a.findElement(By.id("login-button")).click();
		
		
		
		
		String productname = "Sauce Labs Fleece Jacket";
		
	
		List<WebElement> items = a.findElements(By.className("inventory_item_description"));
		for(WebElement name : items)
		{
			String itemname = name.findElement(By.className("inventory_item_name")).getText();
			if(itemname.equalsIgnoreCase(productname))
			{
				String price = name.findElement(By.className("inventory_item_price")).getText();
				System.out.println("The product price is - "+price);
			}
		}
	}

}
