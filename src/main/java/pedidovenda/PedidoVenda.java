package pedidovenda;

import desconto.CalculadoraFaixaDesconto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

public class PedidoVenda {

    private double valorTotal = 0;
    private double desconto = 0;
    private List<ItemPedido> itemPedidos = new ArrayList<>();
    private CalculadoraFaixaDesconto calculadoraFaixaDesconto;

    public PedidoVenda(CalculadoraFaixaDesconto calculadoraFaixaDesconto) {
        this.calculadoraFaixaDesconto = calculadoraFaixaDesconto;
    }

    public void adicionarItem(ItemPedido itemPedido) {
        itemPedidos.add(itemPedido);
    }

    public ResumoPedido resumoPedido() {
        double valorTotal = itemPedidos.stream().mapToDouble(i -> i.getQuantidade() * i.getValorUnitario()).sum();
        double desconto = calculadoraFaixaDesconto.desconto(valorTotal);

        return new ResumoPedido(valorTotal, desconto);
    }

}
