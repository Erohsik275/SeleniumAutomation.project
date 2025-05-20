package Practice_01;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Remove_a_product {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		ChromeOptions pop = new ChromeOptions();
	     pop.addArguments("--disable-notifications");
		ChromeDriver a = new ChromeDriver(pop);
		a.get("https://www.saucedemo.com/");
		a.manage().window().maximize();
		
		//Login
		a.findElement(By.id("user-name")).sendKeys("standard_user");
		a.findElement(By.id("password")).sendKeys("secret_sauce");
		a.findElement(By.id("login-button")).click();
		
		//Add-to-cart
		a.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
		a.findElement(By.id("add-to-cart")).click();
		a.findElement(By.className("shopping_cart_link")).click();
		
		//Remove from cart
		a.findElement(By.id("remove-sauce-labs-backpack")).click();
		Thread.sleep(2000);

		//Logout
		a.findElement(By.id("react-burger-menu-btn")).click();
		a.findElement(By.id("logout_sidebar_link")).click();
	}

}
