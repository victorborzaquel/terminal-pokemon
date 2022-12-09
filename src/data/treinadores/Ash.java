package data.treinadores;

import data.pokemons.Bulbassauro;
import data.pokemons.Charmander;
import data.pokemons.Squirtle;
import models.Adversario;
import models.Pokemon;

public class Ash extends Adversario {
    public Ash() {
        super(
                "Ash",
                "Hora de batalhar!",
                new Pokemon[]{
                        new Charmander(),
                        new Squirtle(),
                        new Bulbassauro()
                }
        );
    }
}
