package Pet.PageObject;

import java.time.Clock;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.messages.types.Duration;



public class MainPage extends BasePage {
	
    //private static final Duration Duration = null;
	public MainPage(WebDriver driver) {
		
		// TODO Auto-generated constructor stub
		  
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}





    @FindBy(css = "#Sidebar a img[src*='fish']")
     WebElement sidebarFishLink;

    
    @FindBy(css = "a img[src*='logo']")
    WebElement storeLogo;

   
  // Getting is store logo is displayed
   public boolean isStoreLogoDisplayed() {
     
   	 System.out.println("Store logo is displayed: "+storeLogo.isDisplayed());
       return storeLogo.isDisplayed();
      
   }
//  Click on sidebar fish link
    public FishPage clickOnSidebarFishLink(String fish){
    	 System.out.println("before Clicking on sidebar fish link");
     	WebDriverWait wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(3));
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#Sidebar a img[src*='fish']")));
 		sidebarFishLink.click();
 	     System.out.println("Clicked on sidebar fish link");
 	       
        return new FishPage(driver);
    }
}

