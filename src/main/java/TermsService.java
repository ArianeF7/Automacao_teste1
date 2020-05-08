import org.openqa.selenium.By;

public class TermsService extends BaseTest{

    private By aceitarTermos = By.id("cgv");
    private  By btnProseguirCheckout = By.name("processCarrier");

    public void aceiteTermos(){
        getDriver().findElement(aceitarTermos).click();
        getDriver().findElement(btnProseguirCheckout).click();
    }
}
