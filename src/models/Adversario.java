package models;

import data.enums.Especialidades;

public abstract class Adversario extends Treinador{
    private final Especialidades especialidade;
    private final String frase;

    protected Adversario(String nome, Especialidades especialidade, String frase, Pokemon[] pokemons) {
        super(nome, pokemons);
        this.especialidade = especialidade;
        this.frase = frase;

    }

    public Especialidades getEspecialidade() {
        return especialidade;
    }

    public String getFrase() {
        return frase;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", getNome(), especialidade.getNome());
    }
}
