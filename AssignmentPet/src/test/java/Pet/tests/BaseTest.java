package Pet.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeSuite;

import Pet.PageObject.LandingPage;

public class BaseTest {
	
	public WebDriver driver;

	
	@BeforeSuite
	public void initial() {

		System.setProperty("webdriver.edge.driver", "C:\\Users\\183599\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		//this.driver = new EdgeDriver();
		 driver = new EdgeDriver();
		 
		driver.manage().window().maximize();
		
		
	}

	
	public LandingPage navigateToPage(String pageUrl) {

		driver.navigate().to(pageUrl);
		LandingPage landingPage= new LandingPage(driver);
		return landingPage;
	}

	

}
