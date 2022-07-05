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

    private PedidoBuilder pedidoBuilder;

    @Before
    public void setUp() {
        pedidoBuilder = new PedidoBuilder();
    }

    public void assertResumoPedido(double valorTotal, double desconto) {
        ResumoPedido resumoPedido = pedidoBuilder.construir().resumoPedido();
        assertEquals(valorTotal, resumoPedido.getValorTotal(), 0.0001);
        assertEquals(desconto, resumoPedido.getDesconto(), 0.0001);
    }

    @Test
    public void devePermitirAdicionarUmItemNoPedido() {
        pedidoBuilder.comItem(3.0, 10);
    }

    @Test
    public void deveCalcularValorTotalParaEDescontoPedidoVazio() {
        assertResumoPedido(0.0, 0.0);
    }

    @Test
    public void deveCalcularResumoParaUmItemSemDesconto() {
        pedidoBuilder.comItem(5.0, 5);

        assertResumoPedido(25.0, 0.0);
    }

    @Test
    public void deveCalcularResumoParaDoisItensPedido() {
        pedidoBuilder
                .comItem(3.0, 3)
                .comItem(7.0, 3);

        assertResumoPedido(30.0, 0);
    }

    @Test
    public void deveCalcularDescontoNa1Faixa() {
        pedidoBuilder.comItem(20.0, 20);

        assertResumoPedido(400.0, 16.0);
    }

    @Test
    public void deveAplicarDescontoNa2Faixa() {
        pedidoBuilder
                .comItem(15.0, 30)
                .comItem(15.0, 30);

        assertResumoPedido(900.0, 54.0);

    }

    @Test
    public void deveAplicarDescontoNa3Faixa() {
        pedidoBuilder
                .comItem(15.0, 30)
                .comItem(15.0, 30)
                .comItem(20.0, 20);

        assertResumoPedido(1300.0, 104.0);
    }

}
