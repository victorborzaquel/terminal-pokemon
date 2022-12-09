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
        System.out.println("Você quer ver as vitórias ou derrotas?");
        System.out.println("1 - Vitórias");
        System.out.println("2 - Derrotas");
        System.out.println("3 - Voltar");
        System.out.print("Escolha: ");
        try {
            int escolha = sc.nextInt();
            if (escolha > 3 || escolha < 1) {
               throw new Exception();
            }

            switch (escolha) {
                case 1:
                    ler(Historicos.VITORIAS);
                    break;
                case 2:
                    ler(Historicos.DERROTAS);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Escolha inválida!");
            exibir(sc);
        }
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
            System.out.println("Erro ao salvar historico");
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

            Criar.divisoria(historico.getTitulo());
            linhas.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Erro ao ver historico");
        }
    }
}
