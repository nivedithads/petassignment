package JPetstore.stepDefinitions;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import Pet.PageObject.AddtoCartPage;
import Pet.PageObject.CheckoutPage;
import Pet.PageObject.ConfirmOrderPage;
import Pet.PageObject.FishPage;
import Pet.PageObject.GoldFishPage;
import Pet.PageObject.LandingPage;
import Pet.PageObject.MainPage;
import Pet.tests.BaseTest;
import Pet.tests.LandingPageTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinitionImpl extends BaseTest {
	//WebDriver driver;
	public LandingPage landingPage;
	public FishPage fishPage;
	public MainPage mainPage;
	public GoldFishPage goldfishPage;
	public AddtoCartPage addtoCartPage;
	public CheckoutPage checkoutPage;
	public ConfirmOrderPage confirmOrderPage;
	@Given("^I landed on JPetStore Website$")
	public void i_landed_on_JPetStore_Website() 
	{
		 initial();
	landingPage=navigateToPage("https://petstore.octoperf.com/actions/Catalog.action");
	}
	
	
	@Given("^Login with Username (.+) and Password (.+)$")
	public void login_with_username_and_Password_niveditha(String username, String password)
	{
		landingPage.login(username,password);
		//landingPage.afterLoginToStore();
		mainPage=landingPage.afterLoginToStore();
		Assert.assertTrue(mainPage.isStoreLogoDisplayed());
	}
	
	
	@When("^Select a Category (.+)$")
	public void select_a_category(String category)
	{//MainPage mainPage = new MainPage(driver);
	fishPage=mainPage.clickOnSidebarFishLink(category);
	//FishPage fishPage = new FishPage();

	Assert.assertTrue(fishPage.getPageHeader().contains("Fish"));
	}
	
	@When("^Select a Product (.+)$")
	public void select_a_product(String product)
	{
		goldfishPage=fishPage.clickOnGoldfishLink(product);
		Assert.assertTrue(goldfishPage.getTableHeader().contains("Goldfish"));
		
		
	}
	
	
	@When("^I add an Item (.+) to Cart$")
	public void i_add_an_item_to_Cart_by_selecting_category_and_product(String item)
	{	addtoCartPage=goldfishPage.nextPage();
	//AddtoCartPage addtoCartPage= new AddtoCartPage(driver);
	addtoCartPage.addToCart(item);
	Assert.assertTrue(addtoCartPage.getname().contains("Goldfish"));
	//checkoutPage=addtoCartPage.toNext();
	}
	
	@When("^Checkout and confirm the order$")
	public void checkout_and_confirm_the_order()
	{checkoutPage=addtoCartPage.toNext();

	Assert.assertTrue(checkoutPage.getname().contains("Goldfish"));
	confirmOrderPage=checkoutPage.addTocheckout();
	}
	
	  @Then("{string} message is displayed on ConfirmationPage")
	    public void message_is_displayed_on_confirmationPage(String string)
	    {confirmOrderPage.confirmOrder();
		Assert.assertTrue(confirmOrderPage.getMessage().contains("Thank you, your order has been submitted."));
		
		 driver.close();

	    }
	}

