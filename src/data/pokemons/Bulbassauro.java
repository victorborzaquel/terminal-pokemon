package data.pokemons;

import data.ataques.RazorLeaf;
import models.Ataque;
import models.Pokemon;

public class Bulbassauro extends Pokemon {
    public Bulbassauro() {
        super(
                "Bulbassauro",
                new Ivyssauro(),
                500,
                new Ataque[]{
                        new RazorLeaf(),
                        new RazorLeaf(),
                        new RazorLeaf()
                }
        );
    }
}
