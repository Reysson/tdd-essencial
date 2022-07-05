package pedidovenda;

public class PedidoVenda {

    private double valorTotal = 0;
    private double desconto = 0;

    public void adicionarItem(ItemPedido itemPedido) {
        valorTotal = itemPedido.getValorUnitario() * itemPedido.getQuantidade();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double getDesconto() {
        return desconto;
    }
}
