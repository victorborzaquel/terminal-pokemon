package data.treinadores;

import data.enums.Especialidades;
import data.pokemons.evolucao1.Bulbassauro;
import data.pokemons.evolucao2.Charmander;
import data.pokemons.evolucao3.Squirtle;
import models.Adversario;
import models.Pokemon;

public class Brock extends Adversario {
    public Brock() {
        super(
                "Brock",
                Especialidades.GRAMA,
                "Valoriza a força!",
                new Pokemon[]{
                        new Bulbassauro(),
                        new Charmander(),
                        new Squirtle()
                });
    }
}
