package Pet.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ConfirmOrderPage extends BasePage{

	public ConfirmOrderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(css = "a[href='/actions/Order.action?newOrder=&confirmed=true']")
     WebElement confirm;  //click



	
	
	
	
	@FindBy(css = "ul[class='messages'] li")
    private WebElement message;  //getText
	
	 public String getMessage() {
	        
	         return message.getText();
	     }
	
    
	
	 public void confirmOrder(){
	    	
	    	System.out.println("Before ");
	    	confirm.click();
	    	
	        System.out.println("After");
	      	    }
	 
	
	
	
	 


}

