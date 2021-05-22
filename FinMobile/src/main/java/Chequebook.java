import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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

public class Chequebook extends App
{
	private static final String DECLINE = null;
	public static URL url;
	public static DesiredCapabilities capabilities;
	public static AndroidDriver<MobileElement> d;

	@BeforeSuite
	public void setUp() throws InterruptedException, IOException 
	{

		try
		{
			final String URL_STRING = "http://127.0.1.1:4723/wd/hub";
			url = new URL(URL_STRING);

			capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "V2025");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
			//capabilities.setCapability(MobileCapabilityType.APP, "E:\\QA\\VAN.apk");
			capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
			capabilities.setCapability("APP_PACKAGE","com.finacus.ssblpps");
			capabilities.setCapability("APP_ACTIVITY","crc645eda2270212ad276.MainActivity");
			//capabilities.setCapability("APP_PACKAGE","com.vivo.calculator");
			//capabilities.setCapability("APP_PACKAGE","com.vivo.calculator.Calculator");
			//capabilities.setCapability("APP_ACTIVITY","crc645eda2270212ad276.SplashActivity");

			d = new AndroidDriver<MobileElement>(url,capabilities);
			//d.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			//d.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
			d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("End Before Method");	
		}

		catch (Exception e)
		{
			e.printStackTrace();
			//getscreenshot(d);
		}	

		//Thread.sleep(2000);
	}

	/*
	 * private void getscreenshot(AndroidDriver<MobileElement> d2) throws
	 * IOException { SimpleDateFormat sdf = new
	 * SimpleDateFormat("dd_MM_yyyy_hh_mm_ss"); Date date = new Date(); String
	 * fileName = sdf.format(date); File des = d.getScreenshotAs(OutputType.FILE);
	 * FileUtils.copyFile(des, new
	 * File(System.getProperty("E://FIN_MobiConnect//screenshots")+"//Screenshot//"+
	 * fileName+".png")); System.out.println("Screenshot is captured");
	 * 
	 * }
	 */

	/*
	 * d.findElement(By.id("com.vivo.calculator:id/digit1")).click();
	 * System.out.println("1");
	 * d.findElement(By.id("com.vivo.calculator:id/digit8")).click();
	 * System.out.println("2");
	 * d.findElement(By.id("com.vivo.calculator:id/plus")).click();
	 * System.out.println("3");
	 * d.findElement(By.id("com.vivo.calculator:id/digit2")).click();
	 * System.out.println("4");
	 * d.findElement(By.id("com.vivo.calculator:id/equal")).click();
	 * System.out.println("5"); Thread.sleep(200);
	 */

	@Test(enabled=true)
	public void Login() throws InterruptedException, IOException
	{
		d.findElement(By.xpath(TermsCondition)).click();
		System.out.println("Click On Terms & Condition Link");

		//Thread.sleep(200);
		d.navigate().back();
		System.out.println("User Navigate on Terms & condition Screen");

		d.findElement(By.xpath(ACCEPT)).click();
		System.out.println("Click On ACCEPT button");

		d.navigate().back();
		System.out.println("User Navigate on Terms & condition Screen");
		
		d.findElement(By.xpath(ACCEPT)).click();
		
		d.findElement(By.xpath(LoginSubmit)).click();
		System.out.println("Click on Submit button");
		
		d.findElement(By.xpath(LoginMobileNumber)).sendKeys("9892978931");
		System.out.println("Enter Mobile Number");
		
		d.findElement(By.xpath(LoginSubmit)).click();
		System.out.println("Click on Submit button");
		Thread.sleep(3000);
		TakesScreenshot scrShot =((TakesScreenshot)d);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("E://FIN_MobiConnect//screenshots//file1.png");
		FileUtils.copyFile(SrcFile, DestFile);
	
		d.navigate().back();
		System.out.println("STOP");
		
	
	}
	
	
	
	/*if(logouturl ==null)
		{

			d.findElement(By.xpath(SubmitMobile)).click();
			d.findElement(By.xpath(Mobile)).sendKeys("9701269353 ");
			Thread.sleep(2000);
		}
		else
		{
			System.out.println("Logout Successfully");
		}

	}	
	 */
	@AfterSuite								
	public void uninstallApp() throws InterruptedException 
	{
		//  d.resetApp();
		d.closeApp();
		//  d.removeApp("com.rde.positivepay");
		System.out.println("App Close successfully");		
	}
}


