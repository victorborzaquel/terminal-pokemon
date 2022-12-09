package data.pokemons;

import data.ataques.WaterGun;
import models.Ataque;
import models.Pokemon;

public class Squirtle extends Pokemon {
    public Squirtle() {
        super(
                "Squirtle",
                new Wartortle(),
                700,
                new Ataque[]{
                        new WaterGun(),
                        new WaterGun(),
                        new WaterGun()
                }
        );
    }
}
