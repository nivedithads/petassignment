package Pet.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "a[href='/actions/Order.action?newOrderForm=']")
     WebElement checkout;  //click


	@FindBy(css = "input[name='newOrder']")
     WebElement con;  //click
	
	
	
	
	@FindBy(css = "tbody tr td:nth-child(3)")
    WebElement name;  //getText
	
	 public String getname() {
	        
	         return name.getText();
	     }
	
    
	
	 public  ConfirmOrderPage addTocheckout(){
	    	
	    	
	    	checkout.click();
	    	con.click();
	    	
	        System.out.println("After checkout");
	    return new ConfirmOrderPage(driver);
	    }
	 
}
