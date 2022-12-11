package services;

import data.Jogador;
import data.enums.Historicos;
import models.Adversario;
import utils.Criar;
import utils.Escolher;
import utils.Arquivo;

import java.util.Scanner;

public class Jornada {
    private Integer nivel;

    public Jornada() {
        nivel = 1;
    }

    public void iniciar(Scanner sc) {
        Criar.divisoriaEmbrulho("Começando uma nova jornada...");
        Jogador jogador = Escolher.jogador(sc);

        while (true) {
            if (nivel > 1) {
                Criar.divisoriaEmbrulho("Quer continuar sua jornada?");
                Integer escolha = Criar.escolhaUmaOpcao(sc, "Jornada", new String[]{"Continuar", "Desistir"});
                if (escolha == 2) {
                    Arquivo.salvar(jogador, nivel, Historicos.DESISTENCIAS);
                    System.out.println("Você abandonou o Jogo!");
                    return;
                }
            }

            Criar.divisoriaEmbrulho("Você subiu de nível!");
            Criar.divisoriaEmbrulho("Você está no nível " + nivel);

            if (jogador.temPedraEvolucao()) {
                Escolher.evoluirPokemon(sc, jogador);
            }

            Adversario adversario = Escolher.adversario(sc, nivel);
            Partida partida = new Partida();

            partida.iniciar(sc, jogador, adversario);

            if (partida.jogadorPerdeu()) {
                System.out.println("Você perdeu o Jogo!");
                Arquivo.salvar(jogador, nivel, Historicos.DERROTAS);
                return;
            }

            if (nivel >= 3) {
                System.out.println("Você ganhou o Jogo!");
                Arquivo.salvar(jogador, nivel, Historicos.VITORIAS);
                return;
            }

            jogador.adicionarPedraEvolucao();
            nivel++;
        }
    }
}
