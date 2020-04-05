package pages.basePage;

import models.Customer;
import models.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

public class BasePage {

    public static Customer customer = new Customer();
    public static Order order = new Order();

    private By modalFrame = By.cssSelector(".mt-overlay iframe");
    private By modalClose = By.cssSelector(".close-button.animated");
    private By barFrame = By.cssSelector(".mt-promo-bar iframe");
    private By promoBarClose = By.cssSelector(".close-button-slider.desktop");
    private By acceptCookies = By.cssSelector("#cookie-btns .c-button-inverse");

    public static WebDriver web() {
        return Driver.instance.webDriver;
    }

    public void waitUntil(By element) {
        WebDriverWait wait = new WebDriverWait(web(), 4);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitClick(By element) {
        WebDriverWait wait = new WebDriverWait(web(), 4);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitGone(By element) {
        WebDriverWait wait = new WebDriverWait(web(), 4);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public void closeAds() {
        try {
            waitUntil(modalFrame);
            String modalId = web().findElement(modalFrame).getAttribute("id");
            web().switchTo().frame(modalId);
            waitClick(modalClose);
            web().findElement(modalClose).click();
        } catch (Exception ignored) {
        }

        web().switchTo().parentFrame();

        try {
            waitUntil(barFrame);
            String frameId = web().findElement(barFrame).getAttribute("id");
            web().switchTo().frame(frameId);
            waitClick(promoBarClose);
            web().findElement(promoBarClose).click();
        } catch (Exception ignored) {
        }
        web().switchTo().parentFrame();
    }

    public void setAcceptCookies() {
        waitClick(acceptCookies);
        web().findElement(acceptCookies).click();
    }
}
