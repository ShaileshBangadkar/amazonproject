package stepDefs;

import baseClass.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pageObjects.*;

public class amazonStepDefs extends BaseClass {

  amazonPage page = new amazonPage();
  loginPage login = new loginPage();
  @When("I search product {string}")
  public void i_search_product(String product) throws InterruptedException {
    page.enterProduct(product);
//  Thread.sleep(5000);

  }

  @Then("I verify that product is displayed successfully")
  public void i_verify_that_product_is_displayed_successfully() {
page.verifyProductDisplayed();
  }


  @And("I click on search button")
  public void iClickOnSearchButton() {
    page.clickOnSearchButton();
  }


  @Then("I verify that product price is as per filtered price")
  public void iVerifyThatProductPriceIsAsPerFiltered() {
    page.verifyFilteredPrice();
  }

  @When("I entered min price {string}")
  public void iEnteredMinPrice(String low) {
    page.enterMinPrice(low);
  }

  @And("I entered max price {string}")
  public void iEnteredMaxPrice(String high) {
    page.enterMaxPrice(high);
  }

  @And("I select product size {string}")
  public void iSelectProductSize(String size) throws InterruptedException {
    page.selectSizeOfProduct(size);
  }

  @When("I click on price of the product")
  public void iClickOnPriceOfTheProduct() {
    page.priceOfProduct();
  }

  @Then("I added product to shopping cart")
  public void iAddedProductToShoppingCart() throws InterruptedException {
    Thread.sleep(5000);
    page.addToCart();
  }

    @Then("click on go")
    public void clickOnGo() throws InterruptedException {
   page.clickOnGo();
   Thread.sleep(5000);
    }

  @Then("I verified that the correct product and options are displayed")
  public void iVerifiedThatTheCorrectProductAndOptionsAreDisplayed() {
    page.VerifiedThatTheCorrectProductAndOptionsAreDisplayed();
  }

  @Then("I click on go to cart button to proceed for checkout")
  public void iClickOnGoToCartButtonToProceedForCheckout() throws InterruptedException {
    page.clickOnGoToCart();
  }

  @When("I click on Proceed to buy")
  public void iClickOnProceedToBuy() {
    login.clickOnProceed();
  }

  @Then("I click on continue button")
  public void iClickOnContinueButton() {
    login.clickOnContinue();
  }

  @Then("I click on sign in button")
  public void iClickOnSignInButton() {
    login.clickOnSignIn();
  }

  @And("I enter mobile no {string}")
  public void iEnterMobileNo(String MOB) {
    login.enterMobileNo(MOB);
  }

  @And("I enter password {string}")
  public void iEnterPassword(String PASS) {
    login.enterPassword(PASS);
  }

  @Then("I select address")
  public void iSelectAddress() {
    login.useThisAddress();
  }

  @Then("I verify Order Summary")
  public void iVerifyOrderSummary() {
    page.verifySummary();
  }

  @Then("I verify that right products are Displayed on webpage")
  public void iVerifyThatRightProductsAreDisplayedOnWebpage() {
    page.verifySameProductIsOnPage();
  }
}