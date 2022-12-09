package data.pokemons;

import data.ataques.RazorLeaf;
import models.Ataque;
import models.Pokemon;

public class Ivyssauro extends Pokemon {
    public Ivyssauro() {
        super(
                "Ivyssauro",
                new Venussauro(),
                500,
                new Ataque[]{
                        new RazorLeaf(),
                        new RazorLeaf(),
                        new RazorLeaf()
                }
        );
    }
}
