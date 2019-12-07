package pages;

import org.openqa.selenium.By;
import pages.basePage.BasePage;

public class LoginPage extends BasePage {

    private By goUnreg = By.cssSelector(".button.btn-v2");

    public void proceedUnreg() {
        waitClick(goUnreg);
        web().findElement(goUnreg).click();
    }
}
