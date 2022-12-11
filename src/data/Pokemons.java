package data;

public enum Pokemons {
    CHARMANDER("Charmander", Especialidades.FOGO, 90, new Ataques[]{Ataques.FIRE_FANG, Ataques.FIRE_FANG, Ataques.FIRE_FANG}),
    CHARMELEON("Charmeleon", Especialidades.FOGO, 120, new Ataques[]{Ataques.FIRE_FANG, Ataques.FIRE_FANG, Ataques.FIRE_FANG}),
    CHARIZARD("Charizard", Especialidades.FOGO, 150, new Ataques[]{Ataques.FIRE_FANG, Ataques.FIRE_FANG, Ataques.FIRE_FANG}),

    SQUIRTLE("Squirtle", Especialidades.AGUA, 100, new Ataques[]{Ataques.WATER_GUN, Ataques.WATER_GUN, Ataques.WATER_GUN}),
    WARTORTLE("Wartortle", Especialidades.AGUA, 130, new Ataques[]{Ataques.WATER_GUN, Ataques.WATER_GUN, Ataques.WATER_GUN}),
    BLASTOISE("Blastoise", Especialidades.AGUA, 160, new Ataques[]{Ataques.WATER_GUN, Ataques.WATER_GUN, Ataques.WATER_GUN}),

    BULBASSAURO("Bulbassauro", Especialidades.GRAMA, 110, new Ataques[]{Ataques.RAZOR_LEAF, Ataques.RAZOR_LEAF, Ataques.RAZOR_LEAF}),
    IVYSAURO("Ivysauro", Especialidades.GRAMA, 150, new Ataques[]{Ataques.RAZOR_LEAF, Ataques.RAZOR_LEAF, Ataques.RAZOR_LEAF}),
    VENUSAURO("Venusaur", Especialidades.GRAMA, 170, new Ataques[]{Ataques.RAZOR_LEAF, Ataques.RAZOR_LEAF, Ataques.RAZOR_LEAF});

    private final String nome;
    private final Especialidades especialidade;
    private final Integer vida;
    private final Ataques[] ataques;
    private Pokemons evolucao;

    Pokemons(String nome, Especialidades especialidade, Integer vida, Ataques[] ataques) {
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

        BULBASSAURO.evolucao = IVYSAURO;
        IVYSAURO.evolucao = VENUSAURO;
        VENUSAURO.evolucao = null;
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