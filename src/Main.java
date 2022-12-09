import data.Jogador;
import services.Menu;
import services.Partida;
import utils.Escolher;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Jogador jogador = Escolher.jogador(sc);
        Menu.iniciar(sc);
        Partida.iniciar(sc, jogador);
        sc.close();
    }
}
