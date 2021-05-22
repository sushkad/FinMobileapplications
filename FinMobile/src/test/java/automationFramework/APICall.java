package automationFramework;

import static io.restassured.RestAssured.post;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class APICall {


	@Test(priority = 0)
	void Test01() throws InterruptedException
	{
		Response response = post("http://123.108.32.20:9070/ParaguayPublicWS/MService.svc/getModuleType");
		//Response response = post("https://www.myntra.com/checkout/cart");
		//Response response = post("http://103.78.168.227:5000/FinConnect.WhatsAppComm/FinConnectWa/WA?To=919820403049&from=9892978931&content_type=$ContentType&media_type=text&text=hi&latitude=$Latitude&longitude=$Longitude");

		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		//Assert.assertEquals(statusCode, 404);
		Thread.sleep(20000);
		
	}

	@Test(priority = 1)
	void Test02() throws InterruptedException
	{
		//Response response = post("http://123.108.32.20:9070/ParaguayPublicWS/MService.svc/getModuleType");
		
		Response response = post("http://123.108.32.20:9070/ParaguayPublicWS/MService.svc/getModuleTypeBasedCuid");
		
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 404);
		Thread.sleep(20000);
	}
}
