package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    public Integer getIndicePokemonAtual() {
        return indicePokemonAtual;
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

    public Boolean temPokemonMorto() {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.estaMorto()) {
                return true;
            }
        }
        return false;
    }

    public List<Pokemon> getPokemonsMortos() {
        List<Pokemon> pokemonsMortos = new ArrayList<>();

        for (Pokemon pokemon : pokemons) {
            if (pokemon.estaMorto()) {
                pokemonsMortos.add(pokemon);
            }
        }

        return pokemonsMortos;
    }

    @Override
    public String toString() {
        return nome;
    }
}
