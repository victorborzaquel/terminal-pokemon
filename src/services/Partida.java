package services;

import data.Jogador;
import data.enums.Historicos;
import models.Adversario;
import models.Treinador;
import utils.Criar;
import utils.Escolher;
import utils.Evoluir;
import utils.Historico;

import java.util.Scanner;

public class Partida {
    public static void iniciar(
            Scanner sc
    ) {
        System.out.println("Começando uma nova partida...");
        Criar.divisoria();

        Jogador jogador = Escolher.jogador(sc);

        while (true) {
            if (jogador.getNivel() > 1) {
                Criar.divisoriaEmbrulho("Você está no nível " + jogador.getNivel());
            }

            Escolher.pokemon(sc, jogador);

            if (jogador.temPedraEvolucao()) {
                Evoluir.pokemon(sc, jogador);
            }

            Adversario adversario = Escolher.adversario(sc);

            Batalha batalha = new Batalha();

            Criar.textoInicial(jogador, adversario);
            batalha.iniciar(sc, jogador, adversario);

            if (!batalha.ganhou()) {
                System.out.println("Você perdeu o Jogo!");
                Historico.salvar(jogador, Historicos.DERROTAS);
                return;
            }

            if (jogador.getNivel() >= 3) {
                System.out.println("Você ganhou o Jogo!");
                Historico.salvar(jogador, Historicos.VITORIAS);
                return;
            }

            System.out.println("Você ganhou a batalha!");
            jogador.adicionarPedraEvolucao();
            jogador.evoluir();
        }
    }
}
