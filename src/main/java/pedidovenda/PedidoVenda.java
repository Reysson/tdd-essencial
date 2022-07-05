package pedidovenda;

import desconto.CalculadoraFaixaDesconto;

import java.util.ArrayList;
import java.util.List;

public class PedidoVenda {

    private double valorTotal = 0;
    private double desconto = 0;
    private final List<ItemPedido> itemPedidos = new ArrayList<>();
    private final CalculadoraFaixaDesconto calculadoraFaixaDesconto;

    public PedidoVenda(CalculadoraFaixaDesconto calculadoraFaixaDesconto) {
        this.calculadoraFaixaDesconto = calculadoraFaixaDesconto;
    }

    public void adicionarItem(ItemPedido itemPedido) {
        if (itemPedido.getQuantidade() < 0) {
            throw new QuantidadeItensInvalidaException();
        }
        itemPedidos.add(itemPedido);
    }

    public ResumoPedido resumoPedido() {
        double valorTotal = itemPedidos.stream().mapToDouble(i -> i.getQuantidade() * i.getValorUnitario()).sum();
        double desconto = calculadoraFaixaDesconto.desconto(valorTotal);

        return new ResumoPedido(valorTotal, desconto);
    }

}
