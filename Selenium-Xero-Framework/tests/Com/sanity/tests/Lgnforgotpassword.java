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

public class Lgnforgotpassword {
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
	public void validForgotpwdTest() throws InterruptedException {
		
		WebElement Login=driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		Login.click();
		driver.findElement(By.xpath("//a[contains(text(),'Forgot password?')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("ushanamana@gmail.com");
		driver.findElement(By.xpath("//button[contains(text(),'Send link')]")).click();
		Thread.sleep(2000);
		String message = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/h1")).getText();
		Thread.sleep(2000);
		System.out.println("password reset initated ");


}

}