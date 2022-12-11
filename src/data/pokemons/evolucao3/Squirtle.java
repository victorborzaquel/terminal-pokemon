package data.pokemons.evolucao3;

import data.ataques.nivel1.agua.WaterGun;
import data.enums.Especialidades;
import models.Ataque;
import models.Pokemon;

public class Squirtle extends Pokemon {
    public Squirtle() {
        super(
                "Squirtle",
                Especialidades.AGUA,
                new Wartortle(),
                100,
                new Ataque[]{
                        new WaterGun(),
                        new WaterGun(),
                        new WaterGun()
                }
        );
    }
}
