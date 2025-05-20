package objectrepository;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inventoryitempage {

	
	
	@FindBy (xpath = "//div[text()='29.99']")
	private WebElement price;
	
	@FindBy (xpath = "//button[text()='Remove']")
	private WebElement removebtn;

	public WebElement getPrice() {
		return price;
	}

	public WebElement getRemovebtn() {
		return removebtn;
	}
	
	public Inventoryitempage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void removeproductfromcart(String productname, WebDriver driver)
	{
		List<WebElement> products = driver.findElements(By.className("cart_item"));
		for(WebElement items : products)
		{
			String itemname = items.findElement(By.className("inventory_item_name")).getText();
			if(itemname.equalsIgnoreCase(productname))
			{
				removebtn.click();
				System.out.println("the product has been removed");
			}
			else
			{
				System.out.println("There is no product in such name");
			}
		}
	}
	
	
	public void getpricedetails(String productname, WebDriver driver)
	{
		List<WebElement> items = driver.findElements(By.className("inventory_item_description"));
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
