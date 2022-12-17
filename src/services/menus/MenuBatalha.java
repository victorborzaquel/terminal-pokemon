package services.menus;

import models.Adversario;
import models.Jogador;
import utils.Dialogo;
import utils.Escolha;
import utils.Imprima;
import utils.PokemonUtils;

import java.util.Arrays;
import java.util.Scanner;

final public class MenuBatalha {
    public static void abrir(Scanner sc, Jogador jogador, Adversario adversario) {
        while (true) {
            final String TITULO = "Ação";
            final String SUBTITULO = "O que deseja fazer?";
            final Opcoes[] opcoes = Opcoes.values();
            final String[] opcoesTitulos = Opcoes.getTitulos();

            final int escolha = Imprima.escolhaUmaOpcao(sc, TITULO, SUBTITULO, opcoesTitulos);

            switch (opcoes[escolha - 1]) {
                case ATACAR -> {
                    PokemonUtils.atacar(sc, jogador, adversario);
                    return;
                }
                case TROCAR_POKEMON -> {
                    Escolha.trocaPokemon(sc, jogador);
                    return;
                }
                case VER_INVENTARIO -> Escolha.verInventario(jogador);
                default -> Dialogo.opcaoInvalida();
            }
        }
    }

    enum Opcoes {
        ATACAR("Atacar"),
        TROCAR_POKEMON("Trocar Pokemon"),
        VER_INVENTARIO("Ver Inventario");

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
