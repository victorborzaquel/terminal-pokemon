package data.treinadores;

import data.pokemons.Bulbassauro;
import data.pokemons.Charmander;
import data.pokemons.Squirtle;
import models.Adversario;
import models.Pokemon;

public class Misty extends Adversario {
    public Misty() {
        super(
                "Misty",
                "Vamos lá!",
                new Pokemon[]{
                        new Bulbassauro(),
                        new Charmander(),
                        new Squirtle()
                }
        );
    }
}
