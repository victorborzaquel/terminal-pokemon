package utils;

import models.Jogador;
import data.Historicos;
import models.Pokemon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {
    private static final String PATH = "src/database/";

    public static void salvar(Jogador jogador, Integer nivel, Historicos historico) {
        String diretorio = PATH + historico.getDiretorio();
        File file = new File(diretorio);

        Pokemon[] pokemons = jogador.getPokemons();

        try {
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.printf("Nome: %s, Level: %d, Pokemons: [ %s, %s, %s ]\n",
                    jogador.getNome(),
                    nivel,
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

    public static void ler(Historicos historico) {
        String diretorio = PATH + historico.getDiretorio();
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

            Criar.divisoriaEmbrulho(historico.getTitulo(), linhas);
        } catch (IOException e) {
            Criar.divisoriaEmbrulho("Erro ao ver historico");
        }
    }
}
