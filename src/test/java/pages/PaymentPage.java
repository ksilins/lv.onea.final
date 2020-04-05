package pages;

import org.openqa.selenium.By;
import pages.basePage.BasePage;

public class PaymentPage extends BasePage {

    private By cashOption = By.cssSelector("a[payment_type='CASH_INDIVIDUAL_PERSON']");
    private By transferOption = By.cssSelector("a[payment_type='TRANSFER_INDIVIDUAL_PERSON']");
    private By proceedButton = By.cssSelector(".ait-checkout-footer > a:last-child");
    private By contactOptionSelect = By.cssSelector("#transfer_individual_person .ui-combobox a");
    private By contactViaMail = By.cssSelector("li:last-child>a[id^='ui-id-']");

    public void selectCash() {
        waitUntil(cashOption);
        web().findElement(cashOption).click();
    }

    public void selectTransfer() {
        waitUntil(transferOption);
        web().findElement(transferOption).click();
        waitUntil(contactOptionSelect);
        web().findElement(contactOptionSelect).click();
        waitUntil(contactViaMail);
        web().findElement(contactViaMail).click();
    }

    public void proceedToNextScreen() {
        web().findElement(proceedButton).click();
    }
}
