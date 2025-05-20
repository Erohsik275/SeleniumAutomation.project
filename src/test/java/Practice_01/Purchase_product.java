package Practice_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Purchase_product {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		ChromeOptions pop = new ChromeOptions();
	     pop.addArguments("--disable-notifications");
	     pop.addArguments("--disable-popup-blocking");
		ChromeDriver a = new ChromeDriver(pop);
		a.get("https://www.saucedemo.com/");
		a.manage().window().maximize();
		a.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//Login
		a.findElement(By.id("user-name")).sendKeys("standard_user");
		a.findElement(By.id("password")).sendKeys("secret_sauce");
		a.findElement(By.id("login-button")).click();
		
		//Add-to-cart
		a.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
		a.findElement(By.id("add-to-cart")).click();
		a.findElement(By.className("shopping_cart_link")).click();
		
		
		//Payment process
		a.findElement(By.id("checkout")).click();
		a.findElement(By.id("first-name")).sendKeys("abcde");
		a.findElement(By.id("last-name")).sendKeys("fghij");
		a.findElement(By.id("postal-code")).sendKeys("123456");
		a.findElement(By.id("continue")).click();
		
		a.findElement(By.id("finish")).click();
		
		a.findElement(By.id("back-to-products")).click();
		
		

		//Logout
		a.findElement(By.id("react-burger-menu-btn")).click();
		a.findElement(By.id("logout_sidebar_link")).click();
	}
}
