package utils;

import errors.PPInsuficienteException;
import errors.PedraEvolucaoException;
import errors.PokemonException;
import errors.SemPokemonsException;
import models.Ataque;
import models.Jogador;
import models.Pokemon;
import models.Treinador;

import java.util.Arrays;
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

        final Pokemon[] pokemons = jogador.getPokemons();

        if (!pokemons[indice].estaMorto()) {
            throw new PedraEvolucaoException("Esse pokemon não está morto");
        }

        jogador.usarRevive(indice);
    }

    public static void atacar(Scanner sc, Treinador atacante, Treinador alvo) {
        final Pokemon pokemonAtacante = atacante.getPokemonAtual();
        final Pokemon pokemonAlvo = alvo.getPokemonAtual();

        final Ataque[] ataques = Arrays.stream(pokemonAtacante.getAtaques())
                .filter(ataque -> ataque.getPpAtual() > 0)
                .toArray(Ataque[]::new);

        if (ataques.length == 0) {
            System.out.printf("%s não tem ataques disponíveis%n", pokemonAtacante.getNome());
            return;
        }

        try {
            final Ataque ataque = Escolha.ataque(sc, pokemonAtacante);
            final int dano = pokemonAlvo.receberDano(ataque);
            Dialogo.resultadoAtaque(alvo, dano);
        } catch (PPInsuficienteException e) {
            Imprima.divisoriaEmbrulho(e.getMessage());
            atacar(sc, atacante, alvo);
        }
    }

    public static void atacar(Treinador atacante, Treinador alvo) {
        final Pokemon pokemonAtacante = atacante.getPokemonAtual();
        final Pokemon pokemonAlvo = alvo.getPokemonAtual();

        try {
            final Ataque ataque = Escolha.ataque(pokemonAtacante);
            final int dano = pokemonAlvo.receberDano(ataque);
            Dialogo.resultadoAtaque(alvo, dano);
        } catch (PPInsuficienteException e) {
            Imprima.divisoriaEmbrulho(e.getMessage());
        }
    }
}
