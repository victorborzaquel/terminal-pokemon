package utils;

import java.util.List;
import java.util.Scanner;

public final class Imprima {
    private Imprima() {
        throw new IllegalStateException("Utility class");
    }

    private static final Integer TAMANHO = 40;

    public static void divisoria(String texto) {
        final int linha = (TAMANHO - texto.length()) / 2;
        final String divisoria = String.format("%s%s%s", "-".repeat(linha), texto, "-".repeat(linha));

        System.out.println(divisoria);
    }

    public static void divisoria() {
        System.out.println("-".repeat(TAMANHO));
    }

    public static void divisoriaEmbrulho(String texto) {
        divisoria();
        System.out.println(texto);
        divisoria();
    }

    public static void divisoriaEmbrulho(String titulo, List<String> linhas) {
        divisoria(titulo);
        linhas.forEach(System.out::println);
        divisoria();
    }

    public static void divisoriaEmbrulho(String titulo, String... linhas) {
        divisoria(titulo);
        for (String linha : linhas) {
            System.out.println(linha);
        }
        divisoria();
    }

    public static Integer escolhaUmaOpcaoOuVoltar(Scanner sc, String titulo, String subtitulo, String[] opcoes) {
        final String[] todasOpcoes = new String[opcoes.length + 1];
        System.arraycopy(opcoes, 0, todasOpcoes, 0, opcoes.length);
        todasOpcoes[opcoes.length] = "Voltar";
        return escolhaUmaOpcao(sc, titulo, subtitulo, todasOpcoes);
    }

    public static Integer escolhaUmaOpcaoOuVoltar(Scanner sc, String titulo, String[] opcoes) {
        final String[] todasOpcoes = new String[opcoes.length + 1];
        System.arraycopy(opcoes, 0, todasOpcoes, 0, opcoes.length);
        todasOpcoes[opcoes.length] = "Voltar";
        return escolhaUmaOpcao(sc, titulo, SUBTITULO_PADRAO, todasOpcoes);
    }

    public static Integer escolhaUmaOpcao(Scanner sc, String titulo, String[] opcoes) {
        return escolhaUmaOpcao(sc, titulo, SUBTITULO_PADRAO, opcoes);
    }

    private static final String SUBTITULO_PADRAO = "Escolha uma opção";

    public static Integer escolhaUmaOpcao(Scanner sc, String titulo, String subtitulo, String[] opcoes) {
        Imprima.divisoria(titulo.toUpperCase());
        System.out.println(subtitulo);
        Imprima.divisoria();

        for (int i = 0; i < opcoes.length; i++) {
            System.out.printf("%d - %s\n", i + 1, opcoes[i]);
        }

        Imprima.divisoria();
        System.out.print("Escolha: ");
        final int escolha = sc.nextInt();
        Imprima.limparConsole();

        if (escolha > opcoes.length || escolha <= 0) {
            Imprima.opcaoInvalida();
            return escolhaUmaOpcao(sc, titulo, subtitulo, opcoes);
        }

        return escolha;
    }

    public static void opcaoInvalida() {
        System.out.println("Opção inválida!");
    }

    public static void limparConsole() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }
}
