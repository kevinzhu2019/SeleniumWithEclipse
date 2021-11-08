package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	WebDriver driver;
	@FindBy(xpath = "//li[@class='sign-in-link hide-xs hide-sm']/a[@title='Sign In']")
	WebElement signInButton;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void toSignInPage() {
		signInButton.click();
	}
}
