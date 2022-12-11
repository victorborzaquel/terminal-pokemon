package data.pokemons.evolucao3;

import data.ataques.nivel1.agua.WaterGun;
import data.enums.Especialidades;
import models.Ataque;
import models.Pokemon;

public class Blastoise extends Pokemon {
    public Blastoise() {
        super(
                "Blastoise",
                Especialidades.AGUA,
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
