package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	WebDriver driver;
	@FindBy(xpath = "//form[@id='signin_signup_form']//a[text()='Sign up']")
	WebElement signUp;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void toSignUpPage() {
		signUp.click();
	}
}
