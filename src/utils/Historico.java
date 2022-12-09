package utils;

import data.Jogador;
import data.enums.Historicos;
import models.Pokemon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Historico {
    public static void exibir(Scanner sc) {
        while (true) {
            opcoes();
            System.out.print("Escolha: ");
            int escolha = sc.nextInt();
            Console.limpar();
            try {
                switch (escolha) {
                    case 1 -> ler(Historicos.VITORIAS);
                    case 2 -> ler(Historicos.DERROTAS);
                    case 3 -> {
                        return;
                    }
                    default -> throw new Exception();
                }
            } catch (Exception e) {
                Criar.divisoriaEmbrulho("Escolha inválida!");
            }
        }
    }
    private static void opcoes() {
        Criar.divisoria("HISTÓRICO");
        System.out.println("Você quer ver as vitórias ou derrotas?");
        Criar.divisoria();
        System.out.println("1 - Vitórias");
        System.out.println("2 - Derrotas");
        System.out.println("3 - Voltar");
        Criar.divisoria();
    }
    public static void salvar(Jogador jogador, Historicos historico) {
        String diretorio = "src/historico/" + historico.getDiretorio();
        File file = new File(diretorio);

        Pokemon[] pokemons = jogador.getPokemons();

        try {
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.printf("Nome: %s, Level: %d, Pokemons: [ %s, %s, %s ]\n",
                    jogador.getNome(),
                    jogador.getNivel(),
                    pokemons[0].getNome(),
                    pokemons[1].getNome(),
                    pokemons[2].getNome()
            );
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            Criar.divisoriaEmbrulho("Erro ao salvar historico");
        }
    }

    private static void ler(Historicos historico) {
        String diretorio = "src/historico/" + historico.getDiretorio();
        File file = new File(diretorio);
        List<String> linhas = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                linhas.add(linha);
            }
            fileReader.close();
            bufferedReader.close();

            if (linhas.size() == 0) {
                Criar.divisoriaEmbrulho("Nenhum registro encontrado!");
                return;
            }

            Criar.divisoria(historico.getTitulo());
            linhas.forEach(System.out::println);
            Criar.divisoria();
        } catch (IOException e) {
            Criar.divisoriaEmbrulho("Erro ao ver historico");
        }
    }
}
