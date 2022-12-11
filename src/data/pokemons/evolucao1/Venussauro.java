package data.pokemons.evolucao1;

import data.ataques.nivel1.grama.RazorLeaf;
import data.enums.Especialidades;
import models.Ataque;
import models.Pokemon;

public class Venussauro extends Pokemon {
    public Venussauro() {
        super(
                "Venussauro",
                Especialidades.GRAMA,
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
