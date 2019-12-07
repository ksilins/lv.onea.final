package pages;

import org.openqa.selenium.By;
import pages.basePage.BasePage;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfirmationPage extends BasePage {

    private By itemName = By.cssSelector(".ait-cart-item-info a");
    private By itemPrice = By.cssSelector(".ait-cart-total >div:first-child > span:last-child");
    private By deliveryFee = By.cssSelector(".ait-cart-total >div:nth-child(2) > span:last-child");
    private By clientData = By.cssSelector(".col-1 > p");

    public float getFinalPrice() {
        String priceString = web().findElement(itemPrice).getText().replaceAll("[^\\d.]", "");
        String deliveryString = web().findElement(deliveryFee).getText().replaceAll("[^\\d.]", "");
        float price = Float.parseFloat(priceString);
        float delivery = Float.parseFloat(deliveryString);
        return price + delivery;
    }

    public void validateOrder() {
        String name = web().findElement(itemName).getText();
        float price = Float.parseFloat(order.getPrice());
        String clientInfo = web().findElement(clientData).getText();
        String[] clientSplit = clientInfo.split("\\n|\\s+");

        assertThat(order.getName()).isEqualToIgnoringCase(name);
        assertThat(price).isEqualTo(getFinalPrice());
        assertThat(clientSplit).contains(
                customer.getName(),
                customer.getSurname(),
                customer.getEmail(),
                customer.getPhoneNumber()
        );
    }
}
