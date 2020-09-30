package Com.Externaldata;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import Com.excel.utility.Xls_Reader;

public class Login1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.firefox.driver", "C:\\Ushaproject\\selenium-workspace\\Selenium-Xero-Framework\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.xero.com/us/");
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Login2=driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		Login2.click();

      WebElement Username=driver.findElement(By.id("xl-form-email"));
      WebElement Pwd=driver.findElement(By.id("xl-form-password"));
      //driver.findElement(By.xpath("//button[@id='xl-form-submit']")).click();
     
		Xls_Reader reader=new Xls_Reader("C:\\Ushaproject\\selenium-workspace\\Selenium-Xero-Framework\\src\\testdata2\\data.xlsx");
		String SheetName="Login";
		int rowCount = reader.getRowCount(SheetName);
		for(int rowNum=2; rowNum<=rowCount; rowNum++) {
			String Login=reader.getCellData(SheetName, "Username", rowNum);
			String Password1=reader.getCellData(SheetName, "Password", rowNum);
			System.out.println(Login +"   " +Password1);
			Username.clear();
			Username.sendKeys(Login);
			 Pwd.clear();
			Pwd.sendKeys(Password1);
			reader.setCellData("Login", "Status", rowNum, "Pass");
			System.out.println("TC is passed! ");


			
		}
		
	}


	

}
