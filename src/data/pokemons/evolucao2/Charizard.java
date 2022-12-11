package data.pokemons.evolucao2;

import data.ataques.nivel1.fogo.FireFang;
import data.enums.Especialidades;
import models.Ataque;
import models.Pokemon;

public class Charizard extends Pokemon {
    public Charizard() {
        super(
                "Charizard",
                Especialidades.FOGO,
                null,
                600,
                new Ataque[]{
                        new FireFang(),
                        new FireFang(),
                        new FireFang()
                }
        );
    }
}
