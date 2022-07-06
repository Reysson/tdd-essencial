package passagemaerea.service;

import passagemaerea.model.Voo;

public class PrecoPassagemSilver implements CalculadoraPrecoPassagem {

    @Override
    public double calcular(Voo voo) {
        if (voo.getPreco() > 700.0)
            return voo.getPreco() * 0.9;
        return voo.getPreco() * 0.94;
    }

}