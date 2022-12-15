import errors.PedraEvolucaoException;
import errors.PokemonException;
import services.menus.Menu;
import utils.Dialogo;

import java.util.Scanner;

public final class Main {
    public static void main(String[] args) {
        Dialogo.boasVindas();

        Scanner sc = new Scanner(System.in);
        Menu.abrir(sc);
        sc.close();
    }
}
