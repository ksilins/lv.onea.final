package pages;

import org.openqa.selenium.By;
import pages.basePage.BasePage;

public class PaymentPage extends BasePage {

    private By cashOption = By.cssSelector("a[payment_type='CASH_INDIVIDUAL_PERSON']");
    private By proceedButton = By.cssSelector(".ait-checkout-footer > a:last-child");

    public void selectCash() {
        waitUntil(cashOption);
        web().findElement(cashOption).click();
    }

    public void proceedToNextScreen() {
        web().findElement(proceedButton).click();
    }
}
