import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Authentication extends BaseTest{

    private By novoEmail = By.id("email_create");
    private By btnCriarConta = By.id("SubmitCreate");

    private By genero = By.id("id_gender2");
    private By primeiroNome = By.id("customer_firstname");
    private By ultimoNome = By.id("customer_lastname");
    private By senha = By.id("passwd");
    private By dataNascDia = By.id("days");
    private By dataNascMes =  By.id("months");
    private By dataNascAno = By.id("years");

    private By logradouro = By.id("address1");
    private By complemento = By.id("address2");
    private By cidade = By.id("city");
    private By estado = By.id("id_state");
    private By cep = By.id("postcode");
    private By pais = By.id("id_country");
    private By celular = By.id("phone_mobile");
    private By enderecoSecundario = By.id("alias");
    private By btnRegistrarUsuario = By.id("submitAccount");

    public void cadastrarNovoUsuario (String email){
        getDriver().findElement(novoEmail).sendKeys(email);
        getDriver().findElement(btnCriarConta).click();
    }

    public void dadosCadastraisUsuario(){
        getWait().until(ExpectedConditions.elementToBeClickable(genero)).click();
        getDriver().findElement(primeiroNome).sendKeys("Ariane");
        getDriver().findElement(ultimoNome).sendKeys("Lima");
        getDriver().findElement(senha).sendKeys("teste");
        getDriver().findElement(dataNascDia).sendKeys("7");
        getDriver().findElement(dataNascMes).sendKeys("August");
        getDriver().findElement(dataNascAno).sendKeys("1995");
    }

    public void dadosEnderecoUsuario(){
        getDriver().findElement(logradouro).sendKeys("Alameda Rio Negro");
        getDriver().findElement(complemento).sendKeys("Prédio");
        getDriver().findElement(cidade).sendKeys("Barueri");
        getDriver().findElement(estado).sendKeys("Alaska");
        getDriver().findElement(cep).sendKeys("00000");
        getDriver().findElement(pais).sendKeys("United States");
        getDriver().findElement(celular).sendKeys("5515981206345");
        getDriver().findElement(enderecoSecundario).clear();
        getDriver().findElement(enderecoSecundario).sendKeys("Rua das rosas azuis");
        getDriver().findElement(btnRegistrarUsuario).click();
    }
}





