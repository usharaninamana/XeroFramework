package Com.Xero.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TrailPOM {
private WebDriver driver; 
	
	public TrailPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='FirstName']")
	private WebElement FirstName; 
	
	@FindBy(xpath="//input[@name='LastName']")
	private WebElement LastName;
	
	@FindBy(xpath="//input[@name='EmailAddress']")
	private WebElement EmailAddress;
	
	@FindBy(xpath="//input[@name='PhoneNumber']")
	private WebElement PhoneNumber; 
	
	@FindBy(xpath="//select[@name='LocationCode']")
	private WebElement LocationCode;
	
	@FindBy(xpath="//input[@name='TermsAccepted']")
	private WebElement TermsAccepted;
	
public void selectcountry(String Spain) {
		
Select country = new Select(LocationCode);
country.selectByVisibleText(Spain);
	}
	public void sendUserName(String FirstName) {
		this.FirstName.clear();
		this.FirstName.sendKeys(FirstName);
	}
	
	public void sendPassword(String LastName) {
		this.LastName.clear(); 
		this.LastName.sendKeys(LastName); 
	}
	public void sendEmailAddress(String EmailAddress) {
		this.EmailAddress.clear(); 
		this.EmailAddress.sendKeys(EmailAddress); 
	}
	public void sendAddress(String PhoneNumber) {
		this.PhoneNumber.clear(); 
		this.PhoneNumber.sendKeys(PhoneNumber); 
	}
	public void clickCheck() {
		this.TermsAccepted.click();
	}

	
}
