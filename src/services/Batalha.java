package services;

import models.Jogador;
import models.Adversario;
import models.Ataque;
import models.Pokemon;
import models.Treinador;
import utils.Criar;
import utils.Escolher;

import java.util.Scanner;

public class Batalha {

    public void iniciar(Scanner sc, Jogador jogador, Adversario adversario) {
        while (true) {
            int ataqueJogador = atacar(sc, jogador, adversario);

            if (!adversario.pokemonAtualEstaMorto()) {
                int ataqueAdversario = atacar(adversario, jogador);
                imprimirResultadoAtaque(jogador, ataqueAdversario);
            }

            imprimirResultadoAtaque(adversario, ataqueJogador);
            Criar.divisoriaEmbrulho("treinadores", vidaPokemon(jogador), vidaPokemon(adversario));

            if (adversario.pokemonAtualEstaMorto()) {
                imprimiorPokemonAtualEstaMorto(adversario.getPokemonAtual());
                System.out.println("Você ganhou a batalha!");
                return;
            }

            if (jogador.pokemonAtualEstaMorto()) {
                imprimiorPokemonAtualEstaMorto(jogador.getPokemonAtual());
                System.out.println("Você perdeu a batalha!");
                return;
            }
        }
    }

    private void imprimiorPokemonAtualEstaMorto(Pokemon pokemon) {
        System.out.printf("%s está morto!\n", pokemon.getNome());
    }

    private String vidaPokemon(Treinador treinador) {
        Pokemon pokemon = treinador.getPokemonAtual();
        return String.format("%s : %s (%d)", treinador.getNome(), pokemon.getNome(), pokemon.getVida());
    }

    private void imprimirResultadoAtaque(Treinador alvo, int ataque) {
        System.out.printf("%s recebeu %d de dano\n", alvo.getPokemonAtual().getNome(), ataque);
    }

    private static Integer atacar(Scanner sc,Treinador atacante, Treinador alvo) {
        Pokemon pokemonAtacante = atacante.getPokemonAtual();
        Pokemon pokemonAlvo = alvo.getPokemonAtual();

        Ataque ataque = Escolher.ataque(sc, pokemonAtacante);

        return pokemonAlvo.receberDano(ataque);
    }
    private static Integer atacar(Treinador atacante, Treinador alvo) {
        Pokemon pokemonAtacante = atacante.getPokemonAtual();
        Pokemon pokemonAlvo = alvo.getPokemonAtual();

        Ataque ataque = Escolher.ataque(pokemonAtacante);

        return pokemonAlvo.receberDano(ataque);
    }
}
