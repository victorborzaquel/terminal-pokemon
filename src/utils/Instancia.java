package utils;

import data.*;
import models.Adversario;
import models.Ataque;
import models.Jogador;
import models.Pokemon;

import java.util.Arrays;

public final class Instancia {
    private Instancia() {
        throw new IllegalStateException("Utility class");
    }

    public static Jogador jogador(String nome, Geracoes geracao) {
        final int NIVEL = 1;
        final Pokemons[] pokemonsEnum = geracao.getIniciais();
        final Pokemon[] pokemons = Arrays.stream(pokemonsEnum)
                .map(Instancia::pokemon)
                .toArray(Pokemon[]::new);

        return new Jogador(nome, NIVEL, pokemons);
    }

    public static Adversario adversario(Adversarios adversarioEnum) {
        final String nome = adversarioEnum.getNome();
        final int nivel = adversarioEnum.getNivel();
        final Especialidades especialidade = adversarioEnum.getEspecialidade();
        final String frase = adversarioEnum.getFrase();
        final Pokemons[] pokemonsEnum = adversarioEnum.getPokemons();
        final Pokemon[] pokemons = Arrays.stream(pokemonsEnum)
                .map(Instancia::pokemon)
                .toArray(Pokemon[]::new);

        return new Adversario(nome, nivel, especialidade, frase, pokemons);
    }

    public static Pokemon pokemon(Pokemons pokemonEnum) {
        final String nome = pokemonEnum.getNome();
        final Especialidades especialidade = pokemonEnum.getEspecialidade();
        final Pokemons evolucaoEnum = pokemonEnum.getEvolucao();
        final Pokemon evolucao = evolucaoEnum == null ? null : pokemon(evolucaoEnum);
        final Integer vida = pokemonEnum.getVida();
        final Ataques[] ataquesEnum = pokemonEnum.getAtaques();
        final Ataque[] ataques = Arrays.stream(ataquesEnum)
                .map(Instancia::ataque)
                .toArray(Ataque[]::new);

        return new Pokemon(nome, especialidade, evolucao, vida, ataques);
    }

    public static Ataque ataque(Ataques ataqueEnum) {
        final String nome = ataqueEnum.getNome();
        final Especialidades especialidade = ataqueEnum.getEspecialidade();
        final Integer danoMinimo = ataqueEnum.getDanoMinimo();
        final Integer danoMaximo = ataqueEnum.getDanoMaximo();
        final Integer pp = ataqueEnum.getPp();

        return new Ataque(nome, especialidade, danoMinimo, danoMaximo, pp);
    }
}
