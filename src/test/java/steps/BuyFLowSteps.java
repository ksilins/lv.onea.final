package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

public class BuyFLowSteps {

    private MainPage mainPage = new MainPage();
    private ResultPage resultPage = new ResultPage();
    private ProductPage productPage = new ProductPage();
    private ShoppingCart shoppingCart = new ShoppingCart();
    private LoginPage loginPage = new LoginPage();
    private OrderPage orderPage = new OrderPage();
    private PaymentPage paymentPage = new PaymentPage();
    private ConfirmationPage confirmationPage = new ConfirmationPage();

    @Given("I open 1a.lv site")
    public void iOpenOneaLvSite() {
        mainPage.closeAds();
        mainPage.setAcceptCookies();
    }

    @And("^I search for: (.*)$")
    public void iSearchForProduct(String product) {
        mainPage.searchProduct(product);
    }

    @And("^choose Sony product with most stars")
    public void chooseBrandProductWithFilterType() {
        resultPage.selectBrand();
        resultPage.selectFilter();
    }

    @And("^open item number (\\d+)$")
    public void openItemNumber(int itemPosition) {
        resultPage.selectProduct(itemPosition);
    }

    @When("^I add item and go to cart$")
    public void iAddItemAndGoToCart() {
        productPage.addToCart();
        productPage.openCart();
    }

    @And("^proceed to check out unregistered$")
    public void proceedToCheckOutUnregistered() {
        shoppingCart.proceedToCheckout();
        loginPage.proceedUnreg();
    }

    @And("^choose to get item in office$")
    public void chooseToGetItemInLocation() {
        orderPage.customerSetup();
        orderPage.fillForm();
        orderPage.getInOffice();
        orderPage.proceedToNextScreen();
    }

    @And("^choose to pay with cash$")
    public void chooseToPayWithPaymentType() {
        paymentPage.selectCash();
        paymentPage.proceedToNextScreen();
    }

    @Then("^order data is correct$")
    public void orderDataIsCorrect() {
        confirmationPage.validateOrder();
    }
}
