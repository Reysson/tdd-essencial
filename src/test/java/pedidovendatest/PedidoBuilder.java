package pedidovendatest;

import desconto.*;
import pedidovenda.ItemPedido;
import pedidovenda.PedidoVenda;

public class PedidoBuilder {

    private PedidoVenda instancia;

    public PedidoBuilder() {

        CalculadoraFaixaDesconto calculadoraFaixaDesconto =
                new CalculadoraDesconto3Faixa(
                new CalculadoraDesconto2Faixa(
                new CalculadoraDesconto1Faixa(
                new SemDesconto(null))));

        instancia = new PedidoVenda(calculadoraFaixaDesconto);

    }

    public PedidoBuilder comItem(double valorUnitario, int quantidade) {
        instancia.adicionarItem(new ItemPedido("Gerado", valorUnitario, quantidade));
        return this;
    }

    public PedidoVenda construir() {
        return instancia;
    }

}
