import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;

public class Order extends BaseTest {

    private By confereProduto = By.cssSelector("#order-detail-content .product-name a");
    private By ValTotal = By.id("total_price");
    private By seguirCheckout = By.className("standard-checkout");



    public void checkout(String produto) {
        String confProd = getWait().until(ExpectedConditions.presenceOfElementLocated(confereProduto)).getText().toLowerCase();
        assertEquals(produto,confProd);

        String valTotal = getDriver().findElement(ValTotal).getText();

        getDriver().findElement(seguirCheckout).click();
    }
}

