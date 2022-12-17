package data;

public enum Geracoes {
    PRIMEIRA("Primeira Geração", Pokemons.BULBASAUR, Pokemons.CHARMANDER, Pokemons.SQUIRTLE),
    SEGUNDA("Segunda Geração", Pokemons.CYNDAQUIL, Pokemons.TOTODILE, Pokemons.CHIKORITA);

    private final String nome;
    private final Pokemons[] iniciais;

    Geracoes(String nome, Pokemons... iniciais) {
        this.nome = nome;
        this.iniciais = iniciais;
    }

    public String getNome() {
        return nome;
    }

    public Pokemons[] getIniciais() {
        return iniciais;
    }
}
