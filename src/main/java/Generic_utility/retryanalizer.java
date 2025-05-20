package Generic_utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryanalizer implements IRetryAnalyzer{

	int count = 0;
	int retrycount = 2;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		while(count<retrycount)
		{
			count ++;
			return true;
		}
		return false;
	}
	
	

}
