package utils;

import data.Adversarios;
import data.Ataques;
import data.Especialidades;
import data.Pokemons;
import models.Adversario;
import models.Ataque;
import models.Pokemon;

import java.util.Arrays;

public class Instanciar {
    public static Adversario adversario(Adversarios adversarioEnum) {
        String nome = adversarioEnum.getNome();
        Especialidades especialidade = adversarioEnum.getEspecialidade();
        String frase = adversarioEnum.getFrase();
        Pokemons[] pokemonsEnum = adversarioEnum.getPokemons();
        Pokemon[] pokemons = Arrays.stream(pokemonsEnum).map(Instanciar::pokemon).toArray(Pokemon[]::new);

        return new Adversario(nome, especialidade, frase, pokemons);
    }

    public static Pokemon pokemon(Pokemons pokemonEnum) {
        String nome = pokemonEnum.getNome();
        Especialidades especialidade = pokemonEnum.getEspecialidade();
        Pokemons evolucaoEnum = pokemonEnum.getEvolucao();
        Pokemon evolucao = evolucaoEnum == null ? null : pokemon(evolucaoEnum);
        Integer vida = pokemonEnum.getVida();
        Ataques[] ataquesEnum = pokemonEnum.getAtaques();
        Ataque[] ataques = Arrays.stream(ataquesEnum).map(Instanciar::ataque).toArray(Ataque[]::new);

        return new Pokemon(nome, especialidade, evolucao, vida, ataques);
    }

    public static Ataque ataque(Ataques ataqueEnum) {
        String nome = ataqueEnum.getNome();
        Especialidades especialidade = ataqueEnum.getEspecialidade();
        Integer danoMinimo = ataqueEnum.getDanoMinimo();
        Integer danoMaximo = ataqueEnum.getDanoMaximo();

        return new Ataque(nome, especialidade, danoMinimo, danoMaximo);
    }
}
