package Pet.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddtoCartPage extends BasePage{

	public AddtoCartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		 PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "a[href='/actions/Catalog.action?viewItem=&itemId=EST-21']")
     WebElement est_21;  //click


	@FindBy(xpath = "//td[contains(text(),'Adult Female')]")
     WebElement fishname;  //getText
	//font[size='4']
	
	//@FindBy(css = "font[size='4']")
    //WebElement na;  //click


	@FindBy(css = "a.Button")
    WebElement add;  //click
    //Click on Goldfish link
    public void addToCart(String item){
    	// 
    	System.out.println("Before cart");
    	est_21.click();
        WebDriverWait wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(3));
 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='FI-FW-02']")));
        add.click();
        System.out.println("After cart");
       
       
    }
  public String getname() {
       
         return fishname.getText();
	  
     }
	
  public CheckoutPage toNext() {
      
	  CheckoutPage checkoutPage= new CheckoutPage(driver);
      return checkoutPage;
	  
  }
}
