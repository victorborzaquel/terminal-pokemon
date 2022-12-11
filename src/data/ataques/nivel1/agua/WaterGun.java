package data.ataques.nivel1.agua;

import data.enums.Especialidades;
import models.Ataque;

public class WaterGun extends Ataque {
    public WaterGun() {
        super(
                "WaterGun",
                Especialidades.AGUA,
                20,
                30
        );
    }
}
