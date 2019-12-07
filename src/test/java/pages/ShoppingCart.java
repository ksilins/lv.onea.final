package pages;

import org.openqa.selenium.By;
import pages.basePage.BasePage;

public class ShoppingCart extends BasePage {

    private By orderProceed = By.cssSelector("a[href='/order/login']");

    public void proceedToCheckout() {
        waitClick(orderProceed);
        web().findElement(orderProceed).click();
    }
}
