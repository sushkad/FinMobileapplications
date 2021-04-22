import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.Test;

public class InternetBanking extends IbStatic
{
	AppiumDriver<MobileElement> d;

	@BeforeSuite
	public void setUp() throws InterruptedException, IOException 
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "V2025");
		cap.setCapability("browserName", "Chrome");
		d = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		d.get("http://103.78.168.227:9596/UAT_IB/");
		d.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		d.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(enabled=true)
	public void Login() throws InterruptedException, IOException
	{
		d.findElement(By.xpath(Username)).sendKeys("1173159");
		System.out.println("Enter user name");
		Thread.sleep(2000);

		d.findElement(By.xpath(Password)).sendKeys("fincore@1234");
		System.out.println("Enter Password");

		Thread.sleep(30000);
		TakesScreenshot scrShot =((TakesScreenshot)d);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("E://FIN_MobiConnect//screenshots//ib//file1.png");
		FileUtils.copyFile(SrcFile, DestFile);
		Thread.sleep(3000);

		d.findElement(By.xpath(Login)).click();
		System.out.println("Click on Login button");

		Thread.sleep(30000);
		JavascriptExecutor jse = (JavascriptExecutor)d;
		jse.executeScript("window.scrollBy(0,450)");
		System.out.println("Scroll Successfully");
		Thread.sleep(2000);
		
		//d.findElement(By.partialLinkText("View")).click();
		d.findElement(By.xpath(View)).click();
		System.out.println("Click on View button");
		Thread.sleep(2000);

		d.findElement(By.xpath(Accountnumber)).click();
		System.out.println("Click on Account Number Drop down list");

		d.findElement(By.xpath(Blockuserid)).sendKeys(Keys.DOWN);
		System.out.println("Down list Blockuserid"); 
		Thread.sleep(200);

		d.findElement(By.xpath(Blockuserid)).sendKeys(Keys.ENTER);
		System.out.println("Blockuserid Select menu");
		Thread.sleep(30000);

		TakesScreenshot scrShot1 =((TakesScreenshot)d);
		File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
		File DestFile1=new File("E://FIN_MobiConnect//screenshots//ib//error.png");
		FileUtils.copyFile(SrcFile1, DestFile1);

		Thread.sleep(3000);

		
	
	}

	public void tearDown()
	{
		d.quit();
	}
}


