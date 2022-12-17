package services.telas;

import models.Jogador;
import models.Adversario;
import services.menus.MenuBatalha;
import utils.Dialogo;
import utils.PokemonUtils;

import java.util.Scanner;

public final class Batalha {

    private Batalha() {
        throw new IllegalStateException("Utility class");
    }

    public static void iniciar(Scanner sc, Jogador jogador, Adversario adversario) {
        while (true) {
            MenuBatalha.abrir(sc, jogador, adversario);

            if (adversario.pokemonAtualEstaVivo()) {
                PokemonUtils.atacar(adversario, jogador);
            }

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
