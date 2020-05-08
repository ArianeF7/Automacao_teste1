import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Index extends BaseTest implements DefaultProperties {

    private By pesquisaProduto = By.id("search_query_top");

    private By btnCarrinho = By.className("ajax_add_to_cart_button");
    private By btnCheckOut = By.className("button-medium");

    public void acessarAplicação(){
        getDriver().get(URL_BASE);
    }

    public void buscaProduto(String produto){
        WebElement caixaBusca = getDriver().findElement(pesquisaProduto);
        caixaBusca.click();
        caixaBusca.sendKeys(produto);
        getDriver().findElement(By.name("submit_search")).click();
    }

    public void selecionarProduto(){
        getWait().until(ExpectedConditions.elementToBeClickable(btnCarrinho));
        getDriver().findElement(btnCarrinho).click();
        getWait().until(ExpectedConditions.elementToBeClickable(btnCheckOut));
        getDriver().findElement(btnCheckOut).click();
    }

}
