package pedidovendatest;

import org.junit.Before;
import org.junit.Test;
import pedidovenda.ItemPedido;
import pedidovenda.PedidoVenda;

import static org.junit.Assert.assertEquals;

public class PedidoVendaTest {

    private double valorTotal;
    private double desconto;

    private PedidoVenda pedidoVenda;

    @Before
    public void setUp(){
        pedidoVenda = new PedidoVenda();
    }
    public void assertResumoPedido(double valorTotal, double desconto) {
        assertEquals(valorTotal, pedidoVenda.getValorTotal(), 0.0001);
        assertEquals(desconto, pedidoVenda.getDesconto(), 0.0001);
    }

    @Test
    public void devePermitirAdicionarUmItemNoPedido() {
        PedidoVenda pedidoVenda = new PedidoVenda();
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

}
