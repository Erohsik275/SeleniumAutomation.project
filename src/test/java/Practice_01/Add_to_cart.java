package Practice_01;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Add_to_cart {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		// get the data
		FileInputStream fls = new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		Properties prop = new Properties();
		prop.load(fls);
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
		
		ChromeOptions pop = new ChromeOptions();
	     pop.addArguments("--disable-notifications");
	     pop.addArguments("--disable-popup-blocking");
		ChromeDriver a = new ChromeDriver(pop);
		
		a.get(URL);
		a.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		a.manage().window().maximize();
		
		
		//Login
		a.findElement(By.id("user-name")).sendKeys(USERNAME);
		a.findElement(By.id("password")).sendKeys(PASSWORD);
		a.findElement(By.id("login-button")).click();
		
		//Add-to-cart
		a.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
		a.findElement(By.id("add-to-cart")).click();
		a.findElement(By.className("shopping_cart_link")).click();
		
		
		

		//Logout
		a.findElement(By.id("react-burger-menu-btn")).click();
		a.findElement(By.id("logout_sidebar_link")).click();
	}

}
