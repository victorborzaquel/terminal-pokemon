package data.pokemons.evolucao1;

import data.ataques.nivel1.grama.RazorLeaf;
import data.enums.Especialidades;
import models.Ataque;
import models.Pokemon;

public class Ivyssauro extends Pokemon {
    public Ivyssauro() {
        super(
                "Ivyssauro",
                Especialidades.GRAMA,
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
