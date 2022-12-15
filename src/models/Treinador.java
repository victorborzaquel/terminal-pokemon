package models;

import java.util.*;

public abstract class Treinador {
    protected final String nome;
    protected final Pokemon[] pokemons;
    protected int indicePokemonAtual;
    protected int nivel;

    protected Treinador(String nome, int nivel, Pokemon... pokemons) {
        this.nome = nome;
        this.nivel = nivel;
        this.pokemons = pokemons;
    }

    public int getNivel() {
        return nivel;
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

    public Boolean pokemonAtualEstaVivo() {
        return !pokemonAtualEstaMorto();
    }

    public Boolean estaMorto() {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.estaVivo()) {
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

    public Map<Integer, Pokemon> getPokemonsMortos() {
        Map<Integer, Pokemon> pokemonsMortos = new HashMap<>();

        for (int i = 0; i < pokemons.length; i++) {
            if (pokemons[i].estaMorto()) {
                pokemonsMortos.put(i, pokemons[i]);
            }
        }

        return pokemonsMortos;
    }

    @Override
    public String toString() {
        return nome;
    }
}
