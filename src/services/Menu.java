package services;

import data.Jogador;
import utils.Historico;

import java.util.Scanner;

public class Menu {
    public static void iniciar(Scanner sc, Jogador jogador) {
        System.out.println("Bem vindo ao jogo de pokemons!");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Iniciar partida");
        System.out.println("2 - Ver histórico");
        System.out.println("3 - Sair");
        System.out.print("Escolha: ");
        try {
            int escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    Partida.iniciar(sc, jogador);
                    break;
                case 2:
                    Historico.exibir(sc);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    iniciar(sc, jogador);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Opção inválida!");
        }
    }
}
