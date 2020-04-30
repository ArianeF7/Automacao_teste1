package com.gft.Teste_compra;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class Controller_Testes {

    ChromeDriver driver;
    WebDriverWait wait;

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\Resources\\chromedriver.exe");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown (){
        driver.close();
    }

    @Test
    public void testRealizarCompra() throws InterruptedException {

        driver.get("http://automationpractice.com/index.php");

        String produto = "blouse";
        WebElement caixaBusca = driver.findElement(By.id("search_query_top"));
        caixaBusca.sendKeys(produto);

        driver.findElement(By.name("submit_search")).click();

        Thread.sleep(3000);
        driver.findElement(By.className("ajax_add_to_cart_button")).click();

        WebElement btnTesteRubens = wait.until(ExpectedConditions.elementToBeClickable(By.className("button-medium")));
        btnTesteRubens.click();

        String confProd = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#order-detail-content .product-name a"))).getText().toLowerCase();
        assertEquals(produto,confProd);

        String valTotal = driver.findElement(By.id("total_price")).getText();

        driver.findElement(By.className("standard-checkout")).click();

        WebElement inserirEmail = driver.findElement(By.id("email_create"));
        inserirEmail.sendKeys("testeAriane26@email.com");

        driver.findElement(By.id("SubmitCreate")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender2"))).click();

        WebElement primeiroNome = driver.findElement(By.id("customer_firstname"));
        primeiroNome.sendKeys("Ariane");

        WebElement ultimoNome = driver.findElement(By.id("customer_lastname"));
        ultimoNome.sendKeys("Lima");

        WebElement senhaNewUser = driver.findElement(By.id("passwd"));
        senhaNewUser.sendKeys("teste");

        WebElement diaNasc = driver.findElement(By.id("days"));
        diaNasc.sendKeys("7");

        WebElement mesNasc = driver.findElement(By.id("months"));
        mesNasc.sendKeys("August");

        WebElement anoNasc = driver.findElement(By.id("years"));
        anoNasc.sendKeys("1995");

        WebElement Endereco1 = driver.findElement(By.id("address1"));
        Endereco1.sendKeys("Alameda Rio Negro");

        WebElement Endereco2 = driver.findElement(By.id("address2"));
        Endereco2.sendKeys("Prédio");

        WebElement cidade = driver.findElement(By.id("city"));
        cidade.sendKeys("Barueri");

        WebElement estado = driver.findElement(By.id("id_state"));
        estado.sendKeys("Alaska");

        WebElement cep = driver.findElement(By.id("postcode"));
        cep.sendKeys("00000");

        WebElement pais = driver.findElement(By.id("id_country"));
        pais.sendKeys("United States");

        WebElement phone = driver.findElement(By.id("phone_mobile"));
        phone.sendKeys("5515981206345");

        WebElement endOutro = driver.findElement(By.id("alias"));
        endOutro.clear();
        endOutro.sendKeys("Rua das rosas azuis");

        driver.findElement(By.id("submitAccount")).click();

        String validaEndereco = driver.findElement(By.cssSelector("#uniform-id_address_delivery.selector span")).getText().toLowerCase();
        assertEquals("rua das rosas azuis",validaEndereco);

        driver.findElement(By.name("processAddress")).click();

        driver.findElement(By.id("cgv")).click();

        driver.findElement(By.name("processCarrier")).click();

        String validaTotal = driver.findElement(By.id("total_price")).getText();
        assertEquals(valTotal, validaTotal);

        driver.findElement(By.className("bankwire")).click();

        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).submit();

        String validaCompra = driver.findElement(By.className("page-heading")).getText();
        assertEquals("ORDER CONFIRMATION", validaCompra);
    }
}

