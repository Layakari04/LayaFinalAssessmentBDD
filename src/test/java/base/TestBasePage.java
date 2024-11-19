package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBasePage {
	
	private static TestBasePage testBasepage;
	private static WebDriver driver;
	
	private TestBasePage() {
		String strBrowser = "Chrome";
		if(strBrowser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();	
		}
		else if(strBrowser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		System.out.println("Driver obj..." + driver);
	}
 public static void initDriver() {
	 if(testBasepage==null) {
		 testBasepage = new TestBasePage();
	 }

}
 public static WebDriver getDriver() {
	 return driver;
	 }
 public static void openUrl(String url) {
	 driver.get(url);
	 }
 public static void tearDown() {
	 if(driver!=null) {
		 driver.close();
		 driver.quit();
	 }
 }
}
