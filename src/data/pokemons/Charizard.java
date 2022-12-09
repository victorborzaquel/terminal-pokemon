package data.pokemons;

import data.ataques.FireFang;
import models.Ataque;
import models.Pokemon;

public class Charizard extends Pokemon {
    public Charizard() {
        super(
                "Charizard",
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
