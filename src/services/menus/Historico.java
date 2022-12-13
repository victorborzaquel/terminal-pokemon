package services.menus;

import data.Historicos;
import utils.Arquivo;
import utils.Imprimir;

import java.util.Arrays;
import java.util.Scanner;

public final class Historico {
    static void abrir(Scanner sc) {
        while (true) {
            final Historicos[] historicos = Historicos.values();
            final String[] titulosHistoricos = Arrays
                    .stream(historicos)
                    .map(Historicos::getTitulo)
                    .toArray(String[]::new);

            final Integer escolha = Imprimir.escolhaUmaOpcao(sc, "Histórico", titulosHistoricos, "Voltar");

            if (escolha >= titulosHistoricos.length + 1) {
                return;
            }

            Arquivo.ler(historicos[escolha - 1]);
        }
    }
}
