package Com.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.Xero.pom.LoginPOM;
import Com.utility.DriverFatory;
import Com.utility.DriverNames;

public class TestTabs {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("C:\\Ushaproject\\selenium-workspace\\Xero-maven\\resoures\\others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFatory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		// open the browser 
		driver.get(baseUrl);
	}
	
	
	@Test
	public void validTestTabsTest() throws InterruptedException {
		
		WebElement Login=driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		Login.click();
		loginPOM.sendUserName("ushanamana@gmail.com");
		loginPOM.sendPassword("Usha@1985");
		loginPOM.clickLoginBtn();

}
	@Test
	public void DashboardTest() throws InterruptedException {
		WebElement Dash=driver.findElement(By.xpath("//*[@id=\"header\"]/header/div/ol[1]/li[1]/a"));
		Dash.click();
				

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
}