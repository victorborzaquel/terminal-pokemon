package data;

public enum Adversarios {
    MISTY( 1, "Misty", Especialidades.AGUA, "Valoriza a força!", Pokemons.BULBASSAURO,Pokemons.SQUIRTLE,Pokemons.CHARMANDER),
    BROCK( 1,"Brock", Especialidades.GRAMA, "Valoriza a força!", Pokemons.BULBASSAURO,Pokemons.SQUIRTLE,Pokemons.CHARMANDER),
    ASH(2,"Ash", Especialidades.FOGO, "Valoriza a força!", Pokemons.BULBASSAURO,Pokemons.SQUIRTLE,Pokemons.CHARMANDER),
    JOAO(2,"Ash", Especialidades.FOGO, "Valoriza a força!", Pokemons.BULBASSAURO,Pokemons.SQUIRTLE,Pokemons.CHARMANDER);

    private final Integer nivel;
    private final String nome;
    private final Especialidades especialidade;
    private final String frase;
    private final Pokemons[] pokemons;

    Adversarios(Integer nivel, String name, Especialidades especialidade, String frase, Pokemons... pokemons) {
        this.nivel = nivel;
        this.nome = name;
        this.especialidade = especialidade;
        this.frase = frase;
        this.pokemons = pokemons;
    }

    public String getNome() {
        return nome;
    }

    public Especialidades getEspecialidade() {
        return especialidade;
    }

    public String getFrase() {
        return frase;
    }

    public Pokemons[] getPokemons() {
        return pokemons;
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", nome, especialidade);
    }
}
