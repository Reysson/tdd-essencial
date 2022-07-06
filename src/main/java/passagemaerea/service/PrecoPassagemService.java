package passagemaerea.service;

import passagemaerea.model.Passageiro;
import passagemaerea.model.Voo;

public class PrecoPassagemService {

    public double calcular(Passageiro passageiro, Voo voo) {
        return passageiro.getTipo().getCalculadora().calcular(voo);
    }

}
