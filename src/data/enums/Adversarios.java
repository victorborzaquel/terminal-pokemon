package data.enums;

public enum Adversarios {
    MISTY( 1, "Misty", Especialidades.AGUA, "Valoriza a força!", new Pokemons[]{Pokemons.BULBASSAURO,Pokemons.SQUIRTLE,Pokemons.CHARMANDER}),
    BROCK( 1,"Brock", Especialidades.GRAMA, "Valoriza a força!", new Pokemons[]{Pokemons.BULBASSAURO,Pokemons.SQUIRTLE,Pokemons.CHARMANDER}),
    ASH(1,"Ash", Especialidades.FOGO, "Valoriza a força!", new Pokemons[]{Pokemons.BULBASSAURO,Pokemons.SQUIRTLE,Pokemons.CHARMANDER});

    private final Integer nivel;
    private final String nome;
    private final Especialidades tipo;
    private final String frase;
    private final Pokemons[] pokemons;

    Adversarios(Integer nivel, String name, Especialidades type, String frase, Pokemons[] pokemons) {
        this.nivel = nivel;
        this.nome = name;
        this.tipo = type;
        this.frase = frase;
        this.pokemons = pokemons;
    }

    public String getNome() {
        return nome;
    }

    public Especialidades getTipo() {
        return tipo;
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
}
