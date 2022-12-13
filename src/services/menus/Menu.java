package services.menus;

import services.telas.Jornada;
import utils.Imprimir;

import java.util.Arrays;
import java.util.Scanner;

public final class Menu {
    public static void abrir(Scanner sc) {
        while (true) {
            final Opcoes[] opcoes = Opcoes.values();
            final String[] titulos = Arrays
                    .stream(opcoes)
                    .map(Opcoes::getTitulo)
                    .toArray(String[]::new);

            final Integer escolha = Imprimir.escolhaUmaOpcao(sc, "Menu", titulos);

            switch (opcoes[escolha - 1]) {
                case INICIAR_PARTIDA -> Jornada.iniciar(sc);
                case HISTORICO -> Historico.abrir(sc);
                case SAIR -> {
                    return;
                }
                default -> Imprimir.opcaoInvalida();
            }
        }
    }
}
