package data.pokemons;

import data.ataques.WaterGun;
import models.Ataque;
import models.Pokemon;

public class Wartortle extends Pokemon {
    public Wartortle() {
        super(
                "Wartortle",
                new Blastoise(),
                1200,
                new Ataque[]{
                        new WaterGun(),
                        new WaterGun(),
                        new WaterGun()
                }
        );
    }
}
