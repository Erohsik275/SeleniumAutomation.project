package Practice_01;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Generic_utility.File_utility;
import Generic_utility.Selenium_utility;
import objectrepository.LoginPage;

public class purchaseproduct_withutilities {

	public static void main(String[] args) throws IOException, TimeoutException {
		
		
		//initialize the utilities
		File_utility futil = new File_utility();
		//Java_utility jutil = new Java_utility();
		Selenium_utility sutil = new Selenium_utility();
		
		
		
		ChromeOptions pop = new ChromeOptions();
	     pop.addArguments("--disable-notifications");
	     pop.addArguments("--disable-popup-blocking");
		ChromeDriver driver = new ChromeDriver(pop);
		
		sutil.url(driver);
		sutil.maxmizewindow(driver);
		sutil.implicitwait(driver);
		
		
		//Login
		String Username = futil.propertyfile("username");
		String Password = futil.propertyfile("password");
		LoginPage lp = new LoginPage(driver);
//		lp.getUsernameTxt().sendKeys(Username);
//		lp.getPasswordTxt().sendKeys(Password);
//		lp.getLoginbtn().click();
		
		lp.Logintheapp(Username, Password);
		
		//Add-to-cart
		
		driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
		
		driver.findElement(By.id("add-to-cart")).click();
		
		driver.findElement(By.className("shopping_cart_link")).click();
		sutil.alertpresentornot(driver);
		
		//Payment process
		 
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("abcde");
		driver.findElement(By.id("last-name")).sendKeys("fghij");
		driver.findElement(By.id("postal-code")).sendKeys("123456");
		driver.findElement(By.id("continue")).click();
		
		driver.findElement(By.id("finish")).click();
		
		driver.findElement(By.id("back-to-products")).click();
		
		
//		String sample = "image-"+jutil.systemdate();
//		String path = Selenium_utility.screenshot(driver, sample );
//		System.out.println(path);
		
		//Logout
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		driver.quit();
		
	}

}
