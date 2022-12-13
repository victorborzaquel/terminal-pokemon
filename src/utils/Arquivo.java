package utils;

import errors.NenhumRegistroException;
import models.Jogador;
import data.Historicos;
import models.Pokemon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Arquivo {
    private static final String PATH = "src/database/";

    public static void salvar(Jogador jogador, Historicos historico) {
        try {
            writer(jogador, historico);
        } catch (IOException e) {
            Imprimir.divisoriaEmbrulho("Erro ao salvar historico");
        }
    }

    public static void ler(Historicos historico) {
        try {
            final List<String> linhas = reader(historico);

            Imprimir.divisoriaEmbrulho(historico.getTitulo(), linhas);
        } catch (IOException e) {
            Imprimir.divisoriaEmbrulho("Erro ao ver historico");
        } catch (NenhumRegistroException e) {
            Imprimir.divisoriaEmbrulho("Nenhum registro encontrado");
        }
    }

    private static void writer(Jogador jogador, Historicos historico) throws IOException {
        final Pokemon[] pokemons = jogador.getPokemons();

        final String[] nomesPokemons = Arrays
                .stream(pokemons)
                .map(Pokemon::getNome)
                .toArray(String[]::new);

        final String nomesPokemonsString = Arrays
                .stream(nomesPokemons)
                .reduce((a, b) -> a + ", " + b)
                .map(Object::toString)
                .orElse("");

        final String diretorio = PATH + historico.getDiretorio();
        final File file = new File(diretorio);
        final FileWriter fileWriter = new FileWriter(file, true);
        final PrintWriter printWriter = new PrintWriter(fileWriter);

        final String message = "Nome: %s, Level: %d, Pokemons: [ %s ]\n";
        printWriter.printf(message, jogador.getNome(), jogador.getNivel(), nomesPokemonsString);
        printWriter.flush();
        printWriter.close();
    }

    private static List<String> reader(Historicos historico) throws
            IOException,
            NenhumRegistroException
    {
        final String diretorio = PATH + historico.getDiretorio();
        final File file = new File(diretorio);
        final FileReader fileReader = new FileReader(file);
        final BufferedReader bufferedReader = new BufferedReader(fileReader);
        final List<String> linhas = new ArrayList<>();

        String linha;
        while ((linha = bufferedReader.readLine()) != null) {
            linhas.add(linha);
        }

        fileReader.close();
        bufferedReader.close();

        if (linhas.size() == 0) {
            throw new NenhumRegistroException();
        }

        return linhas;
    }
}
