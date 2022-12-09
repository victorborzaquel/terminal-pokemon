package services;

import data.Jogador;
import data.enums.Historicos;
import models.Adversario;
import models.Treinador;
import utils.Criar;
import utils.Escolher;
import utils.Historico;

import java.util.Scanner;

public class Partida {
    public static void iniciar(
            Scanner sc,
            Jogador jogador
    ) {
        while (true) {
            System.out.println("Você está no nível " + jogador.getNivel());

            Escolher.pokemon(sc, jogador);

            if (jogador.temPedraEvolucao()) {
                System.out.println("Você tem uma pedra de evolução!");
                System.out.println("Deseja evoluir seu pokemon?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                System.out.print("Escolha: ");
                int escolha = sc.nextInt();

                if (escolha == 1) {
                    jogador.evoluirPokemon();
                }
            }

            Adversario adversario = Escolher.adversario(sc);

            Criar.textoInicial(jogador, adversario);

            boolean ganhou = Batalha.iniciar(sc, jogador, adversario);

            if (!ganhou) {
                System.out.println("Você perdeu o Jogo!");
                Historico.salvar(jogador, Historicos.DERROTAS);
                break;
            }

            if (jogador.getNivel() >= 3) {
                System.out.println("Você ganhou o Jogo!");
                Historico.salvar(jogador, Historicos.VITORIAS);
                break;
            }

            System.out.println("Você ganhou a batalha!");
            jogador.adicionarPedraEvolucao();
            jogador.evoluir();
        }
    }
}
