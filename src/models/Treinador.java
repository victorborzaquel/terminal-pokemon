package models;

public abstract class Treinador {
    private final String nome;
    protected final Pokemon[] pokemons;
    protected Integer indicePokemonAtual;

    protected Treinador(String nome, Pokemon[] pokemons) {
        this.nome = nome;
        this.pokemons = pokemons;
    }

    public void definirPokemonBatalha(Integer indice) {
        indicePokemonAtual = indice;
    }

    public Pokemon getPokemon(Integer indice) {
        return this.pokemons[indice];
    }

    public Pokemon[] getPokemons() {
        return this.pokemons;
    }

    public String getNome() {
        return nome;
    }

    public void restaurarVidaTodosPokemons() {
        for (Pokemon pokemon : pokemons) {
            pokemon.restaurarVida();
        }
    }

    public Pokemon getPokemonAtual() {
        return pokemons[indicePokemonAtual];
    }

    public Boolean pokemonAtualEstaMorto() {
        return pokemons[indicePokemonAtual].estaMorto();
    }

    public Boolean estaMorto() {
        for (Pokemon pokemon : pokemons) {
            if (!pokemon.estaMorto()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
}
