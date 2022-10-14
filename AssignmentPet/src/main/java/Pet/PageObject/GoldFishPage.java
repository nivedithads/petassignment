package Pet.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoldFishPage extends BasePage{

	

	public GoldFishPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "div[id='Catalog'] h2")
     WebElement goldfishHeader;
	
	
	public String getTableHeader() {
		// TODO Auto-generated method stub
		
		return goldfishHeader.getText();
		//AddtoCartPage addtoCartPage= new AddtoCartPage(driver);
		 
	}

	public AddtoCartPage nextPage() {
		
		
		
		AddtoCartPage addtoCartPage= new AddtoCartPage(driver);
		return addtoCartPage;
	}
}

