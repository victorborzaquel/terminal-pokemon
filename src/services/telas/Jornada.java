package services.telas;

import data.Geracoes;
import models.Jogador;
import data.Historicos;
import models.Adversario;
import utils.Dialogo;
import utils.Escolha;
import utils.Arquivo;

import java.util.Scanner;

public final class Jornada {

    private Jornada() {
        throw new IllegalStateException("Utility class");
    }

    public static void iniciar(Scanner sc) {
        Dialogo.iniciandoJornada();

        final Geracoes geracao = Escolha.geracao(sc);
        final Jogador jogador = Escolha.jogador(sc, geracao);

        while (true) {
            if (jogador.getNivel() > 1) {
                final boolean ehAbandono = Escolha.abandonar(sc);
                if (ehAbandono) {
                    Arquivo.salvar(jogador, Historicos.DESISTENCIAS);
                    return;
                }
            }

            Dialogo.mostrarNivelJogador(jogador);

            if (jogador.temPedraEvolucao()) {
                Escolha.evoluirPokemon(sc, jogador);
            }

            final Adversario adversario = Escolha.adversario(sc, jogador);

            Partida.iniciar(sc, jogador, adversario);

            if (jogador.estaMorto()) {
                Dialogo.perdeuJogo();
                Arquivo.salvar(jogador, Historicos.DERROTAS);
                return;
            }

            if (jogador.getNivel() >= 3) {
                Dialogo.ganhouJogo(jogador);
                Arquivo.salvar(jogador, Historicos.VITORIAS);
                Escolha.reiniciar(sc);
                return;
            }

            jogador.restaurarVidaTodosPokemons();
            jogador.adicionarPedraEvolucao();
            jogador.restaurarRevive();
            jogador.evoluir();

            Dialogo.ganhouPartida();
        }
    }
}
