import org.openqa.selenium.By;

public class PaymentMethod extends BaseTest{

    private By btnPgto = By.className("bankwire");

    public void tipoPagto(String valTotal){
//        String validaTotal = driver.findElement(By.id("total_price")).getText();
//        assertEquals(valTotal, validaTotal);

        getDriver().findElement(btnPgto).click();
    }
}
