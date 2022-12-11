package data.pokemons.evolucao2;

import data.ataques.nivel1.fogo.FireFang;
import data.enums.Especialidades;
import models.Ataque;
import models.Pokemon;

public class Charmander extends Pokemon {
    public Charmander() {
        super(
                "Charmander",
                Especialidades.FOGO,
                new Charmeleon(),
                90,
                new Ataque[]{
                        new FireFang(),
                        new FireFang(),
                        new FireFang()
                }
        );
    }
}
