package objectrepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_utility.File_utility;

public class cartpage {

	@FindBy (xpath = "//div[text()='Sauce Labs Backpack']")
	private WebElement productname;
	

	@FindBy (xpath = "//button[text()='Remove']")
	private WebElement removebtn;
	
	
	@FindBy (xpath = "//div[text()='29.99']")
	private WebElement price;
	
	
	@FindBy (id = "checkout")
	private WebElement checkout;
	
	@FindBy (id = "first-name")
	private WebElement firstname;
	
	@FindBy (id = "last-name")
	private WebElement lastname;
	
	@FindBy (id = "postal-code")
	private WebElement zipcode;

	
	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getZipcode() {
		return zipcode;
	}


	public cartpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductname() {
		return productname;
	}


	public WebElement getRemovebtn() {
		return removebtn;
	}


	public WebElement getPrice() {
		return price;
	}


	public WebElement getCheckout() {
		return checkout;
	}
	public String captureitemname()
	{
		return productname.getText();
	}
	
	public void checkouttheproduct()
	{
		checkout.click();
	}
	
	public void address() throws IOException
	{
		File_utility fu = new File_utility();
		String FirstName = fu.propertyfile("firstname");
		String LastName = fu.propertyfile("lastname");
		String ZipCode = fu.propertyfile("zipcode");
		firstname.sendKeys(FirstName);
		lastname.sendKeys(LastName);
		zipcode.sendKeys(ZipCode);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
