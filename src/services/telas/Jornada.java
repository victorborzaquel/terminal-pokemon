package services.telas;

import data.Geracoes;
import models.Jogador;
import data.Historicos;
import models.Adversario;
import utils.Dialogo;
import utils.Escolher;
import utils.Arquivo;

import java.util.Scanner;

public final class Jornada {
    public static void iniciar(Scanner sc) {
        Dialogo.iniciandoJornada();

        final Geracoes geracao = Escolher.geracao(sc);
        final Jogador jogador = Escolher.jogador(sc, geracao);

        while (true) {
            if (jogador.getNivel() > 1) {
                final Boolean ehAbandono = Escolher.abandonar(sc);
                if (ehAbandono) {
                    Arquivo.salvar(jogador, Historicos.DESISTENCIAS);
                    return;
                }
            }

            Dialogo.mostrarNivelJogador(jogador);

            if (jogador.temPedraEvolucao()) {
                Escolher.evoluirPokemon(sc, jogador);
            }

            final Adversario adversario = Escolher.adversario(sc, jogador);

            Partida.iniciar(sc, jogador, adversario);

            if (jogador.estaMorto()) {
                Dialogo.perdeuJogo();
                Arquivo.salvar(jogador, Historicos.DERROTAS);
                return;
            }

            if (jogador.getNivel() >= 3) {
                Dialogo.ganhouJogo();
                Arquivo.salvar(jogador, Historicos.VITORIAS);
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
