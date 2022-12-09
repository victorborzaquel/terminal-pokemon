package services;

import data.Jogador;
import utils.Console;
import utils.Criar;
import utils.Escolher;
import utils.Historico;

import java.util.Scanner;

public class Jogo {
    public static void iniciar(Scanner sc) {
        Criar.divisoriaEmbrulho("Bem vindo ao jogo de pokemons!");

        while (true) {
            opcoes();
            System.out.print("Escolha: ");
            try {
                int escolha = sc.nextInt();
                Console.limpar();
                switch (escolha) {
                    case 1 -> Partida.iniciar(sc);
                    case 2 -> Historico.exibir(sc);
                    case 3 -> System.exit(0);
                    default -> throw new Exception();
                }
            } catch (Exception e) {
                Criar.divisoriaEmbrulho("Opção inválida!");
            }
        }
    }

    private static void opcoes() {
        Criar.divisoria("MENU");
        System.out.println("Escolha uma opção");
        Criar.divisoria();
        System.out.println("1 - Iniciar partida");
        System.out.println("2 - Ver histórico");
        System.out.println("3 - Sair");
        Criar.divisoria();
    }
}
