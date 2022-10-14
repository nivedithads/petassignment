package Pet.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pet.PageObject.AddtoCartPage;
import Pet.PageObject.CheckoutPage;
import Pet.PageObject.ConfirmOrderPage;
import Pet.PageObject.FishPage;
import Pet.PageObject.GoldFishPage;
import Pet.PageObject.LandingPage;
import Pet.PageObject.MainPage;

public class LandingPageTest extends BaseTest {

	public LandingPage landingPage;
	public FishPage fishPage;
	public MainPage mainPage;
	public GoldFishPage goldfishPage;
	public AddtoCartPage addtoCartPage;
	public CheckoutPage checkoutPage;
	public ConfirmOrderPage confirmOrderPage;

	@Test

	public void loginToPetStore() throws InterruptedException {
		landingPage = navigateToPage("https://petstore.octoperf.com/actions/Catalog.action");
		landingPage.login("Niveditha", "Daseena");
		mainPage = landingPage.afterLoginToStore();
		Assert.assertTrue(mainPage.isStoreLogoDisplayed());

	}

	@Test(dependsOnMethods = "loginToPetStore")

	// Enters the Fish page by clicking the sidebar link
	public void clicksFishOnSidebar() throws InterruptedException {

		// MainPage mainPage = new MainPage(driver);

		// AnimalPage animalPage = mainPage.clickOnSidebarFishLink();

		// Assert.assertTrue(animalPage.getPageHeader().contains("Fish"));
		fishPage = mainPage.clickOnSidebarFishLink("fish");

		Assert.assertTrue(fishPage.getPageHeader().contains("Fish"));
	}

	@Test(dependsOnMethods = "clicksFishOnSidebar")

	// Enter the Goldfish page by clicking the link

	public void clickGoldfishLink() {

		goldfishPage = fishPage.clickOnGoldfishLink("Goldfish");

		Assert.assertTrue(goldfishPage.getTableHeader().contains("Goldfish"));
		addtoCartPage = goldfishPage.nextPage();
	}

	@Test(dependsOnMethods = "clickGoldfishLink")
	public void addToCart() {

		addtoCartPage.addToCart("Adult Female Goldfish");
		Assert.assertTrue(addtoCartPage.getname().contains("Goldfish"));

	}

	@Test(dependsOnMethods = "addToCart")
	public void proceedToCheckOut() {

		// CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage = addtoCartPage.toNext();
		Assert.assertTrue(checkoutPage.getname().contains("Goldfish"));
		// checkoutPage.addTocheckout();
		confirmOrderPage = checkoutPage.addTocheckout();
	}

	@Test(dependsOnMethods = "proceedToCheckOut")

	public void userConfirmOrder() {

		confirmOrderPage.confirmOrder();
		Assert.assertTrue(confirmOrderPage.getMessage().contains("Thank you, your order has been submitted."));

		driver.close();

	}

}
