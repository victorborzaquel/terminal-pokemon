package data.ataques.nivel1.fogo;

import data.enums.Especialidades;
import models.Ataque;

public class FireFang extends Ataque {
    public FireFang() {
        super(
                "Fire Fang",
                Especialidades.FOGO,
                5,
                40
        );
    }
}
