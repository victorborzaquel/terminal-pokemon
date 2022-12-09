package data.pokemons;

import data.ataques.WaterGun;
import models.Ataque;
import models.Pokemon;

public class Blastoise extends Pokemon {
    public Blastoise() {
        super(
                "Blastoise",
                null,
                700,
                new Ataque[]{
                        new WaterGun(),
                        new WaterGun(),
                        new WaterGun()
                }
        );
    }
}
