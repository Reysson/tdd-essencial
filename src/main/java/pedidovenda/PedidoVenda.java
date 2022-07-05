package pedidovenda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

public class PedidoVenda {

    private double valorTotal = 0;
    private double desconto = 0;
    private List<ItemPedido> itemPedidos = new ArrayList<>();

    public void adicionarItem(ItemPedido itemPedido) {
        itemPedidos.add(itemPedido);
    }

    public ResumoPedido resumoPedido() {
        double valorTotal = itemPedidos.stream().mapToDouble(i -> i.getQuantidade() * i.getValorUnitario()).sum();
        double desconto = 0;

        if (valorTotal > 300 && valorTotal <= 800) {
            desconto = valorTotal * 0.04;

        } else if (valorTotal > 800.0 && valorTotal <= 1000.0) {
            desconto = valorTotal * 0.06;

        } else if (valorTotal > 1000.0) {
            desconto = valorTotal * 0.08;
        }

        return new ResumoPedido(valorTotal, desconto);
    }

}
