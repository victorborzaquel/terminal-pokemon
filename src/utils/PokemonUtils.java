package utils;

import errors.PokemonException;
import errors.SemPokemonsException;
import models.Ataque;
import models.Jogador;
import models.Pokemon;
import models.Treinador;

import java.util.Map;
import java.util.Scanner;

public final class PokemonUtils {
    static void reviver(Scanner sc, Jogador jogador) throws SemPokemonsException {
        if (!jogador.temPokemonMorto()) {
            throw new SemPokemonsException("O treinador não tem pokemons mortos");
        }

        final Map<Integer, Pokemon> pokemons = jogador.getPokemonsMortos();

        final String[] pokemonsNomes = pokemons
                .values()
                .stream()
                .map(Pokemon::getNome)
                .toArray(String[]::new);

        final Integer[] pokemonsIndices = pokemons
                .keySet()
                .toArray(Integer[]::new);

        final int escolha = Imprimir.escolhaUmaOpcao(sc, "Escolha um pokemon para reviver", pokemonsNomes);

        try {
            jogador.usarRevive(pokemonsIndices[escolha - 1]);
        } catch (PokemonException e) {
            Imprimir.divisoriaEmbrulho(e.getMessage());
        }

        final Pokemon pokemon = pokemons.get(escolha - 1);
        final String pokemonNome = pokemon.getNome();
        final Integer pokemonVida = pokemon.getVida();
        final String mensagem = String.format("Seu pokemon %s reviveu e está com %d de vida!", pokemonNome, pokemonVida);

        Imprimir.divisoriaEmbrulho(mensagem);
    }

    public static Integer atacar(Scanner sc, Treinador atacante, Treinador alvo) {
        final Pokemon pokemonAtacante = atacante.getPokemonAtual();
        final Pokemon pokemonAlvo = alvo.getPokemonAtual();

        final Ataque ataque = Escolher.ataque(sc, pokemonAtacante);

        return pokemonAlvo.receberDano(ataque);
    }
    public static Integer atacar(Treinador atacante, Treinador alvo) {
        final Pokemon pokemonAtacante = atacante.getPokemonAtual();
        final Pokemon pokemonAlvo = alvo.getPokemonAtual();

        final Ataque ataque = Escolher.ataque(pokemonAtacante);

        return pokemonAlvo.receberDano(ataque);
    }
}
