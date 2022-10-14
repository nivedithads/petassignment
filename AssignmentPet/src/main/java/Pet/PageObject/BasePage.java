package Pet.PageObject;

import java.time.Clock;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Sleeper;

import io.cucumber.messages.types.Duration;

public abstract class BasePage {
	 WebDriver driver;
	
	  public BasePage(WebDriver driver)
		{
			
			//initialization
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
}