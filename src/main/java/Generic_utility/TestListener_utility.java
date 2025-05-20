package Generic_utility;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestListener_utility implements ITestListener{
	
	ExtentReports er;
	ExtentTest test;

    @Override
    public void onTestFailure(ITestResult result) {
    	
    	test.log(Status.FAIL, result.getMethod().getMethodName());
    	test.log(Status.WARNING, result.getThrowable());
        try {
            
            String screenshotName = result.getMethod().getMethodName()+Java_utility.systemdate();

            String path = Selenium_utility.screenshot(Baseclass.driver1, screenshotName);
            System.out.println("Failed Test Screenshot : " + screenshotName+Java_utility.systemdate());
            //System.out.println(result.getThrowable());
            test.addScreenCaptureFromPath(path);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
	public void onTestStart(ITestResult result) {
		
		String methodname = result.getMethod().getMethodName();
		
		//create test in extent report
		test = er.createTest(methodname);

	}
	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test result Passed :"+result.getTestClass().getName());
		
		//log the status as PASS
		test.log(Status.PASS, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test result Skipped :"+result.getMethod().getMethodName());
		
		//log the status as SKIP
		test.log(Status.SKIP, result.getMethod().getMethodName());
    	test.log(Status.WARNING, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		//Basic config of extent
		File folder  = new File("C:\\Users\\Kishore\\eclipse-workspace\\Automation_Project\\ExtentReport");
		int count = folder.listFiles(f -> f.isFile()).length;
		long num = count+1;
		String filename = String.format(".\\ExtentReport\\Report %02d - %s.html", num, Java_utility.systemdate());
		ExtentSparkReporter extentspark = new ExtentSparkReporter(filename);
		extentspark.config().setDocumentTitle("REPORTS");
		extentspark.config().setTheme(Theme.DARK);
		extentspark.config().setReportName("Automation Framework");
		
		//report generation
		er = new ExtentReports();
		er.attachReporter(extentspark);
		er.setSystemInfo("Base Browser", "Egde");
		er.setSystemInfo("Enviroment", "Automation Testing");
		er.setSystemInfo("Reporter Name", "Erohsik");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		//Report generation extent report
		er.flush();
		
	}
    
}