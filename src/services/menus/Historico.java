package services.menus;

import data.Historicos;
import utils.Arquivo;
import utils.Escolher;

import java.util.Scanner;

public final class Historico {
    static void abrir(Scanner sc) {
        while (true) {
            final Historicos[] historicos = Historicos.values();

            int escolha = Escolher.historico(sc, historicos);

            if (escolha == -1) {
                return;
            }

            Arquivo.ler(historicos[escolha - 1]);
        }
    }
}
