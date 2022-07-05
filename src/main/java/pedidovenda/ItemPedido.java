package pedidovenda;

public class ItemPedido {
    private final String descricao;
    private final double valorUnitario;
    private final int quantidade;

    public ItemPedido(String descricao, double valorUnitario, int quantidade) {
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
