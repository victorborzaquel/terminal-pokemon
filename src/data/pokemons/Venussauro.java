package data.pokemons;

import data.ataques.RazorLeaf;
import models.Ataque;
import models.Pokemon;

public class Venussauro extends Pokemon {
    public Venussauro() {
        super(
                "Venussauro",
                null,
                500,
                new Ataque[]{
                        new RazorLeaf(),
                        new RazorLeaf(),
                        new RazorLeaf()
                }
        );
    }
}
