package data.pokemons;

import data.ataques.FireFang;
import models.Ataque;
import models.Pokemon;

public class Charmander extends Pokemon {
    public Charmander() {
        super(
                "Charmander",
                new Charmeleon(),
                600,
                new Ataque[]{
                        new FireFang(),
                        new FireFang(),
                        new FireFang()
                }
        );
    }
}
