package pages;

import org.openqa.selenium.By;
import pages.basePage.BasePage;

public class OrderPage extends BasePage {

    private By paymentForm = By.cssSelector(".payment-form");
    private By nameField = By.cssSelector("#order_main_data_name");
    private By surnameField = By.cssSelector("#order_main_data_surname");
    private By emailField = By.cssSelector("#order_main_data_email");
    private By phoneField = By.cssSelector("#order_main_data_contact_phone_number");
    private By spamOptionSelect = By.cssSelector(".select-method .ui-combobox > a");
    private By noSpamOption = By.cssSelector("li:last-child>a[id^='ui-id-']");
    private By acceptAgreement = By.cssSelector("#accept_purchase_agreement");
    private By predefinedAddress = By.cssSelector(".form-cols.predefined-delivery-address-container");
    private By mukusalasOffice = By.cssSelector("article[data-delivery-type-id='18']");
    private By proceedButton = By.cssSelector(".ait-checkout-footer > a:last-child");

    public void customerSetup() {
        customer.setName("Janis");
        customer.setSurname("Petersons");
        customer.setEmail("janis.petersons@maail.de");
        customer.setPhoneNumber("+37154453322");
    }

    public void fillForm() {
        waitUntil(paymentForm);
        web().findElement(nameField).sendKeys(customer.getName());
        web().findElement(surnameField).sendKeys(customer.getSurname());
        web().findElement(emailField).sendKeys(customer.getEmail());
        web().findElement(phoneField).sendKeys(customer.getPhoneNumber());
        web().findElement(spamOptionSelect).click();
        web().findElement(noSpamOption).click();
        web().findElement(acceptAgreement).click();
    }

    public void getInOffice() {
        waitClick(mukusalasOffice);;
        web().findElement(mukusalasOffice).click();
        waitUntil(predefinedAddress);
    }

    public void proceedToNextScreen() {
        web().findElement(proceedButton).click();
    }
}
