package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

	WebDriver driver;
	@FindBy(xpath = "//input[@placeholder='Full name']")
	WebElement fullName;
	@FindBy(xpath = "//input[@placeholder='Business Email' and @id='user_email_login']")
	WebElement email;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;
	@FindBy(xpath = "//form[@id='signin_signup_form']//input[@name='terms_and_conditions']")
	WebElement checkBox;
	@FindBy(xpath = "//form[@name='signin_signup_form']//input[@type='submit']")
	WebElement submitButton;
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createNewUser(String name, String mail, String passwd) throws InterruptedException {
		driver.get("https://www.browserstack.com/users/sign_up");
		fullName.sendKeys(name);
		email.sendKeys(mail);
		password.sendKeys(passwd);
//		checkBox.click();
//		submitButton.sendKeys("\n");
		Thread.sleep(3000);
	}
}
