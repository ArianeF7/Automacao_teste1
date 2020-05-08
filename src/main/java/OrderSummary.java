import org.openqa.selenium.By;

public class OrderSummary extends BaseTest {

    private By btnConfirmarCompra = By.xpath("//*[@id=\"cart_navigation\"]/button");

    public void confirmarCompra(){
        getDriver().findElement(btnConfirmarCompra).submit();
    }
}
