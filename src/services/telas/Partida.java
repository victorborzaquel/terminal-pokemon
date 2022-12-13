package services.telas;

import models.Jogador;
import models.Adversario;
import utils.Dialogo;
import utils.Escolher;

import java.util.Scanner;

public final class Partida {
    public static void iniciar(Scanner sc, Jogador jogador, Adversario adversario) {
        Dialogo.fraseAdversario(adversario);

        Escolher.pokemon(sc, jogador);
        Escolher.pokemon(adversario);

        while (true) {
            if (jogador.pokemonAtualEstaMorto()) {
                Escolher.pokemon(sc, jogador);
            }

            if (adversario.pokemonAtualEstaMorto()) {
                Escolher.pokemon(adversario);
            }

            Batalha.iniciar(sc, jogador, adversario);

            if (jogador.temPokemonMorto() && jogador.temRevive()) {
                Escolher.reviverPokemon(sc, jogador);
            }

            if (adversario.estaMorto() || jogador.estaMorto()) {
                return;
            }
        }
    }
}
