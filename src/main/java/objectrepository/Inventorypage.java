package objectrepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Inventorypage {

	

	
	@FindBy (id = "shopping_cart_container")
	private WebElement carticon;
	
	@FindBy (xpath = "//select['product_sort_container']")
	private WebElement sortdropdown;
	
	@FindBy (id = "react-burger-menu-btn")
	private WebElement menubtn;
	
	@FindBy(linkText = "Logout")
	private WebElement logoutLnk;
	
	public Inventorypage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}



	public WebElement getCarticon() {
		return carticon;
	}

	public WebElement getSortdropdown() {
		return sortdropdown;
	}

	public WebElement getMenubtn() {
		return menubtn;
	}

	public WebElement getLogoutLnk() {
		return logoutLnk;
	}
	
	
	
	public void clickonproductname(WebDriver driver,String productname)
	{
		driver.findElement(By.xpath("//div[text()='"+productname+"']")).click();
		
	}
	
	public void clickoncarticon()
	{
		carticon.click();
	}
	
	public void filteroptions(WebDriver driver, String sortoption)
	{
		sortdropdown.click();
		driver.findElement(By.xpath("//option[.='"+sortoption+"']")).click();
	}
	
	
	public void logoutapp(WebDriver driver) 
	{
	    menubtn.click();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.elementToBeClickable(logoutLnk));
	    logoutLnk.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
