package services.menus;

import data.Historicos;
import utils.Arquivo;
import utils.Escolha;

import java.util.Scanner;

public final class MenuHistorico {

    private MenuHistorico() {
        throw new IllegalStateException("Utility class");
    }

    static void abrir(Scanner sc) {
        while (true) {
            final Historicos[] historicos = Historicos.values();

            int escolha = Escolha.historico(sc, historicos);

            if (escolha == -1) {
                return;
            }

            Arquivo.ler(historicos[escolha - 1]);
        }
    }
}
