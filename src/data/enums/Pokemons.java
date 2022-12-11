package data.enums;

import models.Ataque;

public enum Pokemons {
    CHARMANDER("Charmander", Especialidades.FOGO, new Ataques[]{Ataques.FIRE_FANG, Ataques.FIRE_FANG, Ataques.FIRE_FANG}),
    CHARMELEON("Charmeleon", Especialidades.FOGO, new Ataques[]{Ataques.FIRE_FANG, Ataques.FIRE_FANG, Ataques.FIRE_FANG}),
    CHARIZARD("Charizard", Especialidades.FOGO, new Ataques[]{Ataques.FIRE_FANG, Ataques.FIRE_FANG, Ataques.FIRE_FANG}),

    SQUIRTLE("Squirtle", Especialidades.AGUA, new Ataques[]{Ataques.WATER_GUN, Ataques.WATER_GUN, Ataques.WATER_GUN}),
    WARTORTLE("Wartortle", Especialidades.AGUA, new Ataques[]{Ataques.WATER_GUN, Ataques.WATER_GUN, Ataques.WATER_GUN}),
    BLASTOISE("Blastoise", Especialidades.AGUA, new Ataques[]{Ataques.WATER_GUN, Ataques.WATER_GUN, Ataques.WATER_GUN}),

    BULBASSAURO("Bulbassauro", Especialidades.GRAMA, new Ataques[]{Ataques.RAZOR_LEAF, Ataques.RAZOR_LEAF, Ataques.RAZOR_LEAF}),
    IVYSAURO("Ivysauro", Especialidades.GRAMA, new Ataques[]{Ataques.RAZOR_LEAF, Ataques.RAZOR_LEAF, Ataques.RAZOR_LEAF}),
    VENUSAURO("Venusaur", Especialidades.GRAMA, new Ataques[]{Ataques.RAZOR_LEAF, Ataques.RAZOR_LEAF, Ataques.RAZOR_LEAF});

    private final String nome;
    private final Especialidades especialidade;
    private final Ataques[] ataques;
    private Pokemons evolucao;

    Pokemons(String nome, Especialidades especialidade, Ataques[] ataques) {
        this.nome = nome;
        this.especialidade = especialidade;
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

    public Pokemons getEvolucao() {
        return evolucao;
    }
}