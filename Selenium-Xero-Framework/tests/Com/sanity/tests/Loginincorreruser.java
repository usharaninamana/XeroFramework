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

public class Loginincorreruser {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("C:\\Ushaproject\\selenium-workspace\\Selenium-Xero-Framework\\resoures\\others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFatory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver); 
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
	public void validLoginorretuserTest() throws InterruptedException {
		
		WebElement Login=driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		Login.click();
		loginPOM.sendUserName("ushan@gmail.com");
		loginPOM.sendPassword("Usha@1985");
		loginPOM.clickLoginBtn();
		String errormessage = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/form/div[1]/ul/li")).getText();
		System.out.println("Your email or password is incorrect");
		
	}
		}

		


