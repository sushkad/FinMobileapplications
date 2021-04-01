
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.Select;

public class MSB extends Finacus_MaladBankPOM  
{

  //private static final WebElement MPIN = null;
	public static URL url;
	public static DesiredCapabilities capabilities;
	public static AndroidDriver<MobileElement> d;

	// 9420320879
	
	@BeforeSuite
	public void setupAppium() throws MalformedURLException, InterruptedException 
	{
		final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
		url = new URL(URL_STRING);

		capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "moto x4");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		//capabilities.setCapability(MobileCapabilityType.APP, "E:\\QA\\cocobank_UAT.apk");
		capabilities.setCapability("APP_PACKAGE","com.finacus.ssblpps");
		capabilities.setCapability("APP_ACTIVITY","crc645eda2270212ad276.SplashActivity");

		d = new AndroidDriver<MobileElement>(url,capabilities);
		//d = new RemoteWebDriver<MobileElement>(url,capabilities);
				
		//d.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		System.out.println("Set Up Completed");
		Thread.sleep(2000);
	}

	@Test(priority=1)
	public void MobileNumber() throws InterruptedException, MalformedURLException 
	{

		//d.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		//d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<MobileElement> elements0 = d.findElements(By.className(PrivacyPolicy));
		Thread.sleep(100);
		System.out.println("Click On Privacy Policy link");

		d.navigate().back();
		
		System.out.println("User Navigate on Term & Condition screen");
		Thread.sleep(2000);

		List<MobileElement> elements1 = d.findElements(By.className(ACCEPT));
		System.out.println("Click On ACCEPT button");
		
		d.navigate().back();
		
		List<MobileElement> elements2 = d.findElements(By.className(DECLINE));
		System.out.println("Click On Decline button");
		
		/*
		 * String app = MSB; if(MSB ==null) { final String URL_STRING =
		 * "http://127.0.0.1:4723/wd/hub"; url = new URL(URL_STRING);
		 * 
		 * capabilities = new DesiredCapabilities();
		 * capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "moto x4");
		 * capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		 * capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		 * capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		 * capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		 * //capabilities.setCapability(MobileCapabilityType.APP,
		 * "E:\\QA\\cocobank_UAT.apk");
		 * capabilities.setCapability("APP_PACKAGE","com.finacus.msb");
		 * capabilities.setCapability("APP_ACTIVITY",
		 * "crc645eda2270212ad276.SplashActivity");
		 * 
		 * d = new AndroidDriver<MobileElement>(url,capabilities); }
		 */
		
		System.out.println("Open again");
		List<MobileElement> Accept = d.findElements(By.className(ACCEPT));
		System.out.println("Click On ACCEPT button");
		
		
		
	}

	@AfterSuite								
	public void uninstallApp() throws InterruptedException 
	{  
		d.closeApp();
		//d.removeApp("com.finacus.positivepay");
		System.out.println("App Close Successfully");	
	}				
}
