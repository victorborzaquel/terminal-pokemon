package data.treinadores;

import data.enums.Especialidades;
import data.pokemons.evolucao1.Bulbassauro;
import data.pokemons.evolucao2.Charmander;
import data.pokemons.evolucao3.Squirtle;
import models.Adversario;
import models.Pokemon;

public class Misty extends Adversario {
    public Misty() {
        super(
                "Misty",
                Especialidades.AGUA,
                "Vamos lá!",
                new Pokemon[]{
                        new Bulbassauro(),
                        new Charmander(),
                        new Squirtle()
                });
    }
}
