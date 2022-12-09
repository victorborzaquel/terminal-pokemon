package data.treinadores;

import data.pokemons.Bulbassauro;
import data.pokemons.Charmander;
import data.pokemons.Squirtle;
import models.Adversario;
import models.Pokemon;

public class Brock extends Adversario {
    public Brock() {
        super(
                "Brock",
                "Valoriza a força!",
                new Pokemon[]{
                        new Bulbassauro(),
                        new Charmander(),
                        new Squirtle()
                }
        );
    }
}
