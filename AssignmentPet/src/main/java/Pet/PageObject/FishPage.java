package Pet.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FishPage extends BasePage{
   

	public FishPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		//this.driver = driver;
		// PageFactory.initElements(driver, this);
	}



    @FindBy(css = "a[href*='FI-FW-02']")
     WebElement GoldfishLink;
    
    @FindBy(css = "#Content h2")
    WebElement header;

   

  //Get page header
 public String getPageHeader() {
      
       return header.getText();
   }

    //Click on Goldfish link
    public GoldFishPage clickOnGoldfishLink(String product){
    	
    	System.out.println("Before GoldFish");
    	WebDriverWait wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(3));
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='FI-FW-02']")));
        GoldfishLink.click();
        System.out.println("After GoldFish");
      
        GoldFishPage goldFishPage= new GoldFishPage(driver);
        return goldFishPage;
    }
}

   