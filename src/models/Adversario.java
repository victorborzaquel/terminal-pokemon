package models;

import data.Especialidades;

public class Adversario extends Treinador{
    private final Especialidades especialidade;
    private final String frase;

    public Adversario(String nome, Especialidades especialidade, String frase, Pokemon[] pokemons) {
        super(nome, pokemons);
        this.especialidade = especialidade;
        this.frase = frase;

    }

    public String getFrase() {
        return frase;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", getNome(), especialidade.getNome());
    }
}
