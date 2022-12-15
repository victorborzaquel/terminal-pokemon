package services.telas;

import models.Jogador;
import models.Adversario;
import utils.Dialogo;
import utils.Escolha;

import java.util.Scanner;

public final class Partida {
    public static void iniciar(Scanner sc, Jogador jogador, Adversario adversario) {
        Dialogo.fraseAdversario(adversario);

        Escolha.pokemon(sc, jogador);
        Escolha.pokemon(adversario);

        while (true) {
            if (jogador.pokemonAtualEstaMorto()) {
                Escolha.pokemon(sc, jogador);
            }

            if (adversario.pokemonAtualEstaMorto()) {
                Escolha.pokemon(adversario);
            }

            Batalha.iniciar(sc, jogador, adversario);

            if (jogador.temPokemonMorto() && jogador.temRevive()) {
                Escolha.reviverPokemon(sc, jogador);
            }

            if (adversario.estaMorto() || jogador.estaMorto()) {
                return;
            }
        }
    }
}
