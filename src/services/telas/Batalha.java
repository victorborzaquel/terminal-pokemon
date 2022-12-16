package services.telas;

import models.Jogador;
import models.Adversario;
import utils.Dialogo;
import utils.Escolha;
import utils.PokemonUtils;

import java.util.Scanner;

public final class Batalha {

    private Batalha() {
        throw new IllegalStateException("Utility class");
    }

    public static void iniciar(Scanner sc, Jogador jogador, Adversario adversario) {
        while (true) {
            Escolha.acaoBatalha(sc, jogador);
            final int ataqueJogador = PokemonUtils.atacar(sc, jogador, adversario);

            if (adversario.pokemonAtualEstaVivo()) {
                final int ataqueAdversario = PokemonUtils.atacar(adversario, jogador);
                Dialogo.resultadoAtaque(jogador, ataqueAdversario);
            }

            Dialogo.resultadoAtaque(adversario, ataqueJogador);
            Dialogo.resumoBatalha(jogador, adversario);

            if (adversario.pokemonAtualEstaMorto()) {
                Dialogo.pokemonMorreu(adversario);
                return;
            }

            if (jogador.pokemonAtualEstaMorto()) {
                Dialogo.pokemonMorreu(jogador);
                return;
            }
        }
    }
}
