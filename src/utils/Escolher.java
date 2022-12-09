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
        String nome = sc.nextLine();

        return new Jogador(nome);
    }

    public static void pokemon(Scanner sc, Treinador treinador) {
        Pokemon[] pokemons = treinador.getPokemons();

        System.out.println("Escolha um pokemon:");
        for (int i = 0; i < pokemons.length; i++) {
            System.out.println((i + 1) + " - " + pokemons[i].getNome());
        }
        System.out.print("Escolha: ");
        int escolha = sc.nextInt();

        treinador.escolherPokemon(escolha - 1);
    }

    public static void pokemon(Treinador treinador) {
        Pokemon[] pokemons = treinador.getPokemons();

        treinador.escolherPokemon(aleatorio(0, pokemons.length - 1));
    }

    public static Ataque ataque(Scanner sc, Pokemon pokemon) {
        Ataque[] ataques = pokemon.getAtaques();

        System.out.println("Escolha um ataque:");
        for (int i = 0; i < ataques.length; i++) {
            System.out.println((i + 1) + " - " + ataques[i].toString());
        }
        System.out.print("Escolha: ");
        int escolha = sc.nextInt();
        System.out.println("-----------------------");
        Ataque ataque = ataques[escolha - 1];
        System.out.printf("%s usou %s\n", pokemon.getNome(), ataque.getNome());

        return ataque;
    }

    public static Ataque ataque(Pokemon pokemon) {
        Ataque[] ataques = pokemon.getAtaques();
        Ataque ataque = ataques[aleatorio(0, ataques.length - 1)];
        System.out.println(pokemon.getNome() + " usou " + ataque.getNome());

        return ataque;
    }

    public static Adversario adversario(Scanner sc) {
        System.out.println("Escolha um adversário:");
        Adversarios[] adversarios = Adversarios.values();
        for (int i = 0; i < adversarios.length; i++) {
            System.out.println((i + 1) + " - " + adversarios[i].toString());
        }
        System.out.print("Escolha: ");
        int escolha = sc.nextInt();

        Adversario adversario;
        switch (adversarios[escolha - 1]) {
            case ASH:
                adversario = new Ash();
                break;
            case MISTY:
                adversario = new Misty();
                break;
            case BROCK:
                adversario = new Brock();
                break;
            default:
                throw new IllegalArgumentException("Adversário inválido");
        }
        Escolher.pokemon(adversario);

        return adversario;
    }

    public static Integer aleatorio(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }
}
