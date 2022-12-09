package utils;

import data.Jogador;
import models.Adversario;

public class Criar {
    private static final Integer TAMANHO = 30;

    public static void divisoria(String texto) {
        int linha = (TAMANHO - texto.length()) / 2;
        String divisoria = String.format("%s%s%s", "-".repeat(linha), texto, "-".repeat(linha));

        System.out.println(divisoria);
    }

    public static void divisoria() {
        System.out.println("-".repeat(TAMANHO));
    }

    public static void textoInicial(Jogador jogador, Adversario adversario) {
        Criar.divisoria();
        System.out.printf("%s: %s\n", adversario.getNome(), adversario.getFrase());
        Criar.divisoria();
        System.out.printf("%s (%s)\n", adversario.getNome(), adversario.getPokemonAtual().getNome());
        System.out.printf("%s (%s)\n", jogador.getNome(), jogador.getPokemonAtual().getNome());
        Criar.divisoria();
    }
}
