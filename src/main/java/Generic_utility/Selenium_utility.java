package Generic_utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectrepository.LoginPage;

/**This has generic methods of Selenium
 * @author HP
 */
public class Selenium_utility {

	/**This window will maximize window
	 * @param driver 
	 * 
	 */
	public void maxmizewindow(WebDriver driver)
	{
		
		driver.manage().window().maximize();
	}
	
	public void url(WebDriver driver)
	{
		driver.get("https://www.saucedemo.com/");
	}
	public void minimizewindow(WebDriver driver)
	{
		
		driver.manage().window().minimize();
	}
	public void alertpresentornot(WebDriver driver)
	{
		 boolean isAlertPresent = false;
         try {
             driver.switchTo().alert();  // Try switching to the alert
             isAlertPresent = true;      // If no exception, alert is present
         } catch (NoAlertPresentException e) {
             isAlertPresent = false;     // If exception, alert is not present
         }

         // If the alert is present, accept it, otherwise skip the step
         if (isAlertPresent) {
             // Handle the alert
             Alert alert = driver.switchTo().alert();
             alert.accept(); // Accept the alert
             System.out.println("Alert was present and has been accepted.");
         } else {
             // Skip the alert handling step and continue
             System.out.println("No alert present, skipping alert handling.");
         }
	}
	
	public void implicitwait(WebDriver driver)
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void explicitwaitwait(WebDriver driver, WebElement element)
	{
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void selectbydropdownindex(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	public void selectbydropdowntext(WebElement element, String text)
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	public void selectbydropdownvalue(WebElement element, String value)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	
	public void dragndropactions(WebDriver driver, WebElement source, WebElement target)
	{
		Actions action = new Actions(driver);
		action.dragAndDrop(source,target).build().perform();
		
	}
	
	public void clicknholdactions(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.clickAndHold().build().perform();
	}
	public void rightclickactions(WebDriver driver, WebElement element)
	{
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}
	
	public void mousehover(WebElement element, WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	public void doubleclick(WebElement element, WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}
	public void scrollactions(WebElement element, WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.scrollToElement(element).build().perform();
	}
	
	public void handleFrame(WebDriver driver, WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	public void handleFrame(WebDriver driver, String framenameOrID)
	{
		driver.switchTo().frame(framenameOrID);
	}
	
	public void dismissalert(WebDriver driver, String frameelement)
	{
		driver.switchTo().frame(frameelement);
		
	}
	
	public void acceptalert(WebDriver driver)
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void gettextalert(WebDriver driver)
	{
		Alert alert = driver.switchTo().alert();
		alert.getText();
	}
	public void sendkeysalert(WebDriver driver,String text)
	{
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
	}
	
	public void handlewindow(WebDriver driver,String windowID)
	{
		driver.switchTo().window(windowID);
	}
	
	public static String screenshot(WebDriver driver, String screenshotname) throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File format = screenshot.getScreenshotAs(OutputType.FILE);
		File savepath = new File(".\\Screenshots\\"+screenshotname+".jpeg");
		Files.copy(format.toPath(), savepath.toPath());
		return savepath.getAbsolutePath();
			
	}
	
	public void continuetocheckout(WebDriver driver)
	{
		driver.findElement(By.id("continue")).click();
	}
	
	public void loginapp(WebDriver driver) throws Exception {
		
		
		File_utility futil = new File_utility();
		String Username = futil.propertyfile("username");
		String Password = futil.propertyfile("password");
		Selenium_utility sutil = new Selenium_utility();
		sutil.url(driver);
		sutil.maxmizewindow(driver);
		LoginPage lp = new LoginPage(driver);
		lp.Logintheapp(Username, Password);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
