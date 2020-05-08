import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;

public class ConfirmOrder extends BaseTest {

    private By ConfirmaCompra = By.className("page-heading");

    public void confirmarCompra(){

        String validaCompra = getWait().until(ExpectedConditions.presenceOfElementLocated(ConfirmaCompra)).getText();
        assertEquals("ORDER CONFIRMATION", validaCompra);
    }
}
