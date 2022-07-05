package pedidovendatest;

import desconto.*;
import org.junit.Before;
import org.junit.Test;
import pedidovenda.ItemPedido;
import pedidovenda.PedidoVenda;
import pedidovenda.ResumoPedido;

import static org.junit.Assert.assertEquals;

public class PedidoVendaTest {

    private double valorTotal;
    private double desconto;

    private PedidoVenda pedidoVenda;

    @Before
    public void setUp() {
        CalculadoraFaixaDesconto calculadoraFaixaDesconto =
                new CalculadoraDesconto3Faixa(
                new CalculadoraDesconto2Faixa(
                new CalculadoraDesconto1Faixa(
                new SemDesconto(null))));

        pedidoVenda = new PedidoVenda(calculadoraFaixaDesconto);
    }

    public void assertResumoPedido(double valorTotal, double desconto) {
        ResumoPedido resumoPedido = pedidoVenda.resumoPedido();
        assertEquals(valorTotal, resumoPedido.getValorTotal(), 0.0001);
        assertEquals(desconto, resumoPedido.getDesconto(), 0.0001);
    }

    @Test
    public void devePermitirAdicionarUmItemNoPedido() {
        pedidoVenda.adicionarItem(new ItemPedido("Sabonete", 3.0, 10));
    }

    @Test
    public void deveCalcularValorTotalParaEDescontoPedidoVazio() {
        assertResumoPedido(0.0, 0.0);
    }

    @Test
    public void deveCalcularResumoParaUmItemSemDesconto() {
        pedidoVenda.adicionarItem(new ItemPedido("Sabonete", 5.0, 5));
        assertResumoPedido(25.0, 0.0);
    }

    @Test
    public void deveCalcularResumoParaDoisItensPedido() {
        pedidoVenda.adicionarItem(new ItemPedido("Sabonete", 3.0, 3));
        pedidoVenda.adicionarItem(new ItemPedido("Pasta dental", 7.0, 3));

        assertResumoPedido(30.0, 0);
    }

    @Test
    public void deveCalcularDescontoNa1Faixa() {
        pedidoVenda.adicionarItem(new ItemPedido("Creme", 20.0, 20));

        assertResumoPedido(400.0, 16.0);
    }

    @Test
    public void deveAplicarDescontoNa2Faixa() {
        pedidoVenda.adicionarItem(new ItemPedido("Shampoo", 15.0, 30));
        pedidoVenda.adicionarItem(new ItemPedido("Óleo", 15.0, 30));

        assertResumoPedido(900.0, 54.0);

    }

    @Test
    public void deveAplicarDescontoNa3Faixa() {
        pedidoVenda.adicionarItem(new ItemPedido("Shampoo", 15.0, 30));
        pedidoVenda.adicionarItem(new ItemPedido("Óleo", 15.0, 30));
        pedidoVenda.adicionarItem(new ItemPedido("Creme", 20.0, 20));

        assertResumoPedido(1300.0, 104.0);
    }

}
