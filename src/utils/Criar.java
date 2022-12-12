package utils;

import java.util.List;
import java.util.Scanner;

public class Criar {
    private static final Integer TAMANHO = 40;

    public static void divisoria(String texto) {
        int linha = (TAMANHO - texto.length()) / 2;
        String divisoria = String.format("%s%s%s", "-".repeat(linha), texto, "-".repeat(linha));

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

    public static Integer escolhaUmaOpcao(Scanner sc, String titulo, String[] opcoes) {
        String subtitulo = "Escolha uma opção";
        return escolhaUmaOpcao(sc, titulo, subtitulo, opcoes);
    }

    public static Integer escolhaUmaOpcao(Scanner sc, String titulo, List<String> opcoes) {
        String subtitulo = "Escolha uma opção";
        String[] opcoesArray = opcoes.stream().map(String::valueOf).toArray(String[]::new);

        return escolhaUmaOpcao(sc, titulo, subtitulo, opcoesArray);
    }

    public static Integer escolhaUmaOpcao(Scanner sc, String titulo, String subtitulo, String[] opcoes) {
        Criar.divisoria(titulo.toUpperCase());
        System.out.println(subtitulo);
        Criar.divisoria();

        for (int i = 0; i < opcoes.length; i++) {
            System.out.printf("%d - %s\n", i + 1, opcoes[i]);
        }

        Criar.divisoria();
        System.out.print("Escolha: ");
        int escolha = sc.nextInt();
        Console.limpar();

        if (escolha > opcoes.length || escolha <= 0) {
            Criar.opcaoInvalida();
            return escolhaUmaOpcao(sc, titulo, subtitulo, opcoes);
        }

        return escolha;
    }

    public static void opcaoInvalida() {
        System.out.println("Opção inválida!");
    }
}
