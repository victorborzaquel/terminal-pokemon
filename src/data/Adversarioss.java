package data;

import data.treinadores.Ash;
import data.treinadores.Brock;
import data.treinadores.Misty;
import models.Adversario;

public class Adversarioss {
    private static final Adversario[][] ADVERSARIOS = {
            {
                    new Misty(),
                    new Brock(),
                    new Ash()
            },
            {
                    new Brock(),
                    new Ash(),
                    new Misty()
            },
            {
                    new Ash(),
                    new Misty(),
                    new Brock()
            }
    };

    public static Adversario[] getAdversariosPorLevel(Integer level) {
        return ADVERSARIOS[level - 1];
    }
}
