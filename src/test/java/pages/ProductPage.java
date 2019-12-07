package pages;

import org.openqa.selenium.By;
import pages.basePage.BasePage;

public class ProductPage extends BasePage {

    private By addToCartButton = By.cssSelector("#add_product_to_shopping_cart_button_top");
    private By openCartButton = By.cssSelector(".button.btn-cart.product-is-in-cart");
    private By productName = By.cssSelector(".product-main-info > h1");
    private By productPrice = By.cssSelector(".price-v2");

    public void addToCart() {
        String itemName = web().findElement(productName).getText();
        String itemPrice = web().findElement(productPrice).getAttribute("data-sell-price-w-vat");
        order.setPrice(itemPrice);
        order.setName(itemName);
        waitClick(addToCartButton);
        web().findElement(addToCartButton).click();
    }

    public void openCart() {
        waitClick(openCartButton);
        web().findElement(openCartButton).click();
    }
}
