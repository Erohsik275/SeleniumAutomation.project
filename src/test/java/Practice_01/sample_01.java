package Practice_01;

import java.io.File;
import java.util.Arrays;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class sample_01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/upload-download");
		driver.manage().window().maximize();
//		driver.findElement(By.id("alertButton")).click();
//		
//		//Alert to accept 
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
//		
//		//wait for 5 seconds and accept the alert
//		driver.findElement(By.id("timerAlertButton")).click();
//		Thread.sleep(6000);
//		alert.accept();
//		driver.quit();
		driver.findElement(By.id("downloadButton")).click();
		Thread.sleep(3000);
		File folder = new File("C:\\Users\\Kishore\\Downloads");
		File[] files = folder.listFiles(File::isFile);
		File latestFile = Arrays.stream(files)
                .max((f1, f2) -> Long.compare(f1.lastModified(), f2.lastModified()))
                .orElse(null);
		System.out.println(latestFile);
	}

}
