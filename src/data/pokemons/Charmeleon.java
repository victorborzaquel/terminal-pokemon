package data.pokemons;

import data.ataques.FireFang;
import models.Ataque;
import models.Pokemon;

public class Charmeleon extends Pokemon {
    public Charmeleon() {
        super(
                "Charmeleon",
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
