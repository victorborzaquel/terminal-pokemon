package data.pokemons.evolucao1;

import data.ataques.nivel1.grama.RazorLeaf;
import data.enums.Especialidades;
import models.Ataque;
import models.Pokemon;

public class Bulbassauro extends Pokemon {
    public Bulbassauro() {
        super(
                "Bulbassauro",
                Especialidades.GRAMA,
                new Ivyssauro(),
                110,
                new Ataque[]{
                        new RazorLeaf(),
                        new RazorLeaf(),
                        new RazorLeaf()
                }
        );
    }
}
