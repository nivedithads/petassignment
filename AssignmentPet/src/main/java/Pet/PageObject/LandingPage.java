package Pet.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Sign In")
	WebElement signin;

	@FindBy(name = "username")
	WebElement uname;

	@FindBy(name = "password")
	WebElement pw;

	@FindBy(name = "signon")
	WebElement signon;

	

	public void login(String uName, String pWord) {

		signin.click();
		
		uname.clear();
		pw.clear();

		uname.sendKeys(uName);
		pw.sendKeys(pWord);

		signon.click();

	}

	public MainPage afterLoginToStore() {

		System.out.println("Successfully Logged in to the JPetStore Website");

		return new MainPage(driver);

	}
}