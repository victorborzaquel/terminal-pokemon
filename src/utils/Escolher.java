package utils;

import data.Jogador;
import data.enums.Adversarios;
import data.treinadores.Ash;
import data.treinadores.Brock;
import data.treinadores.Misty;
import models.Adversario;
import models.Ataque;
import models.Pokemon;
import models.Treinador;

import java.util.Random;
import java.util.Scanner;

public class Escolher {
    public static Jogador jogador(Scanner sc) {
        System.out.print("Digite o seu nome: ");
        sc.nextLine();
        String nome = sc.nextLine();
        Console.limpar();
        return new Jogador(nome);
    }

    public static void pokemon(Scanner sc, Treinador treinador) {
        Pokemon[] pokemons = treinador.getPokemons();

        Criar.divisoria("Escolha um pokemon");
        for (int i = 0; i < pokemons.length; i++) {
            System.out.println((i + 1) + " - " + pokemons[i].getNome());
        }
        Criar.divisoria();

        System.out.print("Escolha: ");
        int escolha = sc.nextInt();
        Console.limpar();
        treinador.escolherPokemon(escolha - 1);
    }

    public static void pokemon(Treinador treinador) {
        Pokemon[] pokemons = treinador.getPokemons();

        treinador.escolherPokemon(aleatorio(0, pokemons.length - 1));
    }

    public static Ataque ataque(Scanner sc, Pokemon pokemon) {
        Ataque[] ataques = pokemon.getAtaques();

        Ataque ataque = null;

        while (ataque == null) {
            ataqueOpcoes(ataques);
            int escolha = sc.nextInt();
            Console.limpar();
            try {
                ataque = ataques[escolha - 1];
            } catch (Exception e) {
                Criar.divisoriaEmbrulho("Opção inválida!");
            }
        }

        System.out.printf("%s usou %s\n", pokemon.getNome(), ataque.getNome());

        return ataque;
    }

    private static void ataqueOpcoes(Ataque[] ataques) {
        Criar.divisoria("ATACAR");
        System.out.println("Escolha um ataque:");
        Criar.divisoria();
        for (int i = 0; i < ataques.length; i++) {
            System.out.println((i + 1) + " - " + ataques[i].toString());
        }
        Criar.divisoria();
        System.out.print("Escolha: ");
    }
    public static Ataque ataque(Pokemon pokemon) {
        Ataque[] ataques = pokemon.getAtaques();
        Ataque ataque = ataques[aleatorio(0, ataques.length - 1)];
        System.out.println(pokemon.getNome() + " usou " + ataque.getNome());

        return ataque;
    }

    public static Adversario adversario(Scanner sc) {
        Adversarios[] adversarios = Adversarios.values();

        adversarios(adversarios);

        Adversario adversario = null;
        while (adversario == null) {
            int escolha = sc.nextInt();
            Console.limpar();
            try {
                switch (adversarios[escolha - 1]) {
                    case ASH -> adversario = new Ash();
                    case MISTY -> adversario = new Misty();
                    case BROCK -> adversario = new Brock();
                    default -> throw new IllegalArgumentException();
                };
            } catch (IllegalArgumentException e) {
                System.out.println("Adversário inválido!");
            }
        }

        Escolher.pokemon(adversario);

        return adversario;
    }

    public static void adversarios(Adversarios[] adversarios) {
        Criar.divisoria("ADVERSÁRIO");
        System.out.println("Escolha um adversário:");
        Criar.divisoria();
        for (int i = 0; i < adversarios.length; i++) {
            System.out.println((i + 1) + " - " + adversarios[i].toString());
        }
        Criar.divisoria();
        System.out.print("Escolha: ");
    }

    public static Integer aleatorio(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }
}
