package services;

import data.Jogador;
import models.Adversario;
import utils.Criar;
import utils.Escolher;

import java.util.Scanner;

public class Partida {
    private Boolean perdeu;

    public void iniciar(Scanner sc, Jogador jogador, Adversario adversario) {
        Criar.divisoriaEmbrulho(String.format("%s: %s\n", adversario.getNome(), adversario.getFrase()));

        Escolher.pokemon(sc, jogador);
        Escolher.pokemon(adversario);

        while (true) {
            Batalha batalha = new Batalha();

            if (jogador.pokemonAtualEstaMorto()) {
                Escolher.pokemon(sc, jogador);
            }

            if (adversario.pokemonAtualEstaMorto()) {
                Escolher.pokemon(adversario);
            }

            batalha.iniciar(sc, jogador, adversario);

            if (adversario.estaMorto()) {
                perdeu = false;
                jogador.restaurarVidaTodosPokemons();
                Criar.divisoriaEmbrulho("Você ganhou a partida!");
                return;
            }

            if (jogador.estaMorto()) {
                perdeu = true;
                Criar.divisoriaEmbrulho("Você perdeu a partida!");
                return;
            }
        }
    }

    public Boolean jogadorPerdeu() {
        return perdeu;
    }
}
