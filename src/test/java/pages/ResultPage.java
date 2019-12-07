package pages;

import org.openqa.selenium.By;
import pages.basePage.BasePage;

public class ResultPage extends BasePage {

    private By loader = By.cssSelector(".blockUI.blockOverlay");
    private By manufacturer = By.cssSelector("div[data-attribute-id='2627']");
    private By selectSony = By.cssSelector("label[for='s23765']");
    private By filterSelect = By.cssSelector("div.select-sort-products a.select-add-info");
    private By startSelect = By.cssSelector(".drop-list li[rel='4']");

    public void selectBrand() {
        closeAds();
        waitUntil(manufacturer);
        web().findElement(manufacturer).click();
        waitClick(selectSony);
        web().findElement(selectSony).click();
        waitGone(loader);
    }

    public void selectFilter() {
        waitClick(filterSelect);
        web().findElement(filterSelect).click();
        waitClick(startSelect);
        web().findElement(startSelect).click();
        waitGone(loader);
    }

    public void selectProduct(int itemPosition) {
        web().findElement(By.cssSelector(".product-grid > section:nth-child(" + itemPosition + ") .p-image")).click();
        closeAds();
    }
}
