package data.pokemons.evolucao2;

import data.ataques.nivel1.fogo.FireFang;
import data.enums.Especialidades;
import models.Ataque;
import models.Pokemon;

public class Charmeleon extends Pokemon {
    public Charmeleon() {
        super(
                "Charmeleon",
                Especialidades.FOGO,
                new Charizard(),
                600,
                new Ataque[]{
                        new FireFang(),
                        new FireFang(),
                        new FireFang()
                }
        );
    }
}
