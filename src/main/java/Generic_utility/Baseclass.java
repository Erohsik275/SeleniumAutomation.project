package Generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import objectrepository.objectrepo_initialize;

public class Baseclass {

	
	public Utility_initialize allutil = new Utility_initialize();
	public objectrepo_initialize obj;
	public WebDriver driver;
	public static WebDriver driver1;
	

	
	@BeforeSuite(alwaysRun = true)
	public void brforedbsuite()
	{
		System.out.println("----------Data base connected successfully-----------");
	}
	
	//@Parameters("launchbrowser")
	//@BeforeTest(alwaysRun = true)
	@BeforeClass(alwaysRun = true)
	public void beforeclssuite() //use String browser if use of parameters
	{
		
		driver = new ChromeDriver();
//		if(browser.equals("edge"))
//		
//		{
//			driver = new EdgeDriver();
//		}
//		else if (browser.equals("firefox"))
//		{
//			driver = new FirefoxDriver();
//		}
	
		allutil.sutil.url(driver);
		allutil.sutil.maxmizewindow(driver);
		obj = new objectrepo_initialize(driver);
		System.out.println("----------browser connected successfully-----------");
		driver1 = driver;
	}
	
	
	
	@BeforeMethod(alwaysRun = true)
	public void beforemethodsuite() throws Exception
	{
		allutil.sutil.loginapp(driver);
		System.out.println("----------Loged in successfully-----------");
	}
	
	@AfterMethod(alwaysRun = true)
	public void aftermethodsuite()
	{
		obj.ip.logoutapp(driver);
		System.out.println("----------Loged out successfully-----------");
	}
	
	@AfterClass(alwaysRun = true)
	public void afterclasssuite()
	{
		driver.quit();
		System.out.println("----------browser disconnected successfully-----------");
	}
	
	@AfterSuite(alwaysRun = true)
	public void afterdbsuite()
	{
		System.out.println("----------Data base disconnected successfully-----------");
	}
}
