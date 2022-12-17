package services.menus;

import services.telas.Jornada;
import utils.Imprima;

import java.util.Arrays;
import java.util.Scanner;

public final class MenuInicial {

    private MenuInicial() {
        throw new IllegalStateException("Utility class");
    }

    public static void abrir(Scanner sc) {
        while (true) {
            final Opcoes[] opcoes = Opcoes.values();
            final String[] titulos = Opcoes.getTitulos();

            final Integer escolha = Imprima.escolhaUmaOpcao(sc, "Menu", titulos);

            switch (opcoes[escolha - 1]) {
                case INICIAR_PARTIDA -> Jornada.iniciar(sc);
                case HISTORICO -> MenuHistorico.abrir(sc);
                case SAIR -> {
                    return;
                }
                default -> Imprima.opcaoInvalida();
            }
        }
    }

    enum Opcoes {
        INICIAR_PARTIDA("Iniciar partida"),
        HISTORICO("Histórico"),
        SAIR("Sair");

        private final String titulo;

        Opcoes(String titulo) {
            this.titulo = titulo;
        }

        public String getTitulo() {
            return titulo;
        }

        public static String[] getTitulos() {
            return Arrays.stream(Opcoes.values())
                    .map(Opcoes::getTitulo)
                    .toArray(String[]::new);
        }
    }
}
