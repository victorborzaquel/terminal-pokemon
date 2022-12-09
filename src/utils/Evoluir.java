package utils;

import data.Jogador;
import models.Pokemon;

import java.util.Scanner;

public class Evoluir {
    public static void pokemon(Scanner sc, Jogador jogador) {
        while (true) {
            opcoes();
            try {
                int escolha = sc.nextInt();
                Console.limpar();
                switch (escolha) {
                    case 1 -> {
                        evoluirPokemon(jogador);
                        return;
                    }
                    case 2 -> {
                        return;
                    }
                    default -> throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Opção inválida!");
            }
        }
    }

    private static void evoluirPokemon(Jogador jogador) {
        Pokemon pokemon = jogador.getPokemonAtual();
        String anterior = pokemon.getNome();
        String evolucao = pokemon.getEvolucao().getNome();

        jogador.evoluirPokemon();
        System.out.println("Seu pokemon " + anterior + " evoluiu para " + evolucao + "!");
    }
    private static void opcoes() {
        Criar.divisoria("EVOLUIR");
        System.out.println("Você tem uma pedra de evolução!");
        System.out.println("Deseja evoluir seu pokemon?");
        Criar.divisoria();
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        Criar.divisoria();
        System.out.print("Escolha: ");
    }
}
