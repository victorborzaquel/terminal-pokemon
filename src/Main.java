import services.Menu;
import utils.Console;
import utils.Criar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Console.limpar();

        Criar.divisoriaEmbrulho("Bem vindo ao jogo de pokemons!");
        Menu.inicial(sc);

        sc.close();
    }
}
