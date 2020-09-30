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
import Com.Xero.pom.TrailPOM;
import Com.utility.DriverFatory;
import Com.utility.DriverNames;

public class Trail2a {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private TrailPOM trailPOM;
	private static Properties properties;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("C:\\Ushaproject\\selenium-workspace\\Selenium-Xero-Framework\\resoures\\others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFatory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		trailPOM=new TrailPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		// open the browser 
		driver.get(baseUrl);
	}
	

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validTrailTest() throws InterruptedException {
	
	driver.findElement(By.linkText("Free trial")).click();
	trailPOM.sendUserName("usha");
	trailPOM.sendPassword("rani");
	trailPOM.sendEmailAddress("ushanamana@gmail.com");
	trailPOM.sendAddress("Hyderbad");
	trailPOM.selectcountry("Spain");
	trailPOM.clickCheck();
	driver.findElement(By.xpath("//body/div/main/div/div/div/form[@name='signupForm']/div/span[1]")).click();
	

}
}
