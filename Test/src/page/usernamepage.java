package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class usernamepage {
	
	@FindBy(id="identifierId")
	private WebElement username;
	@FindBy(xpath="//span[text()=\"Next\"]")
	private WebElement next;
	@FindBy(xpath="//input[@type=\"password\"]")
	private WebElement password;
	
	public usernamepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setusername(String un) {
		username.sendKeys(un);	}
	public void clicknext() {
		next.click();	}
	public void setpassword(String pw) {
		password.sendKeys(pw);	}
	
	



}
