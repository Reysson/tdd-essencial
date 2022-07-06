package passagemaerea.model;

import passagemaerea.service.CalculadoraPrecoPassagem;
import passagemaerea.service.PrecoPassagemGold;
import passagemaerea.service.PrecoPassagemSilver;

public enum TipoPassageiro {

    GOLD(new PrecoPassagemGold()),
    SILVER(new PrecoPassagemSilver());

    CalculadoraPrecoPassagem calculadoraPrecoPassagem;

    TipoPassageiro(CalculadoraPrecoPassagem calculadoraPrecoPassagem) {
        this.calculadoraPrecoPassagem = calculadoraPrecoPassagem;
    }

    public CalculadoraPrecoPassagem getCalculadora() {
        return calculadoraPrecoPassagem;
    }
}
