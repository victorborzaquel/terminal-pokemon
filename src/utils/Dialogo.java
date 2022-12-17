package utils;

import models.Adversario;
import models.Jogador;
import models.Pokemon;
import models.Treinador;

public final class Dialogo {
    private Dialogo() {
        throw new IllegalStateException("Utility class");
    }

    public static void opcaoInvalida() {
        Imprima.divisoriaEmbrulho("Opção inválida");
    }

    public static void fraseAdversario(Adversario adversario) {
        Imprima.divisoriaEmbrulho(String.format("%s: %s%n", adversario.getNome(), adversario.getFrase()));
    }

    public static void resultadoAtaque(Treinador alvo, int ataque) {
        System.out.printf("%s recebeu %d de dano%n", alvo.getPokemonAtual().getNome(), ataque);
    }

    public static void resumoBatalha(Jogador jogador, Adversario adversario) {
        Imprima.divisoriaEmbrulho("treinadores", vidaPokemon(jogador), vidaPokemon(adversario));
    }

    private static String vidaPokemon(Treinador treinador) {
        Pokemon pokemon = treinador.getPokemonAtual();
        return String.format("%s : %s (%d)", treinador.getNome(), pokemon.getNome(), pokemon.getVida());
    }

    public static void boasVindas() {
        Imprima.limparConsole();
        Imprima.divisoriaEmbrulho("Bem vindo ao jogo de pokemons!");
    }

    public static void iniciandoJornada() {
        Imprima.divisoriaEmbrulho("Começando uma nova jornada...");
    }

    public static void mostrarNivelJogador(Jogador jogador) {
        Imprima.divisoriaEmbrulho("Você está no nível " + jogador.getNivel());
    }

    public static void perdeuJogo() {
        System.out.println("Você perdeu o Jogo!");
    }

    public static void ganhouJogo(Jogador jogador) {
        Imprima.limparConsole();
        Imprima.divisoria("PARABÉNS");
        System.out.printf("%s, você ganhou o Jogo!%n", jogador.getNome());
        System.out.println("Obrigado por jogar, até a próxima!");
    }

    public static void ganhouPartida() {
        Imprima.divisoriaEmbrulho("Você ganhou a partida!");
        Imprima.divisoriaEmbrulho(
                "PARABENS",
                "Você subiu de nível!",
                "Ganhou uma pedra de evolução!",
                "Seu revive foi restaurado!"
        );
    }

    public static void pokemonMorreu(Jogador jogador) {
        System.out.printf("%s está morto!%n", jogador.getPokemonAtual().getNome());
        System.out.println("Você perdeu a batalha!");
    }

    public static void pokemonMorreu(Adversario adversario) {
        System.out.printf("%s está morto!%n", adversario.getPokemonAtual().getNome());
        System.out.println("Você ganhou a batalha!");
    }
}
