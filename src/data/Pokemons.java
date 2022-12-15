package data;

public enum Pokemons {
    // Jogador — Geração 1
    BULBASAUR (" Bulbasaur ", Especialidades.PLANTA , 45 , Ataques. TACKLE , Ataques. VINE_WHIP , Ataques. RAZOR_LEAF),
    IVYSAUR (" Ivysaur ", Especialidades.PLANTA , 60 , Ataques. VINE_WHIP , Ataques. RAZOR_LEAF , Ataques. SOLAR_BEAM),
    VENUSAUR (" Venusaur ", Especialidades.PLANTA , 80 , Ataques. VINE_WHIP , Ataques. RAZOR_LEAF , Ataques. SOLAR_BEAM),
    CHARMANDER (" Charmander ", Especialidades.FOGO , 39 , Ataques. SCRATCH , Ataques. EMBER , Ataques. SLASH),
    CHARMELEON (" Charmeleon ", Especialidades.FOGO , 58 , Ataques. EMBER , Ataques.  SLASH , Ataques. FLAMETHROWER),
    CHARIZARD (" Charizard ", Especialidades.FOGO , 78 , Ataques. EMBER , Ataques.  SLASH , Ataques. FLAMETHROWER),
    SQUIRTLE (" Squirtle ", Especialidades.AGUA , 44 , Ataques. TACKLE , Ataques. WATER_GUN , Ataques. BITE),
    WARTORTLE (" Wartortle ", Especialidades.AGUA , 59 , Ataques. BUBBLE , Ataques. SKULL_BASH , Ataques. HYDRO_PUMP),
    BLASTOISE (" Blastoise ", Especialidades.AGUA , 79 , Ataques. BUBBLE , Ataques. SKULL_BASH , Ataques. HYDRO_PUMP),
    // Jogador — Geração 2
    CYNDAQUIL("CYNDAQUIL", Especialidades.PLANTA, 110, Ataques.RAZOR_LEAF, Ataques.RAZOR_LEAF, Ataques.RAZOR_LEAF),
    TOTODILE("TOTODILE", Especialidades.PLANTA, 150, Ataques.RAZOR_LEAF, Ataques.RAZOR_LEAF, Ataques.RAZOR_LEAF),
    CHICORITA("CHICORITA", Especialidades.PLANTA, 170, Ataques.RAZOR_LEAF, Ataques.RAZOR_LEAF, Ataques.RAZOR_LEAF),

    // Jogador — Geração 3
    TORCHIC("TORCHIC", Especialidades.PLANTA, 110, Ataques.RAZOR_LEAF, Ataques.RAZOR_LEAF, Ataques.RAZOR_LEAF),
    MUDKIP("MUDKIP", Especialidades.PLANTA, 150, Ataques.RAZOR_LEAF, Ataques.RAZOR_LEAF, Ataques.RAZOR_LEAF),
    TREECKO("TREECKO", Especialidades.PLANTA, 170, Ataques.RAZOR_LEAF, Ataques.RAZOR_LEAF, Ataques.RAZOR_LEAF);

    private final String nome;
    private final Especialidades especialidade;
    private final Integer vida;
    private final Ataques[] ataques;
    private Pokemons evolucao;

    Pokemons(String nome, Especialidades especialidade, Integer vida, Ataques... ataques) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.vida = vida;
        this.ataques = ataques;
    }

    static {
        CHARMANDER.evolucao = CHARMELEON;
        CHARMELEON.evolucao = CHARIZARD;
        CHARIZARD.evolucao = null;

        SQUIRTLE.evolucao = WARTORTLE;
        WARTORTLE.evolucao = BLASTOISE;
        BLASTOISE.evolucao = null;

        BULBASAUR.evolucao = IVYSAUR;
        IVYSAUR.evolucao = VENUSAUR;
        VENUSAUR.evolucao = null;
    }

    public String getNome() {
        return nome;
    }

    public Especialidades getEspecialidade() {
        return especialidade;
    }

    public Ataques[] getAtaques() {
        return ataques;
    }

    public Integer getVida() {
        return vida;
    }

    public Pokemons getEvolucao() {
        return evolucao;
    }
}