package utils;

import errors.PedraEvolucaoException;
import errors.PokemonException;
import errors.SemPokemonsException;
import models.Ataque;
import models.Jogador;
import models.Pokemon;
import models.Treinador;

import java.util.Map;
import java.util.Scanner;

public final class PokemonUtils {
    private PokemonUtils() {
        throw new IllegalStateException("Utility class");
    }

    static void reviver(Jogador jogador, Integer indice) throws SemPokemonsException, PokemonException, PedraEvolucaoException {
        if (!jogador.temPokemonMorto()) {
            throw new SemPokemonsException("O treinador não tem pokemons mortos");
        }
        if (!jogador.getPokemonsMortos().containsKey(indice)) {
            throw new PokemonException("Esse pokemon não está morto");
        }

        final Map<Integer, Pokemon> pokemons = jogador.getPokemonsMortos();

        final Integer[] pokemonsIndices = pokemons.keySet().toArray(Integer[]::new);

        jogador.usarRevive(pokemonsIndices[indice]);
    }

    public static Integer atacar(Scanner sc, Treinador atacante, Treinador alvo) {
        final Pokemon pokemonAtacante = atacante.getPokemonAtual();
        final Pokemon pokemonAlvo = alvo.getPokemonAtual();

        final Ataque ataque = Escolha.ataque(sc, pokemonAtacante);

        return pokemonAlvo.receberDano(ataque);
    }

    public static Integer atacar(Treinador atacante, Treinador alvo) {
        final Pokemon pokemonAtacante = atacante.getPokemonAtual();
        final Pokemon pokemonAlvo = alvo.getPokemonAtual();

        final Ataque ataque = Escolha.ataque(pokemonAtacante);

        return pokemonAlvo.receberDano(ataque);
    }
}
