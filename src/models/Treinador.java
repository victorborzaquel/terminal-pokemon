package models;

public abstract class Treinador {
    private final String nome;
    protected final Pokemon[] pokemons;
    protected Pokemon pokemonAtual;
    private Integer vida;

    protected Treinador(String nome, Pokemon[] pokemons) {
        this.nome = nome;
        this.pokemons = pokemons;
        this.vida = 1000;
    }

    public void receberDano(Integer dano) {
        int vidaAtual = this.vida - dano;

        this.vida = Math.max(vidaAtual, 0);
    }

    public void escolherPokemon(Integer indice) {
        pokemonAtual = pokemons[indice];
    }
    public Pokemon[] getPokemons() {
        return this.pokemons;
    }

    public String getNome() {
        return nome;
    }

    public Pokemon getPokemonAtual() {
        return pokemonAtual;
    }

    public Boolean estaVivo() {
        return this.vida > 0;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", nome, vida);
    }
}
