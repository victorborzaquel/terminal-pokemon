package data.treinadores;

import data.enums.Especialidades;
import data.pokemons.evolucao1.Bulbassauro;
import data.pokemons.evolucao2.Charmander;
import data.pokemons.evolucao3.Squirtle;
import models.Adversario;
import models.Pokemon;

public class Ash extends Adversario {
    public Ash() {
        super(
                "Ash",
                Especialidades.FOGO,
                "Hora de batalhar!",
                new Pokemon[]{
                        new Charmander(),
                        new Squirtle(),
                        new Bulbassauro()
                });
    }
}
