package pages;

import org.openqa.selenium.By;
import pages.basePage.BasePage;

public class MainPage extends BasePage {

    private By searchField = By.cssSelector("#search_products_text_field");
    private By searchButton = By.cssSelector("input[value='search']");
    private By autocompleteWidget = By.cssSelector("#ui-id-1");

    public void searchProduct(String product) {
        web().findElement(searchField).sendKeys(product);
        waitUntil(autocompleteWidget);
        web().findElement(searchButton).click();
    }
}
