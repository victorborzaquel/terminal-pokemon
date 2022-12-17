import services.menus.MenuInicial;
import utils.Dialogo;

import java.util.Scanner;

public final class Main {
    public static void main(String[] args) {
        Dialogo.boasVindas();

        Scanner sc = new Scanner(System.in);
        MenuInicial.abrir(sc);
        sc.close();
    }
}
