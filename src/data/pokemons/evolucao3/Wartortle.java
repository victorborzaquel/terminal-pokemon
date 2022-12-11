package data.pokemons.evolucao3;

import data.ataques.nivel1.agua.WaterGun;
import data.enums.Especialidades;
import models.Ataque;
import models.Pokemon;

public class Wartortle extends Pokemon {
    public Wartortle() {
        super(
                "Wartortle",
                Especialidades.AGUA,
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
