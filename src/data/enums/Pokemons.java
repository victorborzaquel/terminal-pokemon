package data.enums;

public enum Pokemons {
    CHARMANDER,
    CHARMELEON,
    CHARIZARD,
    BULBASSAURO,
    IVYSAUR,
    VENUSAUR,
    SQUIRTLE,
    WARTORTLE,
    BLASTOISE;

    private Pokemons EVOLUCAO;

    private void evolucao(Pokemons charizard) {
        this.EVOLUCAO = charizard;
    }

    static {
        CHARMANDER.evolucao(CHARMELEON);
        CHARMELEON.evolucao(CHARIZARD);
        BULBASSAURO.evolucao(IVYSAUR);
        IVYSAUR.evolucao(VENUSAUR);
        SQUIRTLE.evolucao(WARTORTLE);
        WARTORTLE.evolucao(BLASTOISE);
    }

    public Pokemons getEVOLUCAO() {
        return EVOLUCAO;
    }
}
