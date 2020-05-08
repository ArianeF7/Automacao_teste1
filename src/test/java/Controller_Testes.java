import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Controller_Testes extends BaseTest {

    private Index index = new Index();
    private Order order = new Order();
    private Authentication authentication = new Authentication();
    private ConfirmAdress confirmAdress = new ConfirmAdress();
    private TermsService termsService = new TermsService();
    private PaymentMethod paymentMethod = new PaymentMethod();
    private OrderSummary confirmOrder = new OrderSummary();

    @Test
    public void testRealizarCompra() throws InterruptedException {
        String produto = "blouse";
        index.acessarAplicação();
        index.buscaProduto(produto); //****Inserindo o nome do produto na busca*****
        index.selecionarProduto();
        Thread.sleep(3000);
        order.checkout("blouse"); //****Verificando o nome do produto no checkout*****
        authentication.cadastrarNovoUsuario("testeAriane36@email.com");
        authentication.dadosCadastraisUsuario();
        authentication.dadosEnderecoUsuario();
        confirmAdress.confirmarEnderecoEntrega();
        termsService.aceiteTermos();
        paymentMethod.tipoPagto("blouse");
        confirmOrder.confirmarCompra();
    }
}

