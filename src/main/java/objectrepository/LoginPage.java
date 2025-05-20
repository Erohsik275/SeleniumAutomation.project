package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{

	@FindBy(id="user-name")
	private WebElement usernameTxt;
	
	@FindBy(id = "password") 
	private WebElement passwordTxt;
	
	@FindBy(id = "login-button") 
	private WebElement Loginbtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameTxt() {
		return usernameTxt;
	}

	public WebElement getPasswordTxt() {
		return passwordTxt;
	}

	public WebElement getLoginbtn() {
		return Loginbtn;
	}
	
	public void Logintheapp(String usn, String pswd)
	{
		usernameTxt.sendKeys(usn);
		passwordTxt.sendKeys(pswd);
		Loginbtn.click();
	}
	
	
	

}
