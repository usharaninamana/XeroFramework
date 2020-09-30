package Com.Xero.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="xl-form-email")
	private WebElement email; 
	
	@FindBy(id="xl-form-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@id='xl-form-submit']")
	private WebElement Login; 
	
	public void sendUserName(String userName) {
		this.email.clear();
		this.email.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.Login.click(); 

}
}