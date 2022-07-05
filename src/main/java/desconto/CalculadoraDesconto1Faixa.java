package desconto;

public class CalculadoraDesconto1Faixa extends CalculadoraFaixaDesconto {

    public CalculadoraDesconto1Faixa(CalculadoraFaixaDesconto proximo) {
        super(proximo);
    }
    @Override
    protected double calcular(double valorTotal) {
        if (valorTotal > 300 && valorTotal <= 800) {
            return valorTotal * 0.04;
        }

        return -1;
    }
}
