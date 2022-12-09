package services;

import data.Jogador;
import models.Adversario;
import models.Pokemon;
import models.Treinador;
import utils.Criar;
import utils.Escolher;

import java.util.Scanner;

public class Batalha {
    private Boolean jogadorVenceu;

    public void iniciar(
            Scanner sc,
            Jogador jogador,
            Adversario adversario
    ) {
        Pokemon pokemonJogador = jogador.getPokemonAtual();
        Pokemon pokemonAdversario = adversario.getPokemonAtual();

        while (true) {
            int ataqueJogador = Escolher.ataque(sc, pokemonJogador).getDano();
            atacar(ataqueJogador, pokemonAdversario, adversario);
            resultado(adversario, pokemonAdversario);

            if (!adversario.estaVivo()) {
                jogadorVenceu = true;
                return;
            }

            int ataqueAdversario = Escolher.ataque(pokemonAdversario).getDano();
            atacar(ataqueAdversario, pokemonJogador, jogador);
            resultado(jogador, pokemonJogador);

            if (!jogador.estaVivo()) {
                jogadorVenceu = false;
                return;
            }
        }
    }

    public Boolean ganhou() {
        return jogadorVenceu;
    }
    private static void resultado(Treinador treinador, Pokemon pokemon) {
        Criar.divisoria(treinador.toString());
        System.out.println(pokemon);
        Criar.divisoria();
    }

    private static void atacar(
            int ataque,
            Pokemon pokemonAlvo,
            Treinador treinadorAlvo
    ) {
        if (pokemonAlvo.getVida() > 0) {
            int restoDanoJogador = pokemonAlvo.receberDano(ataque);

            System.out.printf("%s recebeu %d de dano\n", pokemonAlvo.getNome(), ataque);
            if (restoDanoJogador > 0) {
                treinadorAlvo.receberDano(restoDanoJogador);
            }
        } else {
            treinadorAlvo.receberDano(ataque);
        }
    }
}
