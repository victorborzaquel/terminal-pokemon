package services;

import data.enums.Historicos;
import models.Pokemon;
import utils.Arquivo;
import utils.Criar;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    public static void inicial(Scanner sc) {
        while (true) {
            Integer escolha = Criar.escolhaUmaOpcao(sc, "Menu", new String[]{"Iniciar partida", "Ver histórico", "Sair"});

            switch (escolha) {
                case 1 -> new Jornada().iniciar(sc);
                case 2 -> Menu.historico(sc);
                case 3 -> {
                    return;
                }
                default -> Criar.opcaoInvalida();
            }
        }
    }

    public static void historico(Scanner sc) {
        while (true) {
            Integer escolha = Criar.escolhaUmaOpcao(sc, "Histórico", new String[]{"Vitórias", "Derrotas", "Desistencias", "Voltar"});

            switch (escolha) {
                case 1 -> Arquivo.ler(Historicos.VITORIAS);
                case 2 -> Arquivo.ler(Historicos.DERROTAS);
                case 3 -> Arquivo.ler(Historicos.DESISTENCIAS);
                case 4 -> {
                    return;
                }
                default -> Criar.opcaoInvalida();
            }
        }
    }
}
