package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements IAutoConst {
	public WebDriver driver;
	
 static {
	 System.setProperty(CHROME_KEY, CHROME_VALUE);
 }
 
 @BeforeMethod
 public void openApp(){
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.get(url);	 
 }
 
 public static int passcount=0 , failcount=0;
 
 @AfterMethod
 public void closeApp(ITestResult res) {
	 String name=res.getName();
	 int status = res.getStatus();
	 if(status==1) {
		 passcount++;
		 System.out.println("passcount is"+passcount);
	 } else {
		 failcount++;	
		 System.out.println("failcount is"+failcount);
		 String path1=photopath+name+".png";
		 fwutil.getphoto(path1, driver);
		 Reporter.log("photopath"+path1, true);
	 }
    
	driver.close();
 }
 
 @AfterSuite
 public void print() {
	 Reporter.log("passStatus"+passcount,true);
	 Reporter.log("failStatus"+failcount,true);
	 fwutil.setxl(resultpath, "loginsheet", 0, 3, passcount);
	 fwutil.setxl(resultpath, "loginsheet", 0, 1, failcount);
 }
	

}
